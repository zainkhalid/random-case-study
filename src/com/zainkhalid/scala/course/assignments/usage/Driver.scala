package com.zainkhalid.scala.course.assignments.usage

import com.zainkhalid.scala.course.assignments.random.Random
import com.zainkhalid.scala.course.assignments.typeclasses.Monad
import scala.language.higherKinds

/**
  * Created by zainkhalid on 7/14/16.
  */
object Driver {
  import com.zainkhalid.scala.course.assignments.typeclasses.MonadInstances._

  def add42[F[_]](a: F[Int])(implicit monad: Monad[F]) = {
    monad.map(a)(_ + 42)
  }

  def main() = {
    val a = Random.double
    val b = Random.double

    val zipped = a zip b

    val xList = List(58, 59, 60)
    val xOption = Some(58)


    println(add42(xList))
    println(add42(xOption))
  }
}
