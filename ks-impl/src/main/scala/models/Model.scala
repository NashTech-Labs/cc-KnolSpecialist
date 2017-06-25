package models

object Model {
  case class Technology(id: Int, Name: String)
  case class Knolder(id: Int, Name: String, Designation: String)
  case class Expert(TechId: Int, KnolId: Int, Skill: Int)
}
