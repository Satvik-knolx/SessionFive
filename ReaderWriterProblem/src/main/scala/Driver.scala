package com.knoldus

object Driver extends App {

  private val multipleThreads = new MultipleThreadClass

  // create threads for reading
  private val reader1 = new Thread(multipleThreads.writerThread1)
  private val reader2 = new Thread(multipleThreads.writerThread2)
  private val reader3 = new Thread(multipleThreads.writerThread3)
  private val reader4 = new Thread(multipleThreads.readerThread4)

  // create threads for writing
  private val writer1 = new Thread(multipleThreads.readerThread1)
  private val writer2 = new Thread(multipleThreads.readerThread2)
  private val writer3 = new Thread(multipleThreads.readerThread3)
  private val writer4 = new Thread(multipleThreads.writerThread4)
  private val writer5 = new Thread(multipleThreads.writerThread5)

  // start all threads
  reader1.start()
  reader2.start()
  reader3.start()
  reader4.start()
  writer1.start()
  writer2.start()
  writer3.start()
  writer4.start()
  writer5.start()

  // wait for all threads to complete
  reader1.join()
  reader2.join()
  reader3.join()
  reader4.join()
  writer1.join()
  writer2.join()
  writer3.join()
  writer4.join()
  writer5.join()
}
