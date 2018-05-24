package controllers

import javax.inject.Inject
import com.google.inject.Singleton
import play.api.libs.json._
import play.api.mvc.{ Action, Controller }
import play.api.libs.functional.syntax._

case class Obj(id: Option[Long], email: String, firstName: String, lastName: String)

@Singleton
class ObjectController @Inject() (implicit assetsFinder: AssetsFinder) extends Controller {

  def testexception = Action {
    Integer.parseInt("dfsdfsd");
    Ok("Hope to show this result.");
  }

  def all = Action { implicit request =>
    //    val objs = Seq(
    //      Obj(Option(1L),"gkazoura@example.com","Emmanouil","Gkatziouras"),
    //      Obj(Option(2L),"john@doe.com","John","Doe"),
    //      Obj(Option(3L),"john2@doe.com","John2","Doe2")
    //    )
    val obj = new Obj(Option(1L), "gkazoura@example.com", "Emmanouil", "Gkatziouras");
    Ok(Json.toJson(obj.email))
  }
  def greet = Action
  def add = Action { implicit request =>
    val obj = Json.fromJson[Obj](request.body.asJson.get).get
    val newObj = Obj(Option(4L), obj.email, obj.firstName, obj.lastName)
    Ok(Json.toJson(newObj.email))
  }
  implicit val objWrites = new Writes[Obj] {
    def writes(obj: Obj) = Json.obj(
      "id" -> obj.id,
      "email" -> obj.email,
      "firstName" -> obj.firstName,
      "lastName" -> obj.lastName)
  }
  implicit val objReads: Reads[Obj] = (
    (__ \ "id").readNullable[Long] and
    (__ \ "email").read[String] and
    (__ \ "firstName").read[String] and
    (__ \ "lastName").read[String])(Obj.apply _)
}