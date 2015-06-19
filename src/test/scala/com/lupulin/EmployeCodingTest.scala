
package com.lupulin

import org.scalatest.{Matchers, FunSpec}
import scodec.Codec
import java.util.Date
import scodec.codecs.implicits._
import implicits._

/**
 * Test the encode and decode of an employee.
 */
class EmployeCodingTest extends FunSpec with Matchers{
  describe("Employee encode/decode Test") {
    it("should encode and decode with all fields."){
      //I hope my time employment would be longer than his...
      val employee = Employee("John",Some('A'),"Doe",new Date(1),new Date(System.currentTimeMillis()-1000),Some(new Date(System.currentTimeMillis())),45)
      val employeeEncoded = Codec.encode(employee)
      employeeEncoded.isSuccessful shouldBe true
      //Sanity check and keep up my hex counting skilz.
      println(s"Encoded Employee: ${employeeEncoded}")
      val decodedEmployeeAttempt = employeeEncoded.flatMap(Codec.decode[Employee](_))
      // should succeed
      decodedEmployeeAttempt.isSuccessful shouldBe true
      // should equal the original
      decodedEmployeeAttempt.toOption.map(_.value).foreach(_ shouldEqual employee)
      // frivolously it should not equal something else.
      decodedEmployeeAttempt.toOption.map(_.value).foreach(_ should not equal (Employee.defaultEmplyee))

    }
    it("should encode and decode without optional fields."){
      val employee = Employee("Ryan",Some('M'),"Heine",new Date(247730400),new Date(System.currentTimeMillis()-1000),None,999)
      val employeeEncoded = Codec.encode(employee)
      employeeEncoded.isSuccessful shouldBe true
      //Sanity check and keep up my hex counting skilz.
      println(s"Encoded Employee: ${employeeEncoded}")
      val decodedEmployeeAttempt = employeeEncoded.flatMap(Codec.decode[Employee](_))
      // should succeed
      decodedEmployeeAttempt.isSuccessful shouldBe true
      // should equal the original
      decodedEmployeeAttempt.toOption.map(_.value).foreach(_ shouldEqual employee)
      // frivolously it should not equal something else.
      decodedEmployeeAttempt.toOption.map(_.value).foreach(_ should not equal (Employee.defaultEmplyee))

    }
  }
}
