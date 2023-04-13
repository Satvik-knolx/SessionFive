package com.knoldus

class GCD extends Operator {

  override def validate(operands: Seq[Double]): Boolean = {
    operands.length == 2
  }


  override protected def execute(operands: Seq[Double]): Seq[Double] = {
    Seq(gcd(operands(0),operands(1)))
  }

  def gcd(elementOne: Double, elementTwo: Double): Double = {
    if (elementTwo == 0) {
      elementOne
    } else {
      gcd(elementTwo, elementOne % elementTwo)
    }
  }
}