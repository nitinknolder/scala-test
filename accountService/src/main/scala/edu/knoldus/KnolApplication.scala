package edu.knoldus

import edu.knoldus.database.Registration


object KnolApplication extends App {

  val firstName = "Nitin"
  val lastName = "Arora"
  val age = 23
  val gender = "Male"
  val phoneNum = 9877665
  val password = "1234"

  val user = Registration (firstName, lastName, age, gender, phoneNum, password)
  val map = Map (user.mobileNumber -> user)
  val obj = new AccountServices (map)
  obj.servicesMenu ()


}
