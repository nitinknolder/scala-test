package edu.knoldus

import edu.knoldus.database.Registration
import org.apache.log4j.Logger

import scala.io.StdIn

class AccountServices (register: Map[Long, Registration] = Map ()) extends UserData {

  val log = Logger.getLogger (this.getClass)
  val registeredUser: List[Registration] = getRegisteredUsers

  def servicesMenu (): Unit = {
    log.info ("Main Menu: \n")
    log.info ("\n 1: Registration \n 2: Login \n 3: ViewAll Registered User \n 4: Exit \n")
    log.info ("Enter your Choice: \n")
    val choice = StdIn.readInt ()
    choice match {
      case 1 => registration
      // case 2 => authenticateUser
      case 3 => viewAllUser
      case 4 => log.info ("Thanks For Using Knolkart")
      case _ => servicesMenu ()
    }
  }

  override def registration: Map[Long, Registration] = {

    log.info ("Enter Your Details: \n")
    log.info ("Enter FirstName: \n")
    val firstName = StdIn.readLine ()
    log.info ("Enter LastName: \n")
    val lastName = StdIn.readLine ()
    log.info ("Enter Your Age: \n")
    val age = StdIn.readInt ()
    log.info ("Enter your Gender: \n")
    val gender = StdIn.readLine ()
    log.info ("Enter Your Mobile Number: \n")
    val mobNum = StdIn.readLong ()
    log.info ("Enter Your Password: \n")
    val password = StdIn.readLine ()
    log.info (s"$firstName,$lastName,$age,$gender,$mobNum Registered Successfully" + "\n")
    val registrationData = Registration (firstName, lastName, age, gender, mobNum, password)
    val newUser = scala.collection.mutable.Map (mobNum -> registrationData)
    new AccountServices (register ++ newUser).servicesMenu ()
    register
  }

  def addNewUser (user: Registration): List[Registration] = {
    if (registeredUser.contains (user)) {
      registeredUser
    }
    else {
      registeredUser :+ user
    }
  }

  def authenticateUser (phoneNumber: String, password: String): Option[Registration] = {
    val result = registeredUser.lastIndexWhere {
      (user) => (user.mobileNumber == phoneNumber) && (user.password == password)
    }
    result match {
      case -1 => None
      case _ => Some (registeredUser (result))
    }
  }

  def getRegisteredUsers: List[Registration] = {
    List[Registration](
      Registration ("Nitin", "Arora", 23, "Male", 987898, "1234"),
      Registration ("Nitish", "Mishra", 23, "Male", 9877, "4567"),
      Registration ("Dipankar", "Ranswal", 24, "Male", 3223, "88998")
    )
  }

  override def viewAllUser: Map[Long, Registration] = {
    log.info ("List Of All registered Users Are: \n")
    val viewData = register.toList
    for (product <- viewData)
      log.debug (product + "\n")
    new AccountServices (register).servicesMenu ()
    register
  }

}




