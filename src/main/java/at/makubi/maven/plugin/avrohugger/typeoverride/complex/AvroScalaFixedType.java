package at.makubi.maven.plugin.avrohugger.typeoverride.complex;

import avrohugger.types.ScalaCaseClassWrapper$;

/**
 * https://github.com/julianpeeters/avrohugger/blob/master/avrohugger-core/src/main/scala/types/ComplexAvroScalaTypes.scala#L5
 */
public enum AvroScalaFixedType {

    SCALA_BINARY(ScalaCaseClassWrapper$.MODULE$);

    public final avrohugger.types.AvroScalaFixedType avrohuggerScalaFixedType;

    AvroScalaFixedType(avrohugger.types.AvroScalaFixedType avrohuggerScalaFixedType) {
        this.avrohuggerScalaFixedType = avrohuggerScalaFixedType;
    }
}
