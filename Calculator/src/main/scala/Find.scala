package com.knoldus

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.math.pow

class Find extends Factorial {
  def find(numbers : Seq[Double]) : Future[Seq[Double]] = {
    Future  {
      numbers.filter(numbers => factorial(numbers,1) > pow(6,numbers) )
    }
  }


}
