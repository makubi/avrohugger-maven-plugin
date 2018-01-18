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

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import static at.makubi.maven.plugin.avrohugger.TestHelper.failTestIfFilesDiffer;

public class GeneratorMojoTest extends AbstractHarnessMojoTestCase {

    final Path testResourcesDir = Paths.get("src/test/resources/unit/avrohugger-maven-plugin/mojo");

    // ${basedir}
    final Path testRunnerBaseDir = Paths.get("target/test-harness/avrohugger-maven-plugin");
    // ${project.build.directory}
    final Path testRunnerProjectBuildDir = testRunnerBaseDir.resolve("target");

    @Before
    public void setUp() throws Exception {
        super.setUp();

        FileUtils.deleteDirectory(testRunnerBaseDir.toFile());
        createDir(testRunnerBaseDir);
    }

    public void testGenerateScalaSourcesWithDefaultSettings() throws Exception {
        final Path defaultTestResourcesDir = testResourcesDir.resolve("default");

        final Path testAvroSourceDir = testRunnerBaseDir.resolve(Defaults.relativeSourceDirectory);
        final Path testAvroSourceSubDir = testAvroSourceDir.resolve("subdir");

        final Path apiAvdl = Paths.get("Api.avdl");
        final Path subApiAvdl = Paths.get("SubApi.avdl");
        final Path recordWith25FieldsAvdl = Paths.get("RecordWith25Fields.avdl");
        final String testPomName = "pom-defaults.xml";

        createDir(testAvroSourceDir);
        createDir(testAvroSourceSubDir);

        // Copy pom
        Path srcPom = defaultTestResourcesDir.resolve(testPomName);
        Path pomPath = testRunnerBaseDir.resolve(testPomName);
        Files.copy(srcPom, pomPath, StandardCopyOption.REPLACE_EXISTING);

        // Copy AVDL files
        Files.copy(testResourcesDir.resolve(apiAvdl), testAvroSourceDir.resolve(apiAvdl), StandardCopyOption.REPLACE_EXISTING);
        Files.copy(testResourcesDir.resolve(subApiAvdl), testAvroSourceSubDir.resolve(subApiAvdl), StandardCopyOption.REPLACE_EXISTING);
        Files.copy(testResourcesDir.resolve(recordWith25FieldsAvdl), testAvroSourceDir.resolve(recordWith25FieldsAvdl), StandardCopyOption.REPLACE_EXISTING);

        GeneratorMojo generatorMojo = (GeneratorMojo) lookupMojo(pomPath, "generate-scala-sources");
        generatorMojo.execute();

        // Test 'sourceDirectory', 'outputDirectory' and 'sourceGenerationFormat'
        failTestIfFilesDiffer(defaultTestResourcesDir.resolve("Record.scala"), testRunnerProjectBuildDir.resolve(Defaults.relativeOutputDirectory).resolve("at/makubi/maven/plugin/model/Record.scala"));

        // Test 'recursive'
        assertTrue("SubRecord is missing in test source directory", testAvroSourceSubDir.resolve(subApiAvdl).toFile().exists());
        assertFalse("Record in subdirectory was generated, even though 'recursive' is 'false' by default", testRunnerProjectBuildDir.resolve(Defaults.relativeOutputDirectory).resolve("at/makubi/maven/plugin/model/submodel/SubRecord.scala").toFile().exists());

        // Test 'limitedNumberOfFieldsInCaseClasses'
        failTestIfFilesDiffer(defaultTestResourcesDir.resolve("RecordWith25Fields.scala"), testRunnerProjectBuildDir.resolve(Defaults.relativeOutputDirectory).resolve("at/makubi/maven/plugin/model/RecordWith25Fields.scala"));
    }

    public void testGenerateScalaSourcesWithOverwrittenSettings() throws Exception {
        final Path overwriteTestResourcesDir = testResourcesDir.resolve("overwrite");

        Path relativeSourceDirectory = Paths.get("src/main/resources/avro");
        Path relativeOutputDirectory = Paths.get("avro");

        final Path testAvroSourceDir = testRunnerBaseDir.resolve(relativeSourceDirectory);
        final Path testAvroSourceSubDir = testAvroSourceDir.resolve("subdir");

        final Path apiAvdl = Paths.get("Api.avdl");
        final Path subApiAvdl = Paths.get("SubApi.avdl");
        final Path recordWith25FieldsAvdl = Paths.get("RecordWith25Fields.avdl");
        final Path changedNamespaceAvdl = Paths.get("ChangedNamespace.avdl");
        final Path includedAvdl = Paths.get("Included.avdl");
        final Path notIncludedAvdl = Paths.get("NotIncluded.avdl");
        final Path typeOverridesAvdl = Paths.get("TypeOverrides.avdl");
        final String testPomName = "pom-overwrite.xml";

        createDir(testAvroSourceDir);
        createDir(testAvroSourceSubDir);

        // Copy pom
        Path srcPom = overwriteTestResourcesDir.resolve(testPomName);
        Path pomPath = testRunnerBaseDir.resolve(testPomName);
        Files.copy(srcPom, pomPath, StandardCopyOption.REPLACE_EXISTING);

        // Copy AVDL files
        Files.copy(testResourcesDir.resolve(apiAvdl), testAvroSourceDir.resolve(apiAvdl), StandardCopyOption.REPLACE_EXISTING);
        Files.copy(testResourcesDir.resolve(subApiAvdl), testAvroSourceSubDir.resolve(subApiAvdl), StandardCopyOption.REPLACE_EXISTING);
        Files.copy(testResourcesDir.resolve(recordWith25FieldsAvdl), testAvroSourceDir.resolve(recordWith25FieldsAvdl), StandardCopyOption.REPLACE_EXISTING);
        Files.copy(testResourcesDir.resolve(changedNamespaceAvdl), testAvroSourceDir.resolve(changedNamespaceAvdl), StandardCopyOption.REPLACE_EXISTING);
        Files.copy(testResourcesDir.resolve(includedAvdl), testAvroSourceDir.resolve(includedAvdl), StandardCopyOption.REPLACE_EXISTING);
        Files.copy(testResourcesDir.resolve(notIncludedAvdl), testAvroSourceDir.resolve(notIncludedAvdl), StandardCopyOption.REPLACE_EXISTING);
        Files.copy(testResourcesDir.resolve(typeOverridesAvdl), testAvroSourceDir.resolve(typeOverridesAvdl), StandardCopyOption.REPLACE_EXISTING);

        GeneratorMojo generatorMojo = (GeneratorMojo) lookupMojo("generate-scala-sources", getTestFile(pomPath.toString()));
        generatorMojo.execute();

        // Test 'sourceDirectory', 'outputDirectory' and 'sourceGenerationFormat'
        failTestIfFilesDiffer(overwriteTestResourcesDir.resolve("Record.scala"), testRunnerProjectBuildDir.resolve(relativeOutputDirectory).resolve("at/makubi/maven/plugin/model/Record.scala"));

        // Test 'recursive'
        assertTrue("SubRecord is missing in test source directory", testAvroSourceSubDir.resolve(subApiAvdl).toFile().exists());
        assertTrue("Record in subdirectory was not generated, even though 'recursive' is set to 'true'", testRunnerProjectBuildDir.resolve(relativeOutputDirectory).resolve("at/makubi/maven/plugin/model/submodel/SubRecord.scala").toFile().exists());

        // Test 'limitedNumberOfFieldsInCaseClasses'
        failTestIfFilesDiffer(overwriteTestResourcesDir.resolve("RecordWith25Fields.scala"), testRunnerProjectBuildDir.resolve(relativeOutputDirectory).resolve("at/makubi/maven/plugin/model/RecordWith25Fields.scala"));

        // Test 'namespaceMapping'
        failTestIfFilesDiffer(overwriteTestResourcesDir.resolve("NamespaceRecord.scala"), testRunnerProjectBuildDir.resolve(relativeOutputDirectory).resolve("at/makubi/maven/plugin/model/namespacechanged/subchange/NamespaceRecord.scala"));

        // Test 'fileIncludes'
        assertTrue("IncludedRecord is missing in test source directory", testRunnerProjectBuildDir.resolve(relativeOutputDirectory).resolve("at/makubi/maven/plugin/model/included/IncludedRecord.scala").toFile().exists());
        assertFalse("NotIncludedRecord exists in test source directory", testRunnerProjectBuildDir.resolve(relativeOutputDirectory).resolve("at/makubi/maven/plugin/model/notincluded/NotIncludedRecord.scala").toFile().exists());

        // Test 'typeOverrides'
        failTestIfFilesDiffer(overwriteTestResourcesDir.resolve("TypeOverridesRecord.scala"), testRunnerProjectBuildDir.resolve(relativeOutputDirectory).resolve("at/makubi/maven/plugin/model/TypeOverridesRecord.scala"));
    }

}
