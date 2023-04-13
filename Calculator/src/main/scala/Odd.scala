package com.knoldus

class Odd extends Operator {

  override def validate(operands: Seq[Double]): Boolean = {
    operands.length != 0
  }

  override protected def execute(operands: Seq[Double]): Seq[Double] = {
    operands.filter(_ % 2 != 0)
  }

}
