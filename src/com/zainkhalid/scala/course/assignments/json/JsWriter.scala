package com.zainkhalid.scala.course.assignments.json

/**
  * Created by zainkhalid on 7/8/16.
  */
trait JsWriter[A] {
  def write(value: A): JsValue
}