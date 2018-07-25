package at.makubi.maven.plugin.avrohugger.typeoverride.primitive;

import avrohugger.types.ScalaDouble$;
import avrohugger.types.ScalaFloat$;
import avrohugger.types.ScalaInt$;
import avrohugger.types.ScalaLong$;

/**
 * https://github.com/julianpeeters/avrohugger/blob/master/avrohugger-core/src/main/scala/types/PrimitiveAvroScalaTypes.scala#L5
 */
public enum AvroScalaDoubleType {

    SCALA_DOUBLE(ScalaDouble$.MODULE$);

    public final avrohugger.types.AvroScalaNumberType avrohuggerScalaDoubleType;

    AvroScalaDoubleType(avrohugger.types.AvroScalaNumberType avrohuggerScalaDoubleType) {
        this.avrohuggerScalaDoubleType = avrohuggerScalaDoubleType;
    }
}
