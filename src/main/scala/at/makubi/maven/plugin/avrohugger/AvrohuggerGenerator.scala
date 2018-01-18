/*
 * Copyright 2016 the original author or authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package at.makubi.maven.plugin.avrohugger

import java.io.File
import java.nio.file.{FileSystems, Path}

import at.makubi.maven.plugin.avrohugger.Implicits._
import avrohugger.Generator
import avrohugger.filesorter.{AvdlFileSorter, AvscFileSorter}
import avrohugger.format.{Scavro, SpecificRecord, Standard}
import org.apache.maven.plugin.logging.Log
import java.util

import collection.JavaConverters._
import scala.collection.JavaConversions._
import scala.collection.mutable.ListBuffer

class AvrohuggerGenerator {

  def generateScalaFiles(inputDirectory: File,
                         outputDirectory: String,
                         log: Log,
                         recursive: Boolean,
                         limitedNumberOfFieldsInCaseClasses: Boolean,
                         sourceGenerationFormat: SourceGenerationFormat,
                         namespaceMappings: util.List[Mapping],
                         fileIncludes: java.util.List[FileInclude],
                         typeOverrides: TypeOverrides): Unit = {
    val filter = { pathname: File =>
      val filePathRelativeToInputDirectory = inputDirectory.toPath.relativize(pathname.toPath)
      log.debug(s"Path ${pathname.toString} relative to input directory ${inputDirectory.toString} is $filePathRelativeToInputDirectory")

      fileIncludes.exists { include =>
        log.debug(s"Testing include ${include.getPath} with match syntax ${include.getMatchSyntax}")
        accept(filePathRelativeToInputDirectory, include)
      }
    }

    val sourceFormat = sourceGenerationFormat match {
      case SourceGenerationFormat.SCAVRO => Scavro
      case SourceGenerationFormat.SPECIFIC_RECORD => SpecificRecord
      case SourceGenerationFormat.STANDARD => Standard
    }

    val mappings = namespaceMappings.asScala.map { m => m.from -> m.to }.toMap

    val customTypes = sourceFormat.defaultTypes
      .withOptionalArrayType(typeOverrides.getArrayType)
      .withOptionalEnumType(typeOverrides.getEnumType)

    val generator = new Generator(
      format = sourceFormat,
      restrictedFieldNumber = limitedNumberOfFieldsInCaseClasses,
      avroScalaCustomNamespace = mappings,
      avroScalaCustomTypes = if (customTypes != sourceFormat.defaultTypes) Some(customTypes) else None
    )

    listFiles(inputDirectory, recursive).filter(filter).foreach { schemaFile =>
      log.info(s"Generating Scala files for ${schemaFile.getAbsolutePath}")

      generator.fileToFile(schemaFile, outputDirectory)
    }
  }

  protected def listFiles(inputDirectory: File, recursive: Boolean): Seq[File] = {
    val allFiles = inputDirectory.listFiles()
    val schemaFiles = new ListBuffer[File]()

    schemaFiles ++= AvdlFileSorter.sortSchemaFiles(allFiles.withSuffix(".avdl"))
    schemaFiles ++= AvscFileSorter.sortSchemaFiles(allFiles.withSuffix(".avsc"))
    schemaFiles ++= allFiles.withSuffix(".avpr")
    schemaFiles ++= allFiles.withSuffix(".avro")

    if (recursive) {
      schemaFiles ++= allFiles.filter { _.isDirectory }.flatMap { listFiles(_, true) }
    }

    schemaFiles
  }

  protected def accept(filePathRelativeToInputDirectory: Path, fileInclude: FileInclude): Boolean = {
    val pathText = fileInclude.getPath
    val matchSyntax = fileInclude.getMatchSyntax

    matchSyntax match {
      case MatchSyntax.STRING =>
        acceptString(filePathRelativeToInputDirectory, pathText)
      case MatchSyntax.GLOB =>
        acceptGlob(filePathRelativeToInputDirectory, pathText)
      case MatchSyntax.REGEX =>
        acceptRegex(filePathRelativeToInputDirectory, pathText)
    }
  }

  protected def acceptString(filePathRelativeToInputDirectory: Path, pathText: String): Boolean =
    filePathRelativeToInputDirectory.toString == pathText

  protected def acceptRegex(filePathRelativeToInputDirectory: Path, pathText: String): Boolean =
    filePathRelativeToInputDirectory.toString.matches(pathText)

  protected def acceptGlob(filePathRelativeToInputDirectory: Path, pathText: String): Boolean =
    FileSystems.getDefault.getPathMatcher("glob:" + pathText).matches(filePathRelativeToInputDirectory)

}
