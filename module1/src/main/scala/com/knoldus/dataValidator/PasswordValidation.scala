package com.knoldus.dataValidator

import org.slf4j.LoggerFactory

case class PasswordValidation(userName: String, password: String, email: String) {

  private val logger = LoggerFactory.getLogger(getClass)

  def isValidPassword(password: String): Boolean = {
    val nameComponents = userName.split("\\s+").toList.map(name => name.toLowerCase)
    val result = password.exists(_.isDigit) &&
      password.exists(_.isLower) &&
      password.exists(_.isUpper) &&
      !nameComponents.exists(password.toLowerCase.contains) &&
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