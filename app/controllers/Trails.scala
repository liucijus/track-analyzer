package controllers

import lt.overdrive.trackparser.parsing.Parser
import play.api.mvc._
import play.api.libs.json._
import lt.overdrive.trackparser.domain.{Trail, TrackPoint, Track}
import lt.overdrive.trackparser.processing.{TrackRectangle, TrackProcessor}
import scala.util.{Success, Failure}

object Trails extends Controller {

  def index = Action {
    Ok(views.html.map())
  }

  def upload = Action(parse.multipartFormData) {
    request =>
      request.body.file("file").map {
        trailFile =>
          Parser.parserFile(trailFile.ref.file) match {
            case Success(trail) => {
              val jsonTracks = trail.tracks.toList.map(convertToJson)
              val trailJson = Json.toJson(jsonTracks)

              val json = Json.obj("box" -> boxJson(trail), "trail" -> trailJson)

              Ok(json)
            }
            case Failure(e) => BadRequest(Json.toJson("Unrecognized file!"))
          }
      }.getOrElse {
        BadRequest(Json.toJson("Missing file!"))
      }
  }


  private def boxJson(trail: Trail): Json.JsValueWrapper = {
    TrackProcessor.calculateRectangle(trail.tracks) match {
      case Some(box) => createBoxJson(box)
      case None => JsNull
    }
  }

  private def convertToJson(track: Track) = {
    val points = track.points.toList
    Json.toJson(points.map(p => Json.obj(
      "lat" -> p.latitude,
      "lng" -> p.longitude,
      "alt" -> {
        p.altitude match {
          case Some(altitude) => altitude
          case None => JsNull
        }
      }
    )))
  }

  private def createBoxJson(box: TrackRectangle) = {
    def createJsonPoint(point: TrackPoint): Json.JsValueWrapper = {
      Json.obj(
        "lat" -> point.latitude,
        "lon" -> point.longitude
      )
    }
    Json.obj(
      "top" -> createJsonPoint(box.northEast),
      "bottom" -> createJsonPoint(box.southWest),
      "center" -> createJsonPoint(box.centerPoint)
    )
  }
}