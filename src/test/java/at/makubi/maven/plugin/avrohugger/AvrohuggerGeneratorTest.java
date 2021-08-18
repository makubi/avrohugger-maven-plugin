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
import org.apache.commons.io.FileUtils;
import org.apache.maven.plugin.logging.SystemStreamLog;
import org.apache.maven.plugin.testing.AbstractMojoTestCase;
import org.junit.After;
import org.junit.Before;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;

import static at.makubi.maven.plugin.avrohugger.TestHelper.failTestIfFilesDiffer;

public class AvrohuggerGeneratorTest extends AbstractMojoTestCase {

    AvrohuggerGenerator avrohuggerGenerator;
    Path outputDirectory;

    @Before
    public void setUp() throws Exception {
        super.setUp();

        avrohuggerGenerator = new AvrohuggerGenerator();
        outputDirectory = Files.createTempDirectory(Paths.get(getBasedir()).resolve("target"), AvrohuggerGeneratorTest.class.getCanonicalName());
    }

    @After
    public void tearDown() throws Exception {
        FileUtils.deleteDirectory(outputDirectory.toFile());

        super.tearDown();
    }

    public void testAvrohuggerGenerator() throws IOException {
        Path inputDirectory = Paths.get(getBasedir()).resolve("src/test/resources/unit/avrohugger-maven-plugin");
        Path schemaDirectory = inputDirectory.resolve("schema");

        Path expectedRecord = inputDirectory.resolve("expected/Record.scala");
        Path actualRecord = outputDirectory.resolve("at/makubi/maven/plugin/model/Record.scala");

        avrohuggerGenerator.generateScalaFiles(schemaDirectory.toFile(), outputDirectory.toString(), new SystemStreamLog(), false, false, SourceGenerationFormat.SPECIFIC_RECORD, Collections.<Mapping>emptyList(), Collections.singletonList(new FileInclude("**", MatchSyntax.GLOB)), new TypeOverrides());

        failTestIfFilesDiffer(expectedRecord, actualRecord);
    }

    public void testAvrohuggerGeneratorWithSort() throws IOException {
        Path inputDirectory = Paths.get(getBasedir()).resolve("src/test/resources/unit/avrohugger-maven-plugin");
        Path schemaDirectory = inputDirectory.resolve("standardSchema");

        Path expectedRecord = inputDirectory.resolve("expected/ARecord.scala");
        Path expectedEnum = inputDirectory.resolve("expected/MoneyDecimal.scala");
        Path actualRecord = outputDirectory.resolve("com/test/ARecord/ARecord.scala");
        Path actualEnum = outputDirectory.resolve("com/test/MoneyDecimal.scala");

        avrohuggerGenerator.generateScalaFiles(
                schemaDirectory.toFile(), outputDirectory.toString(), new SystemStreamLog(), true, false,
                SourceGenerationFormat.STANDARD, Collections.<Mapping>emptyList(),
                Collections.singletonList(new FileInclude("**", MatchSyntax.GLOB)), new TypeOverrides());

        failTestIfFilesDiffer(expectedRecord, actualRecord);
        failTestIfFilesDiffer(expectedEnum, actualEnum);
    }

    public void testAvrohuggerGeneratorRecursive() throws IOException {
        Path inputDirectory = Paths.get(getBasedir()).resolve("src/test/resources/unit/avrohugger-maven-plugin");
        Path schemaDirectory = inputDirectory.resolve("schema");

        Path expectedRecord = inputDirectory.resolve("expected/Record.scala");
        Path actualRecord = outputDirectory.resolve("at/makubi/maven/plugin/model/Record.scala");

        Path expectedSubRecord = inputDirectory.resolve("expected/SubRecord.scala");
        Path actualSubRecord = outputDirectory.resolve("at/makubi/maven/plugin/model/submodel/SubRecord.scala");

        avrohuggerGenerator.generateScalaFiles(schemaDirectory.toFile(), outputDirectory.toString(), new SystemStreamLog(), true, false, SourceGenerationFormat.SPECIFIC_RECORD, Collections.<Mapping>emptyList(), Collections.singletonList(new FileInclude("**", MatchSyntax.GLOB)), new TypeOverrides());

        failTestIfFilesDiffer(expectedRecord, actualRecord);
        failTestIfFilesDiffer(expectedSubRecord, actualSubRecord);
    }

    public void testAvrohuggerGeneratorNotRecursive() throws IOException {
        Path inputDirectory = Paths.get(getBasedir()).resolve("src/test/resources/unit/avrohugger-maven-plugin");
        Path schemaDirectory = inputDirectory.resolve("schema");

        Path expectedRecord = inputDirectory.resolve("expected/Record.scala");
        Path actualRecord = outputDirectory.resolve("at/makubi/maven/plugin/model/Record.scala");

        Path actualSubRecord = outputDirectory.resolve("at/makubi/maven/plugin/model/submodel/SubRecord.scala");

        avrohuggerGenerator.generateScalaFiles(schemaDirectory.toFile(), outputDirectory.toString(), new SystemStreamLog(), false, false, SourceGenerationFormat.SPECIFIC_RECORD, Collections.<Mapping>emptyList(), Collections.singletonList(new FileInclude("**", MatchSyntax.GLOB)), new TypeOverrides());

        failTestIfFilesDiffer(expectedRecord, actualRecord);
        assertFalse(actualSubRecord + " exists, but should not", actualSubRecord.toFile().exists());
    }
}
