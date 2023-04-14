package com.knoldus

import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Success}

object Driver extends App {

  private val addition = Calculator.calculate("+", Seq(6, 2))
  private val subtraction = Calculator.calculate("-", Seq(6, 3))
  private val multiplication = Calculator.calculate("*", Seq(4, 3))
  private val division = Calculator.calculate("/", Seq(6, 2))
  private val power = Calculator.calculate("^", Seq(6, 2))
  private val squareRoot = Calculator.calculate("sqrt", Seq(4))
  private val factorial = Calculator.calculate("!", Seq(5))
  private val sum = Calculator.calculate("sum", Seq(6, 4, 3, 5))
  private val gcd = Calculator.calculate("gcd", Seq(6, 3))
  private val odd = Calculator.calculate("odd", Seq(6, 1, 4, 5, 8, 9))
  private val even = Calculator.calculate("even", Seq(6, 0, 2, 5, 3, 1, 8))
  private val fibonacci = Calculator.calculate("fibonacci", Seq(5))

  addition.onComplete {
    case Failure(exception) => println(s"${exception.getMessage}")
    case Success(value) => println(s"Addition Result: $value")
  }

  subtraction.onComplete {
    case Failure(exception) => println(s"${exception.getMessage}")
    case Success(value) => println(s"Subtraction Result: $value")
  }

  multiplication.onComplete {
    case Success(value) => println(s"Multiplication Result: $value")
    case Failure(exception) => println(s"${exception.getMessage}")
  }

  division.onComplete {
    case Success(value) => println(s"Division Result: $value")
    case Failure(exception) => println(s"${exception.getMessage}")
  }

  power.onComplete {
    case Success(value) => println(s"Power Result: $value")
    case Failure(exception) => println(s"${exception.getMessage}")
  }

  squareRoot.onComplete {
    case Success(value) => println(s"SquareRoot Result: $value")
    case Failure(exception) => println(s"${exception.getMessage}")
  }
  factorial.onComplete {
    case Success(value) => println(s"Factorial Result: $value")
    case Failure(exception) => println(s"${exception.getMessage}")
  }
  sum.onComplete {
    case Success(value) => println(s"Sum Result: $value")
    case Failure(exception) => println(s"${exception.getMessage}")
  }
  gcd.onComplete {
    case Success(value) => println(s"GCD Result: $value")
    case Failure(exception) => println(s"${exception.getMessage}")
  }
  odd.onComplete {
    case Success(value) => println(s"Odd Result: $value")
    case Failure(exception) => println(s"${exception.getMessage}")
  }
  even.onComplete {
    case Success(value) => println(s"Even Result: $value")
    case Failure(exception) => println(s"${exception.getMessage}")
  }
  fibonacci.onComplete {
    case Success(value) => println(s"Fibonacci Result: $value")
    case Failure(exception) => println(s"${exception.getMessage}")
  }
  private val squaringFunction = new SquaringFunction
  private val squaringFunctionResult = squaringFunction.squareOfExpression(6, 2)
  println(s"Square of expression result: $squaringFunctionResult")

  private val find = new Find
  private val findResult = find.find(Seq(8, 27, 18, 6))
  findResult.onComplete {
    case Success(value) => println(s"Find number with factorial value >  6 ^ number : $value")
    case Failure(exception) => println(s"${exception.getMessage}")
  }

  private val averageAfterChaining = new AverageAfterChaining
  private val averageAfterChainingResult = averageAfterChaining.findAverageAfterChainingOperations(Seq(1, 2, 3, 4, 5, 6))
  averageAfterChainingResult.onComplete {
    case Success(value) => println(s"Average after chaining operations : $value")
    case Failure(exception) => println(s"${exception.getMessage}")
  }
}
