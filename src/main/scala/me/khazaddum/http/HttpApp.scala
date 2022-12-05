package me.khazaddum.http

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import com.typesafe.scalalogging.LazyLogging
import me.khazaddum.http.routes.Routes
import me.khazaddum.http.config.HttpConfig
import pureconfig._
import pureconfig.generic.auto._
import scala.concurrent.{ Await, ExecutionContextExecutor, Future }
import scala.util.{ Failure, Success }
import scala.concurrent.duration._
import scala.io.StdIn

object HttpApp extends App with Routes with LazyLogging {

  implicit val system: ActorSystem = ActorSystem( "MainApp" )
  implicit val dispatcher: ExecutionContextExecutor = system.dispatcher

  // Start
  logger.info( "Starting" )

  val config = ConfigSource.default.at( "http" ).load[HttpConfig]
    .getOrElse( HttpConfig( "localhost", 8080 ) )

  val server: Future[Http.ServerBinding] =
    Http().newServerAt( config.host, config.port )
      .bind( routes )

  server.onComplete {
    case Success( Http.ServerBinding( localAddress ) ) =>
      logger.info( s"Server online at ${localAddress.getAddress}:${localAddress.getPort}" )
    case Failure( ex ) =>
      logger.error( s"There was an error while starting server", ex )
  }

  StdIn.readLine()

  val onceAllConnectionsTerminated: Future[Http.HttpTerminated] =
    Await.result( server, 10.seconds )
      .terminate( hardDeadline = 3.seconds )

  onceAllConnectionsTerminated.foreach { _ =>
    logger.info( "Stopping" )
    Await.result( system.terminate(), 10.seconds )
  }

}