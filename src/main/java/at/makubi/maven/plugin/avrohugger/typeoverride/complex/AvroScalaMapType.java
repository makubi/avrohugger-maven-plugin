package at.makubi.maven.plugin.avrohugger.typeoverride.complex;

import avrohugger.types.ScalaMap$;

/**
 * https://github.com/julianpeeters/avrohugger/blob/master/avrohugger-core/src/main/scala/types/ComplexAvroScalaTypes.scala#L27
 */
public enum AvroScalaMapType {

    SCALA_BINARY(ScalaMap$.MODULE$);

    public final avrohugger.types.AvroScalaMapType avrohuggerScalaMapType;

    AvroScalaMapType(avrohugger.types.AvroScalaMapType avrohuggerScalaMapType) {
        this.avrohuggerScalaMapType = avrohuggerScalaMapType;
    }
}
