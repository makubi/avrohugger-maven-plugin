/** MACHINE-GENERATED FROM AVRO SCHEMA. DO NOT EDIT DIRECTLY */
package at.makubi.maven.plugin.model

import scala.annotation.switch

case class Record(var text: String) extends org.apache.avro.specific.SpecificRecordBase {
  def this() = this("")
  def get(field$: Int): AnyRef = {
    (field$: @switch) match {
      case pos if pos == 0 => {
        text
      }.asInstanceOf[AnyRef]
      case _ => new org.apache.avro.AvroRuntimeException("Bad index")
    }
  }
  def put(field$: Int, value: Any): Unit = {
    (field$: @switch) match {
      case pos if pos == 0 => this.text = {
        value.toString
      }.asInstanceOf[String]
      case _ => new org.apache.avro.AvroRuntimeException("Bad index")
    }
    ()
  }
  def getSchema: org.apache.avro.Schema = Record.SCHEMA$
}

object Record {
  val SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"Record\",\"namespace\":\"at.makubi.maven.plugin.model\",\"fields\":[{\"name\":\"text\",\"type\":\"string\"}]}")
}