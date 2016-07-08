package com.zainkhalid.scala.course.assignments

/**
  * Created by zainkhalid on 7/8/16.
  */
package object json {

  implicit class JsUtil[A](value: A) {
    def toJson(implicit writer: JsWriter[A]) =
      writer.write(value)
  }
}
