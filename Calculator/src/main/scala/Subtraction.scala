package com.knoldus

class Subtraction extends Operator {

  override def validate(operands: Seq[Double]): Boolean = {
    operands.length == 2
  }

  override def validateAndExecute(operands: Seq[Double]): Seq[Double] = {
    if (validate(operands)) {
      execute(operands)
    } else {
      throw new Exception("Number of operands should be 2")
    }
  }

  override protected def execute(operands: Seq[Double]): Seq[Double] = {
    Seq(operands(0) - operands(1))
  }

}
