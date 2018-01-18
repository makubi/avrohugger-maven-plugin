package at.makubi.maven.plugin.avrohugger.typeoverride.primitive;

import avrohugger.types.*;

/**
 * https://github.com/julianpeeters/avrohugger/blob/master/avrohugger-core/src/main/scala/types/PrimitiveAvroScalaTypes.scala#L11
 */
public enum AvroScalaBooleanType {

    SCALA_BOOLEAN(ScalaBoolean$.MODULE$);

    public final avrohugger.types.AvroScalaBooleanType avrohuggerScalaBooleanType;

    AvroScalaBooleanType(avrohugger.types.AvroScalaBooleanType avrohuggerScalaBooleanType) {
        this.avrohuggerScalaBooleanType = avrohuggerScalaBooleanType;
    }
}
