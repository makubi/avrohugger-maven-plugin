/** MACHINE-GENERATED FROM AVRO SCHEMA. DO NOT EDIT DIRECTLY */
package at.makubi.maven.plugin.model

import scala.annotation.switch

final case class RecordWith25Fields(var field1: String, var field2: String, var field3: String, var field4: String, var field5: String, var field6: String, var field7: String, var field8: String, var field9: String, var field10: String, var field11: String, var field12: String, var field13: String, var field14: String, var field15: String, var field16: String, var field17: String, var field18: String, var field19: String, var field20: String, var field21: String, var field22: String, var field23: String, var field24: String, var field25: String) extends org.apache.avro.specific.SpecificRecordBase {
  def this() = this("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "")
  def get(field$: Int): AnyRef = {
    (field$: @switch) match {
      case 0 => {
        field1
      }.asInstanceOf[AnyRef]
      case 1 => {
        field2
      }.asInstanceOf[AnyRef]
      case 2 => {
        field3
      }.asInstanceOf[AnyRef]
      case 3 => {
        field4
      }.asInstanceOf[AnyRef]
      case 4 => {
        field5
      }.asInstanceOf[AnyRef]
      case 5 => {
        field6
      }.asInstanceOf[AnyRef]
      case 6 => {
        field7
      }.asInstanceOf[AnyRef]
      case 7 => {
        field8
      }.asInstanceOf[AnyRef]
      case 8 => {
        field9
      }.asInstanceOf[AnyRef]
      case 9 => {
        field10
      }.asInstanceOf[AnyRef]
      case 10 => {
        field11
      }.asInstanceOf[AnyRef]
      case 11 => {
        field12
      }.asInstanceOf[AnyRef]
      case 12 => {
        field13
      }.asInstanceOf[AnyRef]
      case 13 => {
        field14
      }.asInstanceOf[AnyRef]
      case 14 => {
        field15
      }.asInstanceOf[AnyRef]
      case 15 => {
        field16
      }.asInstanceOf[AnyRef]
      case 16 => {
        field17
      }.asInstanceOf[AnyRef]
      case 17 => {
        field18
      }.asInstanceOf[AnyRef]
      case 18 => {
        field19
      }.asInstanceOf[AnyRef]
      case 19 => {
        field20
      }.asInstanceOf[AnyRef]
      case 20 => {
        field21
      }.asInstanceOf[AnyRef]
      case 21 => {
        field22
      }.asInstanceOf[AnyRef]
      case 22 => {
        field23
      }.asInstanceOf[AnyRef]
      case 23 => {
        field24
      }.asInstanceOf[AnyRef]
      case 24 => {
        field25
      }.asInstanceOf[AnyRef]
      case _ => new org.apache.avro.AvroRuntimeException("Bad index")
    }
  }
  def put(field$: Int, value: Any): Unit = {
    (field$: @switch) match {
      case 0 => this.field1 = {
        value.toString
      }.asInstanceOf[String]
      case 1 => this.field2 = {
        value.toString
      }.asInstanceOf[String]
      case 2 => this.field3 = {
        value.toString
      }.asInstanceOf[String]
      case 3 => this.field4 = {
        value.toString
      }.asInstanceOf[String]
      case 4 => this.field5 = {
        value.toString
      }.asInstanceOf[String]
      case 5 => this.field6 = {
        value.toString
      }.asInstanceOf[String]
      case 6 => this.field7 = {
        value.toString
      }.asInstanceOf[String]
      case 7 => this.field8 = {
        value.toString
      }.asInstanceOf[String]
      case 8 => this.field9 = {
        value.toString
      }.asInstanceOf[String]
      case 9 => this.field10 = {
        value.toString
      }.asInstanceOf[String]
      case 10 => this.field11 = {
        value.toString
      }.asInstanceOf[String]
      case 11 => this.field12 = {
        value.toString
      }.asInstanceOf[String]
      case 12 => this.field13 = {
        value.toString
      }.asInstanceOf[String]
      case 13 => this.field14 = {
        value.toString
      }.asInstanceOf[String]
      case 14 => this.field15 = {
        value.toString
      }.asInstanceOf[String]
      case 15 => this.field16 = {
        value.toString
      }.asInstanceOf[String]
      case 16 => this.field17 = {
        value.toString
      }.asInstanceOf[String]
      case 17 => this.field18 = {
        value.toString
      }.asInstanceOf[String]
      case 18 => this.field19 = {
        value.toString
      }.asInstanceOf[String]
      case 19 => this.field20 = {
        value.toString
      }.asInstanceOf[String]
      case 20 => this.field21 = {
        value.toString
      }.asInstanceOf[String]
      case 21 => this.field22 = {
        value.toString
      }.asInstanceOf[String]
      case 22 => this.field23 = {
        value.toString
      }.asInstanceOf[String]
      case 23 => this.field24 = {
        value.toString
      }.asInstanceOf[String]
      case 24 => this.field25 = {
        value.toString
      }.asInstanceOf[String]
      case _ => new org.apache.avro.AvroRuntimeException("Bad index")
    }
    ()
  }
  def getSchema: org.apache.avro.Schema = RecordWith25Fields.SCHEMA$
}

object RecordWith25Fields {
  val SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"RecordWith25Fields\",\"namespace\":\"at.makubi.maven.plugin.model\",\"fields\":[{\"name\":\"field1\",\"type\":\"string\"},{\"name\":\"field2\",\"type\":\"string\"},{\"name\":\"field3\",\"type\":\"string\"},{\"name\":\"field4\",\"type\":\"string\"},{\"name\":\"field5\",\"type\":\"string\"},{\"name\":\"field6\",\"type\":\"string\"},{\"name\":\"field7\",\"type\":\"string\"},{\"name\":\"field8\",\"type\":\"string\"},{\"name\":\"field9\",\"type\":\"string\"},{\"name\":\"field10\",\"type\":\"string\"},{\"name\":\"field11\",\"type\":\"string\"},{\"name\":\"field12\",\"type\":\"string\"},{\"name\":\"field13\",\"type\":\"string\"},{\"name\":\"field14\",\"type\":\"string\"},{\"name\":\"field15\",\"type\":\"string\"},{\"name\":\"field16\",\"type\":\"string\"},{\"name\":\"field17\",\"type\":\"string\"},{\"name\":\"field18\",\"type\":\"string\"},{\"name\":\"field19\",\"type\":\"string\"},{\"name\":\"field20\",\"type\":\"string\"},{\"name\":\"field21\",\"type\":\"string\"},{\"name\":\"field22\",\"type\":\"string\"},{\"name\":\"field23\",\"type\":\"string\"},{\"name\":\"field24\",\"type\":\"string\"},{\"name\":\"field25\",\"type\":\"string\"}]}")
}