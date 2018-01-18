package at.makubi.maven.plugin.avrohugger;

import avrohugger.types.NoTypeGenerated$;
import avrohugger.types.ScalaADT$;

public enum AvroScalaProtocolType {

    SCALA_ADT(ScalaADT$.MODULE$),
    NO_TYPE_GENERATED(NoTypeGenerated$.MODULE$);

    public final avrohugger.types.AvroScalaProtocolType avrohuggerScalaProtocolType;

    AvroScalaProtocolType(avrohugger.types.AvroScalaProtocolType avrohuggerScalaProtocolType) {
        this.avrohuggerScalaProtocolType = avrohuggerScalaProtocolType;
    }
}
