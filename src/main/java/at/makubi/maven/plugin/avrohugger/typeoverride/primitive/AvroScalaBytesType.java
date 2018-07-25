package at.makubi.maven.plugin.avrohugger.typeoverride.primitive;

import avrohugger.types.ScalaByteArray$;

/**
 * https://github.com/julianpeeters/avrohugger/blob/master/avrohugger-core/src/main/scala/types/PrimitiveAvroScalaTypes.scala#L20
 */
public enum AvroScalaBytesType {

    SCALA_BYTE_ARRAY(ScalaByteArray$.MODULE$);

    public final avrohugger.types.AvroScalaBytesType avrohuggerScalaBytesType;

    AvroScalaBytesType(avrohugger.types.AvroScalaBytesType avrohuggerScalaBytesType) {
        this.avrohuggerScalaBytesType = avrohuggerScalaBytesType;
    }
}
