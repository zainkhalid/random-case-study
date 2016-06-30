package org.zain.random

/**
  * Created by zainkhalid on 6/30/16.
  */
trait Vec {
  def +(that: Vec): Vec
}

object Vec {
  def randomWalk(point: Random[Vec], noise: Random[Vec]): Random[Vec] = {
    (point zip noise) map { case (p, n) => p + n}
  }
}