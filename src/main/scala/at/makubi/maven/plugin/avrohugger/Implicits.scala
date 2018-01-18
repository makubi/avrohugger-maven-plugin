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

import avrohugger.types.AvroScalaTypes

object Implicits {

  implicit class AvroScalaTypesOps(avroScalaTypes: AvroScalaTypes) {
    def withOptionalArrayType(optionalArray: avrohugger.types.AvroScalaArrayType): AvroScalaTypes =
      nonNullOrDefault(optionalArray)(array => avroScalaTypes.copy(array = array))

    def withOptionalEnumType(optionalEnum: avrohugger.types.AvroScalaEnumType): AvroScalaTypes =
      nonNullOrDefault(optionalEnum)(enum => avroScalaTypes.copy(enum = enum))

    private def nonNullOrDefault[T](maybeNull: T)(f: T => AvroScalaTypes): AvroScalaTypes = {
      Option(maybeNull).map { t =>
        f(t)
      }.getOrElse(avroScalaTypes)
    }
  }

  implicit class FileArrayEnricher(files: Array[File]) {

    def withSuffix(suffix: String): Array[File] = {
      files.filter(_.getName.endsWith(suffix))
    }
  }

}
