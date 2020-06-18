package at.makubi.maven.plugin.avrohugger.typeoverride.primitive;


public enum AvroScalaDateType {

    SQL_DATE(avrohugger.types.JavaSqlDate$.MODULE$),
    TIME_LOCALDATE(avrohugger.types.JavaTimeLocalDate$.MODULE$);

    public final avrohugger.types.AvroScalaDateType avrohuggerScalaDateType;

    AvroScalaDateType(avrohugger.types.AvroScalaDateType avrohuggerScalaDateType) {
        this.avrohuggerScalaDateType = avrohuggerScalaDateType;
    }
}
