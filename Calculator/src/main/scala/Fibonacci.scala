package com.knoldus

class Fibonacci extends Operator {

  override def validate(operands: Seq[Double]): Boolean = {
    operands.length == 1
  }

  override protected def execute(operands: Seq[Double]): Seq[Double] = {
    fibonacciSeries(operands(0).toInt).map(_.toDouble)
  }

  def fibonacciSeries(number: Int): Seq[Int] = {
    if (number < 2) {
      Seq.fill(number + 1)(number)
    } else {
      val fibonacciSequence = Seq(0, 1)
      (2 to number).foldLeft(fibonacciSequence) { (sequence, i) =>
        sequence :+ (sequence(i - 1) + sequence(i - 2))
      }
    }
  }
}