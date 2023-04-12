package com.knoldus

import scala.concurrent.Await
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._
import scala.util.{Failure, Success}

object Driver {
  def main(args: Array[String]): Unit = {
    // Path to the CSV file containing student grades
    val path = "/home/knoldus/SessionFive/StudentsGrades/src/main/scala/studentgrades.csv"

    // Parsing the CSV file and printing the student grades
    val parsedCsv = GradesCalculator.parseCsv(path)
    Await.result(parsedCsv, 10.seconds)
    parsedCsv.onComplete {
      case Success(rows) =>
        println("\nStudent Grades:")
        rows.foreach { row =>
          val id = row("StudentID")
          val grade = ((row("English").toDouble + row("Physics").toDouble + row("Chemistry").toDouble + row("Maths").toDouble) / 40.0).formatted("%.1f")
          println(s"  Student $id: $grade")
        }
      case Failure(ex) =>
        println(s"An error occurred: ${ex.getMessage}")
    }

    // Calculating student averages and printing them
    val studentGrades = parsedCsv.map { rows =>
      rows.map { row =>
        StudentGrade(
          row("StudentID"),
          row("English").toDouble,
          row("Physics").toDouble,
          row("Chemistry").toDouble,
          row("Maths").toDouble
        )
      }
    }
    val studentAverages = GradesCalculator.calculateStudentAverages(studentGrades)

    studentAverages.onComplete {
      case Success(averages) =>
        println("\nStudent Averages:")
        averages.foreach { case (id, avg) =>
          println(s"  Student $id: $avg")
        }
      case Failure(ex) =>
        println(s"An error occurred: ${ex.getMessage}")
    }

    // Calculating class average and printing it
    val classAverage = GradesCalculator.calculateClassAverage(studentAverages)

    classAverage.onComplete {
      case Success(avg) => println(s"\nClass Average: $avg")
      case Failure(ex) => println(s"An error occurred: ${ex.getMessage}")
    }

    Await.result(studentAverages, 10.seconds)
    Await.result(classAverage, 10.seconds)
    Await.result(classAverage, 10.seconds)

  }
}
