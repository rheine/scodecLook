
package com.lupulin

import scodec.Codec
import java.util.Date

object implicits {
  // new implicit codec definitions.
  implicit val implicitCharCodec: Codec[Char] = utf8Char
  implicit val implicitDateCodec: Codec[Date] = simpleDateCodec
}
