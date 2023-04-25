package com.knoldus.dataValidatorTest

import com.knoldus.dataValidator.DataValidation
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class DataValidationTest extends AnyFlatSpec with Matchers{

  val dataValidation = new DataValidation

  "isContainsDuplicateElement" should "return true if a list contains duplicate elements" in {
    val inputList = List(1, 2, 3, 4, 5, 1)
    val result = dataValidation.isContainsDuplicateElement(inputList)
    result shouldEqual true
  }

  it should "return false if a list does not contain duplicate elements" in {
    val inputList = List(1, 2, 3, 4, 5)
    val result = dataValidation.isContainsDuplicateElement(inputList)
    result shouldEqual false
  }

  it should "return false if an empty list is passed as input" in {
    val inputList = List.empty[Int]
    val result = dataValidation.isContainsDuplicateElement(inputList)
    result shouldEqual false
  }

  "findFactorial" should "return a Success with the factorial value for a non-negative integer input" in {
    val inputNumber = 5
    val result = dataValidation.findFactorial(inputNumber)
    result.isSuccess shouldEqual true
    result.get shouldEqual 120
  }

  it should "return 1 for input number 0" in {
    val inputNumber = 0
    val result = dataValidation.findFactorial(inputNumber)
    result.isSuccess shouldEqual true
    result.get shouldEqual 1
  }

  it should "return a Failure for a negative integer input" in {
    val inputNumber = -1
    val result = dataValidation.findFactorial(inputNumber)
    result.isFailure shouldEqual true
  }
}