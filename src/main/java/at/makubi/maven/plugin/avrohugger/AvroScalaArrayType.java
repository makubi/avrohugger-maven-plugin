package at.makubi.maven.plugin.avrohugger;

import avrohugger.types.*;

public enum AvroScalaArrayType {

    SCALA_ARRAY(ScalaArray$.MODULE$),
    SCALA_LIST(ScalaList$.MODULE$),
    SCALA_VECTOR(ScalaVector$.MODULE$);

    public final avrohugger.types.AvroScalaArrayType avrohuggerScalaArrayType;

    AvroScalaArrayType(avrohugger.types.AvroScalaArrayType avrohuggerScalaArrayType) {
        this.avrohuggerScalaArrayType = avrohuggerScalaArrayType;
    }
}
