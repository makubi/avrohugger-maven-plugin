package at.makubi.maven.plugin.avrohugger.typeoverride.primitive;

import avrohugger.types.ScalaLong$;
import avrohugger.types.ScalaFloat$;
import avrohugger.types.ScalaInt$;
import avrohugger.types.ScalaLong$;

/**
 * https://github.com/julianpeeters/avrohugger/blob/master/avrohugger-core/src/main/scala/types/PrimitiveAvroScalaTypes.scala#L5
 */
public enum AvroScalaLongType {

    SCALA_LONG(ScalaLong$.MODULE$);

    public final avrohugger.types.AvroScalaNumberType avrohuggerScalaLongType;

    AvroScalaLongType(avrohugger.types.AvroScalaNumberType avrohuggerScalaLongType) {
        this.avrohuggerScalaLongType = avrohuggerScalaLongType;
    }
}
