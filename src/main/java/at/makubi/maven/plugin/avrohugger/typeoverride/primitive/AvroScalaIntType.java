package at.makubi.maven.plugin.avrohugger.typeoverride.primitive;

import avrohugger.types.ScalaInt$;
import avrohugger.types.ScalaFloat$;
import avrohugger.types.ScalaInt$;
import avrohugger.types.ScalaLong$;

/**
 * https://github.com/julianpeeters/avrohugger/blob/master/avrohugger-core/src/main/scala/types/PrimitiveAvroScalaTypes.scala#L5
 */
public enum AvroScalaIntType {

    SCALA_INT(ScalaInt$.MODULE$);

    public final avrohugger.types.AvroScalaNumberType avrohuggerScalaIntType;

    AvroScalaIntType(avrohugger.types.AvroScalaNumberType avrohuggerScalaIntType) {
        this.avrohuggerScalaIntType = avrohuggerScalaIntType;
    }
}
