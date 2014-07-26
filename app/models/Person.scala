package models

import play.api.db.slick.Config.driver.simple._

case class PersonModel(id: Long, name: String)

class PersonTable(tag: Tag) extends Table[PersonModel](tag, "PERSON") {
  def id = column[Long]("id", O.PrimaryKey)
  def name = column[String]("name", O.NotNull)

  def * = (id, name) <> (PersonModel.tupled, PersonModel.unapply _)
}
