package me.khazaddum.http.dto

object Dtos {

  sealed trait HttpRequest

  sealed trait HttpResponse {
    val dateTime: String
    val message: String
  }

  case class StandardResponse(
    dateTime: String,
    message:  String
  ) extends HttpResponse

}
