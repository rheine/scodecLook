
package com.lupulin

import org.scalatest.FunSpec
import org.scalatest.Matchers
import scodec._
import scala.util.Random
import java.util.Date
import scodec.codecs.implicits._
import implicits._

/**
 * First a little playing around with the unfamiliar scodec library...
 */
class SimpleTest extends FunSpec with Matchers{

  describe("Integer encode/decode") {
    it("should encode and decode an integer."){
      val int = Random.nextInt()
      val intBin = Codec.encode(int)
      intBin.isSuccessful shouldBe true
      val reInt = Codec.decode[Int](intBin.require)
      reInt.require.value shouldEqual int

    }
  }

  describe("String encode/decode") {
    it("should encode and decode a string."){
      val string = Random.nextString(20)
      val stringBin = Codec.encode(string)
      stringBin.isSuccessful shouldBe true
      val reString = Codec.decode[String](stringBin.require)
      reString.require.value shouldEqual string

    }
  }

  describe("Char encode/decode") {
    it("should encode and decode a char."){
      val ch = Random.nextPrintableChar()
      val chBin = Codec.encode(ch)
      chBin.isSuccessful shouldBe true
      val reChar = Codec.decode[Char](chBin.require)
      reChar.require.value shouldEqual ch

    }
  }

  describe("Date encode/decode") {
    val date = new Date()
    val dateBin = Codec.encode(date)
    try {
    val reDate = Codec.decode[Date](dateBin.require)
    reDate.require.value shouldEqual date
    } catch {
      case any:Exception => any.getMessage shouldEqual ""
    }

    }
}
