package com.knoldus

class Sum extends Operator {

  override def validate(operands: Seq[Double]): Boolean = {
    operands.length != 0
  }

  override protected def execute(operands: Seq[Double]): Seq[Double] = {
    Seq(sum(operands))
  }

  def sum(operands: Seq[Double]): Double = {
    if (operands.isEmpty) {
      0
    } else {
      operands.head + sum(operands.tail)
    }
  }
}
