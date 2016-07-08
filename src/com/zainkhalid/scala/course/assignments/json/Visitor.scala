package com.zainkhalid.scala.course.assignments.json

/**
  * Created by zainkhalid on 7/8/16.
  */
import java.util.Date

sealed trait Visitor {
  def id: String
  def createdAt: Date
  def age: Long = new Date().getTime - createdAt.getTime
}

final case class Anonymous(
  id: String,
  createdAt: Date = new Date()
) extends Visitor

final case class User(
  id: String,
  email: String,
  createdAt: Date = new Date()
) extends Visitor


object Visitor {
  implicit object AnonymousJsWriter extends JsWriter[Anonymous] {
    def write(value: Anonymous): JsValue = {
      JsObject(
        Map(
          "id" -> value.id.toJson,
          "createdAt" -> value.createdAt.toString.toJson,
          "age" -> value.age.toString.toJson
        )
      )
    }
  }

  implicit object UserJsWriter extends JsWriter[User] {
    def write(value: User): JsValue = {
      JsObject(
        Map(
          "id" -> value.id.toJson,
          "createdAt" -> value.createdAt.toString.toJson,
          "age" -> value.age.toJson,
          "email" -> value.email.toJson
        )
      )
    }
  }

  implicit object VisitorWriter extends JsWriter[Visitor] {
    def write(value: Visitor) =
      value match {
        case anon: Anonymous => anon.toJson
        case user: User => user.toJson
      }
  }
}