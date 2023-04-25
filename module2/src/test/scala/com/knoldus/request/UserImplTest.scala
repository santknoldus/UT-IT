package com.knoldus.request

import com.knoldus.models.User
import com.knoldus.validator.UserValidator
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class UserImplTest extends AnyFlatSpec with Matchers {

  val userValidator = new UserValidator
  val userImpl = new UserImpl(userValidator)

  "createUser" should "return a valid emailid" in {
    val user: User = User("Sant", "Singh", 23, 12000.0, "SDE", "Knoldus", "sant.singh@knoldus.com")
    userImpl.createUser(user) shouldEqual Some(user.emailId)
  }

  it should "return none because Company Name doesn't exist" in {
    val user = User("Tushar", "Dhiman", 25, 10000.0, "SDE", "Apple", "tushar.dhiman@apple.in")
    userImpl.createUser(user) shouldEqual None
  }

  it should "return none as emailid is not valid" in {
    val user = User("Manish", "Mishra", 24, 2000.0, "SDE", "Philips", "@philips.com")
    userImpl.createUser(user) shouldEqual None
  }
}