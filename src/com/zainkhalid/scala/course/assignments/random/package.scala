package com.zainkhalid.scala.course.assignments

import com.zainkhalid.scala.course.assignments.json.JsWriter
import com.zainkhalid.scala.course.assignments.typeclasses.Functor

import scala.language.higherKinds

/**
  * Created by zainkhalid on 7/14/16.
  */
package object random {
 implicit class RandomSyntax[A](value: Random[A]) {
    def map[B](f: A => B)(implicit functor: Functor[Random]): Random[B] = functor.map(value)(f)
  }
}
