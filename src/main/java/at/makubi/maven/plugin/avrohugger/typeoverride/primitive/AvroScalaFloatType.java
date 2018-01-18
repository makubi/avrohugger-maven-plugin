package at.makubi.maven.plugin.avrohugger.typeoverride.primitive;

import avrohugger.types.ScalaFloat$;
import avrohugger.types.ScalaFloat$;
import avrohugger.types.ScalaInt$;
import avrohugger.types.ScalaLong$;

/**
 * https://github.com/julianpeeters/avrohugger/blob/master/avrohugger-core/src/main/scala/types/PrimitiveAvroScalaTypes.scala#L5
 */
public enum AvroScalaFloatType {

    SCALA_FLOAT(ScalaFloat$.MODULE$);

    public final avrohugger.types.AvroScalaNumberType avrohuggerScalaFloatType;

    AvroScalaFloatType(avrohugger.types.AvroScalaNumberType avrohuggerScalaFloatType) {
        this.avrohuggerScalaFloatType = avrohuggerScalaFloatType;
    }
}
