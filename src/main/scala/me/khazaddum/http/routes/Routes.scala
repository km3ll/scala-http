package me.khazaddum.http.routes

import java.time.ZonedDateTime
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.model.StatusCodes.OK
import akka.http.scaladsl.server.Directives.{ complete, extractRequest, get, path }
import akka.http.scaladsl.server.Route
import com.typesafe.scalalogging.LazyLogging
import de.heikoseeberger.akkahttpcirce.FailFastCirceSupport._
import me.khazaddum.http.dto.Dtos.StandardResponse
import me.khazaddum.http.dto.Parsers

trait Routes extends Parsers with LazyLogging {

  protected def now: ZonedDateTime = ZonedDateTime.now

  val routes: Route = {
    extractRequest { request =>
      logger.debug( request.toString )
      status //~ otherRoutes
    }
  }

  def status: Route = path( "status" ) {
    get {
      complete( OK -> StandardResponse( now.toString, "UP!" ) )
    }
  }

}
