package at.makubi.maven.plugin.avrohugger.typeoverride.primitive;

import avrohugger.types.ScalaString$;

/**
 * https://github.com/julianpeeters/avrohugger/blob/master/avrohugger-core/src/main/scala/types/PrimitiveAvroScalaTypes.scala#L14
 */
public enum AvroScalaStringType {

    SCALA_STRING(ScalaString$.MODULE$);

    public final avrohugger.types.AvroScalaStringType avrohuggerScalaStringType;

    AvroScalaStringType(avrohugger.types.AvroScalaStringType avrohuggerScalaStringType) {
        this.avrohuggerScalaStringType = avrohuggerScalaStringType;
    }
}
