package at.makubi.maven.plugin.avrohugger.typeoverride.complex;

import avrohugger.types.OptionEitherShapelessCoproduct$;
import avrohugger.types.OptionShapelessCoproduct$;
import avrohugger.types.ScalaCaseClass$;
import avrohugger.types.ScalaCaseClassWithSchema$;

/**
 * https://github.com/julianpeeters/avrohugger/blob/master/avrohugger-core/src/main/scala/types/ComplexAvroScalaTypes.scala#L18
 */
public enum AvroScalaUnionType {

    OPTION_SHAPELESS_COPRODUCT(OptionShapelessCoproduct$.MODULE$),
    OPTION_EITHER_SHAPELESS_COPRODUCT(OptionEitherShapelessCoproduct$.MODULE$);

    public final avrohugger.types.AvroScalaUnionType avrohuggerScalaUnionType;

    AvroScalaUnionType(avrohugger.types.AvroScalaUnionType avrohuggerScalaUnionType) {
        this.avrohuggerScalaUnionType = avrohuggerScalaUnionType;
    }
}
