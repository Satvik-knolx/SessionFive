package com.knoldus

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

trait Validator {
  //validate the operands for the specific operator
  def validate(operands: Seq[Double]): Boolean
}

trait Operator extends Validator {
  //validate and execute - implement this function in trait
  //this function will validate the operands and execute it.
  //throw CalculatorException when validation fails.
  def validateAndExecute(operands : Seq[Double]) : Seq[Double]  = {
    if (validate(operands)) {
      execute(operands)
    } else {
      throw new Exception("Number of operands is invalid")
    }
  }
  protected def execute(operands : Seq[Double]) : Seq[Double]
}

object Calculator {
  def calculate(operator : String, operands : Seq[Double]) : Future[Seq[Double]] = {
    operator match {
      case "+" => execute(new Addition, operands)
      case "-" => execute(new Subtraction, operands)
      case "*" => execute(new Multiplication , operands)
      case "/" => execute(new Division , operands)
      case "^" => execute(new Power , operands)
      case "sqrt" => execute(new SquareRoot , operands)
      case "!" => execute(new Factorial , operands)
      case "sum" => execute(new Sum , operands)
      case "gcd" => execute(new GCD, operands)
      case "odd" => execute(new Odd , operands)
      case "even" => execute(new Even , operands)
      case "fibonacci" => execute(new Fibonacci , operands)
    }
  }
  private def execute(operator: Operator, operands : Seq[Double]) : Future[Seq[Double]] = {
    Future  {
      operator.validateAndExecute(operands)
    }
  }
}
