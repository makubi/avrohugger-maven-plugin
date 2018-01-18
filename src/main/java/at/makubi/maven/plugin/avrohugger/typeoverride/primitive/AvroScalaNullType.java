package at.makubi.maven.plugin.avrohugger.typeoverride.primitive;

import avrohugger.types.ScalaNull$;

/**
 * https://github.com/julianpeeters/avrohugger/blob/master/avrohugger-core/src/main/scala/types/PrimitiveAvroScalaTypes.scala#L17
 */
public enum AvroScalaNullType {

    SCALA_NULL(ScalaNull$.MODULE$);

    public final avrohugger.types.AvroScalaNullType avrohuggerScalaNullType;

    AvroScalaNullType(avrohugger.types.AvroScalaNullType avrohuggerScalaNullType) {
        this.avrohuggerScalaNullType = avrohuggerScalaNullType;
    }
}
