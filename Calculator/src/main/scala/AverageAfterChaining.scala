package com.knoldus

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

class AverageAfterChaining extends Fibonacci {
  def findAverageAfterChainingOperations(numbers: Seq[Double]): Future[Double] = {
    val seqOfFibonacci = numbers.map(values => fibonacciSeries(values.toInt))
    val oddFibonacciValues = seqOfFibonacci.flatMap(_.filter(_ % 2 != 0))
    val oddFibonacciSum = oddFibonacciValues.sum
    val averageAfterChainingOperations = Future(oddFibonacciSum.toDouble / oddFibonacciValues.size)
    averageAfterChainingOperations
  }
}
