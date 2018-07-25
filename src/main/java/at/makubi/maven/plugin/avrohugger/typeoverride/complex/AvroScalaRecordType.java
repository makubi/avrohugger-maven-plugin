package at.makubi.maven.plugin.avrohugger.typeoverride.complex;

import avrohugger.types.ScalaCaseClass$;
import avrohugger.types.ScalaCaseClassWithSchema$;

/**
 * https://github.com/julianpeeters/avrohugger/blob/master/avrohugger-core/src/main/scala/types/ComplexAvroScalaTypes.scala#L8
 */
public enum AvroScalaRecordType {

    SCALA_CASE_CLASS(ScalaCaseClass$.MODULE$),
    SCALA_CASE_CLASS_WITH_SCHEMA(ScalaCaseClassWithSchema$.MODULE$);

    public final avrohugger.types.AvroScalaRecordType avrohuggerScalaRecordType;

    AvroScalaRecordType(avrohugger.types.AvroScalaRecordType avrohuggerScalaRecordType) {
        this.avrohuggerScalaRecordType = avrohuggerScalaRecordType;
    }
}
