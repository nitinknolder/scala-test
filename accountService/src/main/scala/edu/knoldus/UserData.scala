package edu.knoldus

import edu.knoldus.database.Registration

trait UserData {
  def registration (): Map[Long, Registration]

  def viewAllUser (): Map[Long, Registration]
}
