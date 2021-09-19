package at.makubi.maven.plugin.avrohugger.typeoverride;

import at.makubi.maven.plugin.avrohugger.typeoverride.complex.*;
import at.makubi.maven.plugin.avrohugger.typeoverride.logical.AvroScalaTimestampMillisType;
import at.makubi.maven.plugin.avrohugger.typeoverride.primitive.*;

public class TypeOverrides {

    private avrohugger.types.AvroScalaArrayType arrayType;
    private avrohugger.types.AvroScalaEnumType enumType;
    private avrohugger.types.AvroScalaFixedType fixedType;
    private avrohugger.types.AvroScalaMapType mapType;
    private avrohugger.types.AvroScalaProtocolType protocolType;
    private avrohugger.types.AvroScalaRecordType recordType;
    private avrohugger.types.AvroScalaUnionType unionType;

    private avrohugger.types.AvroScalaBooleanType booleanType;
    private avrohugger.types.AvroScalaBytesType bytesType;
    private avrohugger.types.AvroScalaNumberType doubleType;
    private avrohugger.types.AvroScalaNumberType floatType;
    private avrohugger.types.AvroScalaNumberType intType;
    private avrohugger.types.AvroScalaNumberType longType;
    private avrohugger.types.AvroScalaNullType nullType;
    private avrohugger.types.AvroScalaStringType stringType;
    private avrohugger.types.AvroScalaTimestampMillisType timestampMillisType;

    public TypeOverrides() {}

    public avrohugger.types.AvroScalaArrayType getArrayType() {
        return arrayType;
    }

    public void setArrayType(AvroScalaArrayType arrayType) {
        this.arrayType = arrayType.avrohuggerScalaArrayType;
    }

    public avrohugger.types.AvroScalaEnumType getEnumType() {
        return enumType;
    }

    public void setEnumType(AvroScalaEnumType enumType) {
        this.enumType = enumType.avrohuggerScalaEnumType;
    }

    public avrohugger.types.AvroScalaFixedType getFixedType() {
        return fixedType;
    }

    public void setFixedType(AvroScalaFixedType fixedType) {
        this.fixedType = fixedType.avrohuggerScalaFixedType;
    }

    public avrohugger.types.AvroScalaMapType getMapType() {
        return mapType;
    }

    public void setMapType(AvroScalaMapType mapType) {
        this.mapType = mapType.avrohuggerScalaMapType;
    }

    public avrohugger.types.AvroScalaProtocolType getProtocolType() {
        return protocolType;
    }

    public void setProtocolType(AvroScalaProtocolType protocolType) {
        this.protocolType = protocolType.avrohuggerScalaProtocolType;
    }

    public avrohugger.types.AvroScalaRecordType getRecordType() {
        return recordType;
    }

    public void setRecordType(AvroScalaRecordType recordType) {
        this.recordType = recordType.avrohuggerScalaRecordType;
    }

    public avrohugger.types.AvroScalaUnionType getUnionType() {
        return unionType;
    }

    public void setUnionType(AvroScalaUnionType unionType) {
        this.unionType = unionType.avrohuggerScalaUnionType;
    }


    public avrohugger.types.AvroScalaBooleanType getBooleanType() {
        return booleanType;
    }

    public void setBooleanType(AvroScalaBooleanType booleanType) {
        this.booleanType = booleanType.avrohuggerScalaBooleanType;
    }

    public avrohugger.types.AvroScalaBytesType getBytesType() {
        return bytesType;
    }

    public void setBytesType(AvroScalaBytesType bytesType) {
        this.bytesType = bytesType.avrohuggerScalaBytesType;
    }

    public avrohugger.types.AvroScalaNumberType getDoubleType() {
        return doubleType;
    }

    public void setDoubleType(AvroScalaDoubleType doubleType) {
        this.doubleType = doubleType.avrohuggerScalaDoubleType;
    }

    public avrohugger.types.AvroScalaNumberType getFloatType() {
        return floatType;
    }

    public void setFloatType(AvroScalaFloatType floatType) {
        this.floatType = floatType.avrohuggerScalaFloatType;
    }

    public avrohugger.types.AvroScalaNumberType getIntType() {
        return intType;
    }

    public void setIntType(AvroScalaIntType intType) {
        this.intType = intType.avrohuggerScalaIntType;
    }

    public avrohugger.types.AvroScalaNumberType getLongType() {
        return longType;
    }

    public void setLongType(AvroScalaLongType longType) {
        this.longType = longType.avrohuggerScalaLongType;
    }

    public avrohugger.types.AvroScalaNullType getNullType() {
        return nullType;
    }

    public void setNullType(AvroScalaNullType nullType) {
        this.nullType = nullType.avrohuggerScalaNullType;
    }

    public avrohugger.types.AvroScalaStringType getStringType() {
        return stringType;
    }

    public void setStringType(AvroScalaStringType stringType) {
        this.stringType = stringType.avrohuggerScalaStringType;
    }

    public avrohugger.types.AvroScalaTimestampMillisType getTimestampMillisType() {
        return timestampMillisType;
    }

    public void setTimestampMillisType(AvroScalaTimestampMillisType timestampMillisType) {
        this.timestampMillisType = timestampMillisType.avrohuggerScalaTimestampMillisType;
    }
}
