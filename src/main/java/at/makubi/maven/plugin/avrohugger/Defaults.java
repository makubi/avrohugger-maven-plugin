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

package at.makubi.maven.plugin.avrohugger;

import at.makubi.maven.plugin.avrohugger.typeoverride.TypeOverrides;

import java.util.Collections;
import java.util.List;

interface Defaults {
    /** Relative to ${basedir} */
    String relativeSourceDirectory = "src/main/avro";
    /** Relative to ${project.build.directory} */
    String relativeOutputDirectory = "generated-sources/avro";
    String recursive = "false";
    String limitedNumberOfFieldsInCaseClasses = "false";
    String sourceGenerationFormat = "SPECIFIC_RECORD";
    List<FileInclude> fileIncludes = Collections.singletonList(new FileInclude("**", MatchSyntax.GLOB));
    TypeOverrides typeOverrides = new TypeOverrides();
}
