package com.knoldus

import scala.annotation.tailrec
import scala.math.abs

class SquareRoot extends Operator {

  override def validate(operands: Seq[Double]): Boolean = {
    operands.length == 1 && (operands(0) > 0)
  }

  def squareRoot(element: Double): BigDecimal = {
    BigDecimal(squareRootIter(1.0, element)).setScale(1, BigDecimal.RoundingMode.HALF_DOWN)
  }

  @tailrec
  private def squareRootIter(guess: Double, element: Double): Double =
    if (isGoodEnough(guess, element)) guess
    else squareRootIter(improve(guess, element), element)

  private def improve(guess: Double, element: Double): Double =
    (guess + element / guess) / 2

  private def isGoodEnough(guess: Double, element: Double) =
    abs(guess * guess - element)/element < 0.001

  override protected def execute(operands: Seq[Double]): Seq[Double] = {
    Seq(squareRoot(operands(0)).toDouble)
  }

}