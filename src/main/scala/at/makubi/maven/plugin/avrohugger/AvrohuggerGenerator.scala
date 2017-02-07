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

import at.makubi.maven.plugin.avrohugger.Implicits._
import avrohugger.Generator
import avrohugger.format.SpecificRecord
import com.julianpeeters.avrohugger.filesorter.AVSCFileSorter
import org.apache.maven.plugin.logging.Log

class AvrohuggerGenerator {

  def generateScalaFiles(inputDirectory: File, outputDirectory: String, log: Log): Unit =
    generateScalaFiles(inputDirectory, outputDirectory, log, false)

  def generateScalaFiles(inputDirectory: File, outputDirectory: String, log: Log, recursive: Boolean): Unit = {
    val generator = new Generator(SpecificRecord)

    val allFiles = inputDirectory.listFiles()

    val avdlFiles = allFiles.withSuffix(".avdl")
    val avscFiles = AVSCFileSorter.sortSchemaFiles(allFiles.withSuffix(".avsc"))
    val avprFiles = allFiles.withSuffix(".avpr")
    val avroFiles = allFiles.withSuffix(".avro")

    (avdlFiles ++ avscFiles ++ avprFiles ++ avroFiles).foreach { schemaFile =>
      log.info(s"Generating Scala files for ${schemaFile.getAbsolutePath}")

      generator.fileToFile(schemaFile, outputDirectory)
    }
  }

}
