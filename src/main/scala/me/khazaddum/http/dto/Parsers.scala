package me.khazaddum.http.dto

import io.circe.generic.semiauto.{deriveDecoder, deriveEncoder}
import io.circe.{Decoder, Encoder}
import me.khazaddum.http.dto.Dtos.StandardResponse

trait Parsers {

  implicit val standardDecoder: Decoder[StandardResponse] = deriveDecoder[StandardResponse]
  implicit val standardEncoder: Encoder[StandardResponse] = deriveEncoder[StandardResponse]

}
