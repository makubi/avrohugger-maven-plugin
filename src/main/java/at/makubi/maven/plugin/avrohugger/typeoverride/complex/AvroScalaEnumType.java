package at.makubi.maven.plugin.avrohugger.typeoverride.complex;

import avrohugger.types.EnumAsScalaString$;
import avrohugger.types.JavaEnum$;
import avrohugger.types.ScalaCaseObjectEnum$;
import avrohugger.types.ScalaEnumeration$;

/**
 * https://github.com/julianpeeters/avrohugger/blob/master/avrohugger-core/src/main/scala/types/ComplexAvroScalaTypes.scala#L12
 */
public enum AvroScalaEnumType {

    SCALA_ENUMERATION(ScalaEnumeration$.MODULE$),
    JAVA_ENUM(JavaEnum$.MODULE$),
    SCALA_CASE_OBJECT_ENUM(ScalaCaseObjectEnum$.MODULE$),
    ENUM_AS_SCALA_STRING(EnumAsScalaString$.MODULE$);

    public final avrohugger.types.AvroScalaEnumType avrohuggerScalaEnumType;

    AvroScalaEnumType(avrohugger.types.AvroScalaEnumType avrohuggerScalaEnumType) {
        this.avrohuggerScalaEnumType = avrohuggerScalaEnumType;
    }
}
