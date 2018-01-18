package at.makubi.maven.plugin.avrohugger.typeoverride.complex;

import avrohugger.types.*;

/**
 * https://github.com/julianpeeters/avrohugger/blob/master/avrohugger-core/src/main/scala/types/ComplexAvroScalaTypes.scala#L22
 */
public enum AvroScalaArrayType {

    SCALA_ARRAY(ScalaArray$.MODULE$),
    SCALA_LIST(ScalaList$.MODULE$),
    SCALA_VECTOR(ScalaVector$.MODULE$);

    public final avrohugger.types.AvroScalaArrayType avrohuggerScalaArrayType;

    AvroScalaArrayType(avrohugger.types.AvroScalaArrayType avrohuggerScalaArrayType) {
        this.avrohuggerScalaArrayType = avrohuggerScalaArrayType;
    }
}
