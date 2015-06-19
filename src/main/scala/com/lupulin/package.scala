
package com

import java.nio.charset.Charset
import scodec.Codec
import scodec.codecs._
import java.util.Date


package object lupulin {
  /**
   * A fixed 16 bit field for a char -- The think this is the maximum any char in any language would take to encode, or
   * was it 32 for some Asian languages? Well this should be PLENTY for this scope.
   * @param charset charset to use to convert strings to/from binary
   * @return a Char codec
   **/

  def char(implicit charset: Charset):Codec[Char] = fixedSizeBits[String](16,string(charset)).xmap[Char](_.charAt(0),_.toString)

  /**
   * ASCII encoded Char
   */
  val asciiChar = char(Charset.forName("US-ASCII"))

  /**
    * UTF8 encoded Char
    */
  val utf8Char = char(Charset.forName("UTF-8"))

  /**
   * Ok, Ok, this is possibly the simplest form to encode a Date. If this was a distributed system, some non relative form
   * would be needed. Personally I'd switch to JodaTime.
   */
  val simpleDateCodec = int64.xmap[Date](new Date(_),_.getTime)
}
