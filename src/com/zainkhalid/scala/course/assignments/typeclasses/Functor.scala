package com.zainkhalid.scala.course.assignments.typeclasses

import scala.language.higherKinds

/**
  * Created by zainkhalid on 7/14/16.
  */
trait Functor[F[_]] {
 def map[A, B](fa: F[A])(f: A => B): F[B]
}
