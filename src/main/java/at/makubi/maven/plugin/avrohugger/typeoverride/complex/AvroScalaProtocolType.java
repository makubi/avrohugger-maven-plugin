package at.makubi.maven.plugin.avrohugger.typeoverride.complex;

import avrohugger.types.NoTypeGenerated$;
import avrohugger.types.ScalaADT$;

/**
 * https://github.com/julianpeeters/avrohugger/blob/master/avrohugger-core/src/main/scala/types/ComplexAvroScalaTypes.scala#L30
 */
public enum AvroScalaProtocolType {

    SCALA_ADT(ScalaADT$.MODULE$),
    NO_TYPE_GENERATED(NoTypeGenerated$.MODULE$);

    public final avrohugger.types.AvroScalaProtocolType avrohuggerScalaProtocolType;

    AvroScalaProtocolType(avrohugger.types.AvroScalaProtocolType avrohuggerScalaProtocolType) {
        this.avrohuggerScalaProtocolType = avrohuggerScalaProtocolType;
    }
}
