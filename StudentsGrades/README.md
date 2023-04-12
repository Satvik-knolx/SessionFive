# Objective of the project

You have been given a CSV file containing student grades in the following format:

    StudentID,English,Physics,Chemistry,Maths
    1,80,70,90,85
    2,75,80,70,90
    3,85,90,80,75
    4,70,85,90,80
    5,60,75,70,90

## Write a program to calculate the average grade for each student and then the class average. The program should use the Future API to perform the calculations asynchronously and implement the following functions:

###   parseCsv: 
    This function takes a path to the CSV file and returns a Future[List[Map[String, String]]] representing the parsed CSV data.
    The Map object should contain the column name as the key and the cell value as the value. 
    If the file does not exist or cannot be read, the Future should fail with an appropriate error message.

###    calculateStudentAverages: 
    This function takes a Future[List[Map[String, String]]] representing the parsed CSV data and returns a Future[List[(String, Double)]] representing the average grade for each student. 
    The List object contains a tuple for each student, where the first element is the student ID and the second element is the average grade. 
    If the input Future fails, the calculateStudentAverages function should return a failed Future with the same error.

###    calculateClassAverage: 
    This function takes a Future[List[(String, Double)]] representing the student averages and returns a Future[Double] representing the class average. 
    The class average should be calculated as the arithmetic mean of the student averages. 
    If the input Future fails, the calculateClassAverage function should return a failed Future with the same error

###   calculateGrades: 
    Use the first three functions to implement this function that takes a path to the CSV file and returns a Future[Double] representing the class average. 
    This function should use the map, flatMap, and recover callbacks of the Future API to chain the asynchronous operations together and handle errors.              
    Alternatively, you can also use for-comprehension to chain together multiple map and flatMap calls.

## About The Project
This program is designed to read student grades data from a CSV file, calculate and display various averages and grades for each student and the class as a whole.

The program has several functions defined in the GradesCalculator object that handle various aspects of the calculations, such as parseCsv function that reads a CSV file and returns its contents as a list of maps, calculateStudentAverages function that calculates the average grade for each student based on their grades in English, Physics, Chemistry, and Maths, and calculateClassAverage function that calculates the average grade for the entire class based on the average grades of all students.

The Driver object is the entry point of the program and contains the main function that runs the program. It uses the functions defined in the GradesCalculator object to perform the necessary calculations and print the results to the console.

Overall, this program provides a simple and effective way to calculate and analyze student grades data using Scala programming language.



