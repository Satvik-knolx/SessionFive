package com.knoldus

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.io.Source

// Define case class for student grade
case class StudentGrade(studentId: String, englishGrade: Double, physicsGrade: Double, chemistryGrade: Double, mathsGrade: Double)

object GradesCalculator {

  // Function to parse CSV file and return list of rows as maps
  def parseCsv(filePath: String): Future[List[Map[String, String]]] = {
    Future {
      val file = Source.fromFile(filePath)
      val lines = file.getLines().toList
      val headers = lines.head.split(",").map(_.trim)
      val data = lines.tail
      file.close()

      // Convert each row into a map with headers as keys and row data as values
      data.map { line =>
        val values = line.split(",").map(_.trim)
        headers.zip(values).toMap
      }
    }.recover {
      case _: java.io.FileNotFoundException => throw new Exception(s"Invalid path to CSV file: $filePath")
    }
  }

  // Function to calculate averages for each student based on their grades
  def calculateStudentAverages(gradesData: Future[List[StudentGrade]]): Future[List[(String, Double)]] = {
    gradesData.flatMap { grades =>
      Future.sequence {
        grades.map { grade =>
          val studentId = grade.studentId
          val totalGrade = grade.englishGrade + grade.physicsGrade + grade.chemistryGrade + grade.mathsGrade
          val averageGrade = totalGrade / 4.0
          Future.successful((studentId, averageGrade))
        }
      }
    }
  }

  // Function to calculate class average based on student averages
  def calculateClassAverage(averagesData: Future[List[(String, Double)]]): Future[Double] = {
    averagesData.map { rows =>
      val averages = rows.map(_._2)
      val total = averages.sum
      val count = averages.size
      total / count
    }
  }

  // Function to calculate overall grade for the class
  def calculateGrades(filePath: String): Future[Double] = {
    parseCsv(filePath).flatMap { data =>
      val studentGrades = data.map { row =>
        StudentGrade(
          row("StudentID"),
          row("English").toDouble,
          row("Physics").toDouble,
          row("Chemistry").toDouble,
          row("Maths").toDouble
        )
      }

      val studentAverages = calculateStudentAverages(Future.successful(studentGrades))
      val classAverage = calculateClassAverage(studentAverages)

      classAverage.map(avg => {
        println("Student Averages:")
        studentAverages.foreach(println)
        val grade = avg / 10.0
        println(s"Grade: $grade")
        avg
      })
    }
  }
}
