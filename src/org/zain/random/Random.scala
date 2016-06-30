package org.zain.random

/**
  * Created by zainkhalid on 6/30/16.
  */
sealed trait Random[A] {
  def run(rng: scala.util.Random): A = {
    this match {
      case Primitive(generator) => generator(rng)

      case Map(f, contained) => {
        val inner = contained.run(rng)
        f(inner)
      }

      case FlatMap(f, contained) => {
        val inner = contained.run(rng)
        f(inner).run(rng)
      }
    }
  }

  def flatMap[B](f: A => Random[B]): Random[B] = Primitive(rng => f(this.run(rng)).run(rng))
  def map[B](f: A => B): Random[B] = Primitive(rng => f(this.run(rng)))

  def zip[B](that: Random[B]): Random[(A,B)] = {
    /*
    this flatMap { a =>
      that map { b =>
        (a, b)
      }
    }
    */
    for {
      a <- this
      b <- that
    } yield (a, b)
  }
}

object Random {
  val double: Random[Double] = Primitive(rng => rng.nextDouble())
  val int: Random[Int] = Primitive(rng => rng.nextInt())
  val boolean: Random[Boolean] = Primitive(rng => rng.nextBoolean())
  val normal: Random[Double] = Primitive(rng => rng.nextGaussian())
  def always[A](in: A): Random[A] = Primitive(rng => in)


  val answer = scala.util.Random.nextDouble()
  answer + answer

  scala.util.Random.nextDouble() + scala.util.Random.nextDouble()

  val answer = Random.double
  answer.map(a => a + a)

  Random.double.map(a => a + a)


}

final case class Primitive[A](generator: scala.util.Random => A) extends Random[A]
final case class Map[A, B](f: A => B, contained: Random[A]) extends Random[B]
final case class FlatMap[A, B](f: A => Random[B], contained: Random[A]) extends Random[B]

