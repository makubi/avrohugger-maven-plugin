package at.makubi.maven.plugin.avrohugger.typeoverride.logical;


import avrohugger.types.JavaSqlTimestamp$;
import avrohugger.types.JavaTimeInstant$;

/**
 * https://github.com/julianpeeters/avrohugger/blob/master/avrohugger-core/src/main/scala/types/LogicalAvroScalaTypes.scala#L14-L16
 */
public enum AvroScalaTimestampMillisType {

    JAVA_TIME_INSTANT(JavaTimeInstant$.MODULE$),
    JAVA_SQL_TIMESTAMP(JavaSqlTimestamp$.MODULE$);

    public final avrohugger.types.AvroScalaTimestampMillisType avrohuggerScalaTimestampMillisType;

    AvroScalaTimestampMillisType(avrohugger.types.AvroScalaTimestampMillisType avrohuggerScalaTimestampMillisType) {
        this.avrohuggerScalaTimestampMillisType = avrohuggerScalaTimestampMillisType;
    }
}
