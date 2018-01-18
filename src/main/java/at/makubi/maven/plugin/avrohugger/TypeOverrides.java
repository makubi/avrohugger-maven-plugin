package at.makubi.maven.plugin.avrohugger;

import avrohugger.format.abstractions.SourceFormat;

public class TypeOverrides {

    private avrohugger.types.AvroScalaEnumType enumType;
    private avrohugger.types.AvroScalaArrayType arrayType;
    private avrohugger.types.AvroScalaProtocolType protocolType;

    public TypeOverrides() {}

    public avrohugger.types.AvroScalaEnumType getEnumType() {
        return enumType;
    }

    public void setEnumType(AvroScalaEnumType enumType) {
        this.enumType = enumType.avrohuggerScalaEnumType;
    }

    public avrohugger.types.AvroScalaArrayType getArrayType() {
        return arrayType;
    }

    public void setArrayType(AvroScalaArrayType arrayType) {
        this.arrayType = arrayType.avrohuggerScalaArrayType;
    }

    public avrohugger.types.AvroScalaProtocolType getProtocolType() {
        return protocolType;
    }

    public void setProtocolType(AvroScalaProtocolType protocolType) {
        this.protocolType = protocolType.avrohuggerScalaProtocolType;
    }
}
