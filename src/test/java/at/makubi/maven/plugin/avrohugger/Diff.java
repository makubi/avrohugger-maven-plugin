package at.makubi.maven.plugin.avrohugger;

import org.eclipse.jgit.diff.*;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

public class Diff {

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
}
