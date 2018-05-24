package controllers

import javax.inject._

import play.api.mvc._

/**
 * this controller is a demo for getting parameter from request
 */
@Singleton
class RequestController @Inject()(cc: ControllerComponents) (implicit assetsFinder: AssetsFinder) extends AbstractController(cc) {
  def reqparams = Action {implicit request =>
    Ok("request host: " + request.host);
  }
}