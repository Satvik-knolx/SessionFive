package com.knoldus

class Power extends Operator {

  override def validate(operands: Seq[Double]): Boolean = {
    operands.length == 2
  }

  override def execute(operands: Seq[Double]): Seq[Double] = {
    Seq(power(operands(0), operands(1)))
  }

  def power(base: Double, exponent: Double): Double = {
    if (exponent == 0) {
      1
    } else if (exponent == 1) {
      base
    } else if (exponent < 0) {
      1 / power(base, -exponent)
    } else {
      (base * power(base, exponent - 1))
    }
  }

}
