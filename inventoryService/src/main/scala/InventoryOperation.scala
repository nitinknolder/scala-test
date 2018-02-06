package edu.knoldus

import edu.knoldus.database.MyDatabase
import org.apache.log4j.Logger

import scala.io.StdIn


class InventoryOperation (product: Map[Int, MyDatabase] = Map ()) {

  val log = Logger.getLogger (getClass)

  def inventoryMenu (): Unit = {

    log.debug ("Select Your Choice From Menu: \n")
    log.debug ("1: Add Item \n")
    log.debug ("2: Delete Item \n")
    log.debug ("3: View Item \n")
    log.debug ("4: Search Item \n")
    log.debug ("5: Exit \n")
    log.debug ("Enter your Choice: ")
    val select = StdIn.readInt ()

    select match {
      case 1 => addItem ()
      case 2 => deleteItem ()
      case 3 => viewItem ()
      case 4 => new Searching (product).searchMenu (product)
      case 5 => exit ()
    }
  }

  // ***********Add Items****************
  def addItem (): Map[Int, MyDatabase] = {

    log.debug ("Add Your Items \n")
    log.debug ("Enter Type Of Item")
    val iType = StdIn.readLine ()

    log.debug ("Enter Item Name: \n ")
    val iName = StdIn.readLine ()

    log.debug ("Enter Product Description: \n")
    val info = StdIn.readLine ()

    log.debug ("Enter Price: \n")
    val price = StdIn.readDouble ()

    log.debug ("Enter Vendor Info: \n")
    val vendInfo = StdIn.readLine ()
    log.info ("Enter the Product rating: \n")
    val ratings = StdIn.readFloat ()
    log.debug (s"$iName $info $price $vendInfo $ratings Added" + "\n")

    val list = product.keySet.toList
    val maximum = list.max
    val reInventoryInfo = MyDatabase (iType: String, iName: String, info: String, price: Double, vendInfo: String, ratings: Float)
    val newMap = Map (maximum + 1 -> reInventoryInfo)
    new InventoryOperation (product ++ newMap).inventoryMenu ()
    product
  }

  //****************View Items***********
  def viewItem (): Map[Int, MyDatabase] = {

    val viewData = product.toList
    for (product <- viewData)
      log.debug (product + "\n")

    new InventoryOperation (product).inventoryMenu ()
    product
  }

  //***************Delete Items**********
  def deleteItem (): Map[Int, MyDatabase] = {
    log.debug ("Enter Item to Be deleted")

    val itemToBeDeleted = StdIn.readInt ()
    val prod = product.filterKeys (_ != itemToBeDeleted)
    new InventoryOperation (prod).inventoryMenu ()
    product
  }

  //***************Exit******************
  def exit (): Unit = {
    log.debug ("<-----Thanks For Using KnolKart<---- \n")
  }
}















