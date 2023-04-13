# Objective of the project

## Scala Calculator
This project implements a calculator that can perform various operations on operands. The following operators are supported:

    +: add two operands
    -: subtract second operand from the first operand
    *: multiply two operands
    /: divide the first operand by the second operand
    ^: raise the first operand to the power of the second operand
    sqrt: find the square root of the operand
    !: find the factorial of the number
    sum: add all the operands
    gcd: find the greatest common divisor of two operands
    odd: find all the odd operands
    even: find all the even operands
    fibonacci: find the fibonacci series till operand. Let's say if operand is 5 then the result should have first 5 fibonacci numbers

## Additional Methods
The project also includes the following additional methods:

## squareOfExpression
    This method checks if (firstOperand + secondOperand) ^ 2 == (firstOperand ^ 2) 
    + (secondOperand ^ 2) + (2 * firstOperand * secondOperand).
     If true, it returns "Equal", else it returns "Not Equal".

## find
    This method finds the numbers from the provided sequence whose factorial is 
    greater than 6 ^ number.

## findAverageAfterChainingOperations
    This method finds the fibonacci series of each number in the input sequence, 
    finds all the odd numbers from the resulting sequence, and returns their sum. 
    After performing this operation on each number in the input sequence, it finds 
    the average of the results.

# Prerequisites
    To run this project, you need to have Scala and SBT installed on your machine.

# How to run the project
To run the project, follow the below steps:

### Clone the project from the repository.

    https://github.com/Satvik-knolx/SessionFive.git
### Navigate to the project directory.

    cd Calculator
### Run the following command to build the project.

    sbt clean compile
### Run the following command to run the project.

    sbt run
# Usage
Once you have run the project, you can perform the following operations:

    Addition: Calculator.calculate("+", Seq(6, 2))
    Subtraction: Calculator.calculate("-", Seq(6, 3))
    Multiplication: Calculator.calculate("*", Seq(4, 3))
    Division: Calculator.calculate("/", Seq(6, 2))
    Power: Calculator.calculate("^", Seq(6, 2))
    SquareRoot: Calculator.calculate("sqrt", Seq(4))
    Factorial: Calculator.calculate("!", Seq(5))
    Sum: Calculator.calculate("sum", Seq(6, 4, 3, 5))
    GCD: Calculator.calculate("gcd", Seq(6, 3))
    Odd: Calculator.calculate("odd", Seq(6, 1, 4, 5, 8, 9))
    Even: Calculator.calculate("even", Seq(6, 0, 2, 5, 3, 1, 8))
    Fibonacci: Calculator.calculate("fibonacci", Seq(5))
    Square of expression: new SquaringFunction.squareOfExpression(6, 2)
    Find number with factorial value greater than 6^number: new Find.find(Seq(8, 27, 18, 6))


