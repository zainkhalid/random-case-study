package com.zainkhalid.scala.course.assignments.typeclasses

import scala.language.higherKinds

/**
  * Created by zainkhalid on 7/14/16.
  */
trait Monad[F[_]] extends Functor[F] {
  def flatMap[A, B](fa: F[A])(f: A => F[B]): F[B]
  def point[A](a: A): F[A]
}

object MonadInstances {
  implicit object ListMonad extends Monad[List] {
    def flatMap[A, B](fa: List[A])(f: (A) => List[B]): List[B] = fa flatMap f
    def point[A](a: A): List[A] = List(a)
    def map[A, B](fa: List[A])(f: (A) => B): List[B] = fa map f
  }

  implicit object OptionMonad extends Monad[Option] {
    def flatMap[A, B](fa: Option[A])(f: (A) => Option[B]): Option[B] = fa flatMap f
    def point[A](a: A): Option[A] = Some(a)
    def map[A, B](fa: Option[A])(f: (A) => B): Option[B] = fa map f
  }
}
