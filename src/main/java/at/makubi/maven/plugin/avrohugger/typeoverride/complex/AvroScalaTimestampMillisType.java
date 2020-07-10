package at.makubi.maven.plugin.avrohugger.typeoverride.complex;

public enum AvroScalaTimestampMillisType {

    INSTANT(avrohugger.types.JavaTimeInstant$.MODULE$),
    TIMESTAMP(avrohugger.types.JavaSqlTimestamp$.MODULE$);

    public final avrohugger.types.AvroScalaTimestampMillisType avrohuggerScalaTimestampMillisType;

    AvroScalaTimestampMillisType(avrohugger.types.AvroScalaTimestampMillisType avrohuggerScalaTimestampMillisType) {
        this.avrohuggerScalaTimestampMillisType = avrohuggerScalaTimestampMillisType;
    }

}
