package com.zainkhalid.scala.course.assignments.json

/**
  * Created by zainkhalid on 7/8/16.
  */

sealed trait JsValue {
  def stringify: String =
    this match {
      case JsNull => "null"
      case JsString(value) => "\"" + value.replaceAll("\\|\"", "\\\\$1") + "\""
      case JsBoolean(value) => "\"" + value + "\""
      case JsNumber(value) => value.toString
      case JsObject(values) => {
        values.map { case (name, value) =>
          "\"" + name + "\":" + value.stringify
        }
          .mkString("{", ",", "}")
      }
      case JsArray(values) => {
        values
          .map(_.stringify)
          .mkString("[", ",", "]")
      }
    }
}


case object JsNull extends JsValue

final case class JsObject(values: Map[String, JsValue]) extends JsValue

final case class JsString(value: String) extends JsValue

final case class JsNumber(value: Double) extends JsValue

final case class JsBoolean(value: Boolean) extends JsValue

final case class JsArray(values: Seq[JsValue]) extends JsValue
