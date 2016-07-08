package com.zainkhalid.scala.course.assignments.json

/**
  * Created by zainkhalid on 7/8/16.
  */

sealed trait JsValue {
  def stringify: String
}

final case class JsObject(values: Map[String, JsValue]) extends JsValue {

  def stringify = {
    values
      .map { case (name, value) =>
        "\"" + name + "\":" + value.stringify
      }
      .mkString("{", ",", "}")
  }
}

final case class JsString(value: String) extends JsValue {
  def stringify = "\"" + value.replaceAll("\\|\"", "\\\\$1") + "\""
}