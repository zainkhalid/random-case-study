package com.zainkhalid.scala.course.assignments.json

/**
  * Created by zainkhalid on 7/8/16.
  */
trait JsWriter[A] {
  def write(value: A): JsValue
}

object JsWriter {

  implicit object BooleanJsWriter extends JsWriter[Boolean] {
    def write(value: Boolean): JsValue = JsBoolean(value)
  }

  implicit object StringJsWriter extends JsWriter[String] {
    def write(value: String): JsValue = JsString(value)
  }

  implicit object DoubleJsWriter extends JsWriter[Double] {
    def write(value: Double): JsValue = JsNumber(value)
  }

  implicit def ListJsWriter[B: JsWriter]: JsWriter[List[B]] = {
    new JsWriter[List[B]] {
      def write(value: List[B]): JsValue = {
        JsArray(value.map(_.toJson))
      }
    }
  }
}