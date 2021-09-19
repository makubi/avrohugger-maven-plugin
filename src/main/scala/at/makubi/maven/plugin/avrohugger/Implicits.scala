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

    def withOptionalFixedType(optionalFixed: avrohugger.types.AvroScalaFixedType): AvroScalaTypes =
      nonNullOrDefault(optionalFixed)(fixed => avroScalaTypes.copy(fixed = fixed))

    def withOptionalMapType(optionalMap: avrohugger.types.AvroScalaMapType): AvroScalaTypes =
      nonNullOrDefault(optionalMap)(map => avroScalaTypes.copy(map = map))

    def withOptionalProtocolType(optionalProtocol: avrohugger.types.AvroScalaProtocolType): AvroScalaTypes =
      nonNullOrDefault(optionalProtocol)(protocol => avroScalaTypes.copy(protocol = protocol))

    def withOptionalRecordType(optionalRecord: avrohugger.types.AvroScalaRecordType): AvroScalaTypes =
      nonNullOrDefault(optionalRecord)(record => avroScalaTypes.copy(record = record))

    def withOptionalUnionType(optionalUnion: avrohugger.types.AvroScalaUnionType): AvroScalaTypes =
      nonNullOrDefault(optionalUnion)(union => avroScalaTypes.copy(union = union))


    def withOptionalBooleanType(optionalBoolean: avrohugger.types.AvroScalaBooleanType): AvroScalaTypes =
      nonNullOrDefault(optionalBoolean)(boolean => avroScalaTypes.copy(boolean = boolean))

    def withOptionalBytesType(optionalBytes: avrohugger.types.AvroScalaBytesType): AvroScalaTypes =
      nonNullOrDefault(optionalBytes)(bytes => avroScalaTypes.copy(bytes = bytes))

    def withOptionalDoubleType(optionalDouble: avrohugger.types.AvroScalaNumberType): AvroScalaTypes =
      nonNullOrDefault(optionalDouble)(double => avroScalaTypes.copy(double = double))

    def withOptionalFloatType(optionalFloat: avrohugger.types.AvroScalaNumberType): AvroScalaTypes =
      nonNullOrDefault(optionalFloat)(float => avroScalaTypes.copy(float = float))

    def withOptionalIntType(optionalInt: avrohugger.types.AvroScalaNumberType): AvroScalaTypes =
      nonNullOrDefault(optionalInt)(int => avroScalaTypes.copy(int = int))

    def withOptionalLongType(optionalLong: avrohugger.types.AvroScalaNumberType): AvroScalaTypes =
      nonNullOrDefault(optionalLong)(long => avroScalaTypes.copy(long = long))

    def withOptionalNullType(optionalNull: avrohugger.types.AvroScalaNullType): AvroScalaTypes =
      nonNullOrDefault(optionalNull)(`null` => avroScalaTypes.copy(`null` = `null`))

    def withOptionalStringType(optionalString: avrohugger.types.AvroScalaStringType): AvroScalaTypes =
      nonNullOrDefault(optionalString)(string => avroScalaTypes.copy(string = string))

    def withOptionalTimestampMillisType(optionalTimestampMillis: avrohugger.types.AvroScalaTimestampMillisType): AvroScalaTypes =
      nonNullOrDefault(optionalTimestampMillis)(timestampMillis => avroScalaTypes.copy(timestampMillis = timestampMillis))

    private def nonNullOrDefault[T](maybeNull: T)(f: T => AvroScalaTypes): AvroScalaTypes = {
      Option(maybeNull).map { t =>
        f(t)
      }.getOrElse(avroScalaTypes)
    }
  }

  implicit class FileArrayEnricher(files: Seq[File]) {

    def withSuffix(suffix: String): Seq[File] = {
      files.filter(_.getName.endsWith(suffix))
    }
  }

}
