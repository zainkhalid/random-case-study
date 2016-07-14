package com.zainkhalid.scala.course.assignments.typeclasses

import scala.language.higherKinds

/**
  * Created by zainkhalid on 7/14/16.
  */
trait Applicative[F[_]] extends Functor[F] {
  def zip[A, B](fa: F[A], fb: F[B]): F[(A, B)]
  def point[A](a: A): F[A]
}
