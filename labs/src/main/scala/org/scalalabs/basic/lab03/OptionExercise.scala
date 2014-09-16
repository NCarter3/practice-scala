package org.scalalabs.basic.lab03
import scala.util.control._
import sys._

package object lab03 {

  /**
   * This map contains sample test data to clarify this exercise.
   * It contains key value pairs where:
   * - the key is a room number
   * - the value can be:
   * -- the amount of people in the room (filled: Some("10"), empty: None)
   * -- the room is not available (Some("locked"))
   */
  val sampleRooms = Map(1 -> Some("12"), 2 -> None, 3 -> Some("locked"), 4 -> Some("14"), 5 -> Some("8"), 6 -> Some("locked"))
}

object OptionExercise01 {
  
  def processRoom(room: Option[Option[String]]): String = {
     room match {
       case r if r.isEmpty => "not existing"
       case r if r.get.isEmpty => "empty"
       case r if r.get.get == "locked" => "not available"
       case _ => room.get.get
     }
  }

  /**
   * Implement the room state method that should return the state of a room as a String as follows:
   * - filled: return total people:     E.g: Some("12") is "12"
   * - locked: return "not available"   E.g. Some("locked") is "not available"
   * - empty:  return "empty"	        E.g. None is "empty"
   * - does not exist: 					"not existing"
   */
  def roomState(rooms: Map[Int, Option[String]], room: Int): String = {
     val r = rooms.get(room)
     processRoom(r)
  }

}

object OptionExercise02 {
  def processRoom(room: Option[String]): String = {
     room match {
       case r if r.isEmpty => "empty"
       case r if r.get == "locked" => "not available"
       case _ => room.get
     }
  }
  
  /**
   * Calculate the total amount of people in all rooms
   * Hint: define a helper function that computes a room's occupancy
   * to convert a possible numeric String (e.g. Some("12")) to an integer
   */
  def totalPeopleInRooms(rooms: Map[Int, Option[String]]): Int = {
    val numbs = {
      rooms.iterator map (
          (x: (Int, Option[String])) => processRoom(x._2) match {
	        case str if str == "not existing" | str == "empty" | str == "not available" => 0
	        case str => str.toInt
	      }
       );
    }
    numbs sum
  }
}
