package controllers


import javax.inject._

import play.api.mvc._
import play.api.Configuration

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class ConfigController @Inject()(cc: ControllerComponents, config: Configuration) (implicit assetsFinder: AssetsFinder)
  extends AbstractController(cc) {

  /**
   * Create an Action to render an HTML page with a welcome message.
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  def democonfig = Action {
    Ok(config.get[String]("netc.demo.testkey1"));
  }

}