package com.knoldus.dataValidator

import org.slf4j.LoggerFactory

import scala.annotation.tailrec
import scala.util.Try

class DataValidation {
  private val logger = LoggerFactory.getLogger(getClass)

  def isContainsDuplicateElement[T](list: List[T]): Boolean = {
    def removeDuplicates(list: List[T]): List[T] = list match {
      case Nil => List.empty[T]
      case head :: tail => head :: removeDuplicates(tail.filter(_ != head))
    }

    val distinctList = removeDuplicates(list)
    val result = distinctList.length != list.length

    logger.info(s"Input list: $list")
    logger.info(s"Distinct list: $distinctList")
    logger.info(s"Result: $result")

    result
  }

  def findFactorial(number: Int): Try[Double] = {
    if (number < 0) {
      logger.error("Input must be a non-negative integer.")
      Try(throw new IllegalArgumentException("Input must be a non-negative integer."))
    } else {
      @tailrec
      def generateFactorial(number: Int, factorial: Double): Double = {
        if (number == 0) factorial
        else {
          logger.debug(s"Multiplying $factorial by $number")
          generateFactorial(number - 1, factorial * number)
        }
      }

      val result = Try(generateFactorial(number, 1))
      logger.info(s"Factorial of $number is $result")
      result
    }
  }
}