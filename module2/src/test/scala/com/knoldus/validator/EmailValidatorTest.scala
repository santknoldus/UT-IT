package com.knoldus.validator

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class EmailValidatorTest extends AnyFlatSpec with Matchers {

  val emailValidator = new EmailValidator

  behavior of "EmailValidatorTest"

  it should "emailIdIsValid" in {
    val email = "sant@gmail.com"
    emailValidator.emailIdIsValid(email) shouldEqual true
  }

  it should "emailIdIsValid as . can be added before @" in {
    val email = "he.she@xyz.com"
    emailValidator.emailIdIsValid(email) shouldEqual true
  }

  it should "emailIdIsValid as email can have numbers" in {
    val email = "he12.she@xyz.com"
    emailValidator.emailIdIsValid(email) shouldEqual true
  }

  it should "emailIdIsInValid as @ not available" in {
    val email = "he.she.xyz.com"
    emailValidator.emailIdIsValid(email) shouldEqual false
  }

  it should "emailIdIsInValid as domain not available" in {
    val email = "he.she@"
    emailValidator.emailIdIsValid(email) shouldEqual false
  }

}
