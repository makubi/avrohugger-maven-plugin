package at.makubi.maven.plugin.avrohugger;

public class FileInclude {
    private String path;
    private MatchSyntax matchSyntax;

    public FileInclude() {}

    public FileInclude(String path, MatchSyntax matchSyntax) {
        this.path = path;
        this.matchSyntax = matchSyntax;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public MatchSyntax getMatchSyntax() {
        return matchSyntax;
    }

    public void setMatchSyntax(MatchSyntax matchSyntax) {
        this.matchSyntax = matchSyntax;
    }
}
