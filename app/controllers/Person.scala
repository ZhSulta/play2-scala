package controllers

import controllers.Application._
import play.api._
import play.api.data.Form
import play.api.data.Forms._
import play.api.mvc._
import play.api.libs.json.{JsValue, Json}
import models._
import play.api.libs.json.Json._
import play.api.db.slick.Config.driver.simple._
import play.api.db.slick._

object Person extends Controller {

  def index = Action {
    Ok(views.html.marketing.about("Home"))
  }

  lazy val persons = TableQuery[PersonTable]

  //JSON read/write macro
  implicit val personFormat = Json.format[PersonModel]

  def getAll = DBAction { implicit rs =>
    Ok(Json.toJson(persons.run))
  }

  val personForm = Form(
    mapping(
      "id" -> longNumber,
      "name" -> text()
    )(PersonModel.apply)(PersonModel.unapply)
  )

  def delete(id: Long) = DBAction { implicit rs =>
    persons.filter(p => p.id === id).delete
//    Person.delete(id)
    Ok("Deleted " + id)
  }

  def create = DBAction { implicit rs =>
    println("sssssssssssssssssssssssssssssssss")

    val person = personForm.bindFromRequest.get
    persons.insert(person)

    println(person)

    Ok(Json.obj(
      "id" -> person.id,
      "name" -> person.name
    ))
  }

  def javascriptRoutes = Action { implicit request =>
    import routes.javascript._
    Ok(
      Routes.javascriptRouter("jsRoutes")(
        controllers.routes.javascript.Person.create,
        controllers.routes.javascript.Person.delete,
        controllers.routes.javascript.Person.getAll
      )
    ).as("text/javascript")
  }
}