package com.zainkhalid.scala.course.assignments

import scala.language.higherKinds

/**
  * Created by zainkhalid on 7/14/16.
  */
package object typeclasses {

  implicit class FunctorUtils[A, F[_]](value: F[A]) {
    //def map[B](f: A => B)(implicit functor: Functor[F]): F[B] = functor.map(value)(f)
  }

}
