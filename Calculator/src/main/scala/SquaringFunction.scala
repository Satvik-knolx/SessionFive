package com.knoldus

class SquaringFunction extends Power {
  def squareOfExpression(firstOperand: Double, secondOperand: Double): String = {
    val leftSide = power(firstOperand + secondOperand, 2)
    val rightSide = power(firstOperand, 2) + power(secondOperand, 2) + (2 * firstOperand * secondOperand)
    if ( leftSide == rightSide ) {
      "Equal"
    } else {
      "Not Equal"
    }
  }
}
