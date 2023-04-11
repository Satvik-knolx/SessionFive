package com.knoldus

import java.util.concurrent.locks.ReentrantReadWriteLock
import scala.util.{Failure, Success, Try}

class ReaderWriterProblem {

  // Create a reentrant read-write lock
  private val lock = new ReentrantReadWriteLock()

  // A list of strings
  private var data: List[String] = List("Initial Data")

  // A counter for the number of active readers
  private var readersCount = 0

  def readData(): Unit = {

    // Acquire the read lock to access
    lock.readLock().lock()

    // Increment the number of active readers
    readersCount += 1

    // Try to read data from and print it
    Try {
      println("Data: " + data.mkString(", "))
      println("Number of readers: " + readersCount)
    } match {

      // If the read operation is successful, decrement the number of active readers
      case Success(_) => readersCount -= 1

      // If an exception is thrown during the read operation, print an error message
      case Failure(exception) => println("Exception occurred: " + exception.getMessage)
    }

    // Release the read lock to allow other threads access
    lock.readLock().unlock()
  }

  def writeData(newData: String): Unit = {

    // Acquire the write lock to modify
    lock.writeLock().lock()

    // Try to append the new data and print it
    Try {
      data = data :+ newData
      println("Data after write: " + data.mkString(", "))
    } match {

      // If the write operation is successful, release the write lock
      case Success(_) => lock.writeLock().unlock()

      // If an exception is thrown during the write operation, print an error message
      case Failure(exception) => println("Exception occurred: " + exception.getMessage)
    }
  }
}

class MultipleThreadClass {

  val readerWriterProblem = new ReaderWriterProblem

  // Define several threads to write
  val writerThread1: Runnable = () => {
    readerWriterProblem.writeData("Hello")
  }
  val writerThread2: Runnable = () => {
    readerWriterProblem.writeData("World")
  }
  val writerThread3: Runnable = () => {
    readerWriterProblem.writeData("!")
  }
  val writerThread4: Runnable = () => {
    readerWriterProblem.writeData("Writer 1 writes")
  }
  val writerThread5: Runnable = () => {
    readerWriterProblem.writeData("Writer 2 writes")
  }

  // Define several threads to read
  val readerThread1: Runnable = () => {
    readerWriterProblem.readData()
  }
  val readerThread2: Runnable = () => {
    readerWriterProblem.readData()
  }
  val readerThread3: Runnable = () => {
    readerWriterProblem.readData()
  }
  val readerThread4: Runnable = () => {
    readerWriterProblem.readData()
  }
}
