package com.knoldus

class Division extends Operator {

  override def validate(operands: Seq[Double]): Boolean = {
    operands.length == 2 && operands(1) != 0
  }

  override def validateAndExecute(operands: Seq[Double]): Seq[Double] = {
    if (validate(operands)) {
      execute(operands)
    } else {
      throw new Exception("Number of operands should be two and divisor should not be zero")
    }
  }

  override protected def execute(operands: Seq[Double]): Seq[Double] = {
    Seq(operands(0) / operands(1))
  }
}
