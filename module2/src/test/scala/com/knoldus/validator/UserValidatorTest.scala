package com.knoldus.validator

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import com.knoldus.models.User

class UserValidatorTest extends AnyFlatSpec with Matchers {

  val userValidator = new UserValidator

  "userIsValid" should "return true as company name already exist and email is valid" in {
    val user: User = User("Sant", "Singh", 23, 12000.0, "SDE", "Knoldus", "sant.singh@knoldus.com")
    userValidator.userIsValid(user) shouldEqual true
  }

  "userIsValid" should "return false as company name doesn't exist" in {
    val user = User("Tushar", "Dhiman", 25, 10000.0, "SDE", "Apple", "tushar.dhiman@apple.in")
    userValidator.userIsValid(user) shouldEqual false
  }

  "userIsValid" should "return false as company name exist but emailid is not valid" in {
    val user = User("Manish", "Mishra", 24, 2000.0, "SDE", "Philips", "@philips.com")
    userValidator.userIsValid(user) shouldEqual false
  }
}