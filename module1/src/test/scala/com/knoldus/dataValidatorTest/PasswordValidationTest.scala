package com.knoldus.dataValidatorTest

import com.knoldus.dataValidator.PasswordValidation
import org.scalatest.flatspec.AnyFlatSpec

class PasswordValidationTest extends AnyFlatSpec {

  "A password" should "be invalid if it doesn't have a digit" in {
    val validator = PasswordValidation("Sant Singh", "abcABC$", "sant.singh@email.com")
    assert(!validator.isValidPassword(validator.password))
  }

  it should "be invalid if it doesn't have a lowercase letter" in {
    val validator = PasswordValidation("Tushar Chopra", "ABC123", "tushar.chopra@email.com")
    assert(!validator.isValidPassword(validator.password))
  }

  it should "be invalid if it doesn't have an uppercase letter" in {
    val validator = PasswordValidation("John Smith", "abc123$", "john.smith@email.com")
    assert(!validator.isValidPassword(validator.password))
  }

  it should "be invalid if it contains the username" in {
    val validator = PasswordValidation("John Doe", "johnDoe123$", "john.doe@email.com")
    assert(!validator.isValidPassword(validator.password))
  }

  it should "be invalid if it doesn't have a special character" in {
    val validator = PasswordValidation("John Wick", "abcABC123", "john.wick@gmail.com")
    assert(!validator.isValidPassword(validator.password))
  }

  it should "be valid if it meets all the requirements" in {
    val validator = PasswordValidation("Chris Evans", "Abc123%", "chris.evans@email.com")
    assert(validator.isValidPassword(validator.password))
  }
}