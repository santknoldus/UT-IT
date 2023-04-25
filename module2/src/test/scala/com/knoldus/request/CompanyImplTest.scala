package com.knoldus.request

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import com.knoldus.models.Company
import com.knoldus.validator.CompanyValidator

class CompanyImplTest extends AnyFlatSpec with Matchers {

  val companyValidator = new CompanyValidator
  val companyImpl = new CompanyImpl(companyValidator)

  "createCompany" should "return valid company name" in {
    val company: Company = Company("Wipro", "wipro123@gmail.com", "Noida")
    companyImpl.createCompany(company) shouldEqual Some(company.name)
  }

  it should "return none as the company already present in database" in {
    val company: Company = Company("Knoldus", "wipro123@gmail.com", "Noida")
    companyImpl.createCompany(company) shouldEqual None
  }

  it should "return None as invalid email has been provided" in {
    val company: Company = Company("Accenture", "accenture.gmail.com", "Noida")
    companyImpl.createCompany(company) shouldEqual None
  }
}