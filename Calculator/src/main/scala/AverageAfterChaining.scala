package com.knoldus

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

class AverageAfterChaining extends Fibonacci {
  def findAverageAfterChainingOperations(numbers: Seq[Double]): Future[Double] = {
    val seqOfFibonacci = numbers.map(values => fibonacciSeries(values.toInt))
    println(seqOfFibonacci)
    val oddFibonacciValues = seqOfFibonacci.flatMap(_.filter(_ % 2 != 0))
    println(oddFibonacciValues)
    val oddFibonacciSum = oddFibonacciValues.sum
    println(oddFibonacciSum)
    val averageAfterChainingOperations = Future(oddFibonacciSum.toDouble / oddFibonacciValues.size)
    println(averageAfterChainingOperations)
    averageAfterChainingOperations
  }
}
