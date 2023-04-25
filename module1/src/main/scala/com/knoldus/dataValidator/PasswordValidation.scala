package com.knoldus.dataValidator

import org.slf4j.LoggerFactory

case class PasswordValidation(userName: String, password: String, email: String) {

  private val logger = LoggerFactory.getLogger(getClass)

  def isValidPassword(password: String): Boolean = {
    val splitUserFullName = userName.split(" ").toList
    val result = password.exists(_.isDigit) &&
      password.exists(_.isLower) &&
      password.exists(_.isUpper) &&
      !password.contains(splitUserFullName.head) &&
      !password.contains(splitUserFullName.tail) &&
      hasSpecialChar(password)

    logger.info(s"Password '$password' validation result: $result")
    result
  }

  private def hasSpecialChar(string: String): Boolean =
    string.exists(char =>
      char == '%' ||
        char == '@' ||
        char == '#' ||
        char == '&' ||
        char == '&' ||
        char == '$'
    )
}