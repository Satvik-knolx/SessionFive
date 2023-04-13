package com.knoldus

class Factorial extends Operator {

  override def validate(operands: Seq[Double]): Boolean = {
    operands.length == 1
  }

  override protected def execute(operands: Seq[Double]): Seq[Double] = {
    Seq(factorial(operands(0),1))
  }

  def factorial(factorialNumber: Double, factorialValue: Double): Double = {
    if (factorialNumber <= 1) {
      factorialValue
    } else {
      factorial(factorialNumber - 1, factorialValue * factorialNumber)
    }
  }

}
