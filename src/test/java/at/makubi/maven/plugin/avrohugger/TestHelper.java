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

import org.eclipse.jgit.diff.*;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

import static org.junit.Assert.fail;

public class TestHelper {

    public static String fileDiff(File originalFile, File actualFile) throws IOException {

        try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            final RawText rt1 = new RawText(originalFile);
            final RawText rt2 = new RawText(actualFile);

            final EditList diffList = new EditList();
            diffList.addAll(new HistogramDiff().diff(RawTextComparator.DEFAULT, rt1, rt2));

            new DiffFormatter(out).format(diffList, rt1, rt2);
            return out.toString();
        }
    }

    public static void failTestIfFilesDiffer(Path expectedFile, Path actualFile) throws IOException {
        String fileDiff = TestHelper.fileDiff(expectedFile.toFile(), actualFile.toFile());
        if (!fileDiff.isEmpty()) {
            fail("Expected file " + expectedFile + " and actual file " + actualFile + " differ. See output below." + System.lineSeparator() + fileDiff);
        }
    }
}
