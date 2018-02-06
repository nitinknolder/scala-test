package edu.knoldus

import edu.knoldus.database.MyDatabase
import org.apache.log4j.Logger

import scala.collection.immutable.ListMap
import scala.io.StdIn

class Searching (product: Map[Int, MyDatabase] = Map ()) {
  val log = Logger.getLogger (this.getClass)

  def lowToHigh (): Map[Int, MyDatabase] = {

    val increasePrice = ListMap (product.toSeq.sortWith (_._2.price < _._2.price): _*)
    for (low2high <- increasePrice)
      log.debug (low2high + "\n")
    searchMenu (product)
    product
  }

  def highToLow: Map[Int, MyDatabase] = {

    val decreasePrice = ListMap (product.toSeq.sortWith (_._2.price > _._2.price): _*)
    for (high2low <- decreasePrice)
      log.debug (high2low + "\n")
    searchMenu (product)
    product
  }

  def lowToHighRating: Map[Int, MyDatabase] = {

    val increaseRatings = ListMap (product.toSeq.sortWith (_._2.ratings < _._2.ratings): _*)
    for (low2high <- increaseRatings)
      log.debug (low2high + "\n")
    searchMenu (product)
    product
  }

  def highToLowRatings: Map[Int, MyDatabase] = {

    val decreaseRatings = ListMap (product.toSeq.sortWith (_._2.ratings > _._2.ratings): _*)
    for (high2low <- decreaseRatings)
      log.debug (high2low + "\n")
    searchMenu (product)
    product
  }

  def searchMenu (product: Map[Int, MyDatabase]): Unit = {

    log.info ("Selection the Type Of searching \n")
    log.info ("1: View All Items \n")
    log.info ("2: Search By Filtering Price \n")
    log.info ("3: Search By Filtering Ratings: \n")
    log.info ("4: View price of Item \n")
    log.info ("5: Checkout --> \n")
    log.info ("6: Main Menu \n")
    log.info ("Enter Your Choice: \n")
    val select = StdIn.readInt ()
    select match {
      case 1 => new InventoryOperation (product).viewItem ()
      case 2 => log.info ("A: Filter Price: Low To High \n")
        log.info ("B: Filter Price High To Low \n")
        log.info ("Enter your choice:")
        val filterPrice = StdIn.readLine ().toLowerCase ()

        filterPrice match {
          case "a" => lowToHigh
          case "b" => highToLow
          case _ => searchMenu (product)
        }
      case 3 => log.info ("A: Filter Ratings: Low To High \n")
        log.info ("B: Filter Ratings High To Low \n")
        log.info ("Enter your choice: \n")
        val filterRatings = StdIn.readLine ().toLowerCase ()

        filterRatings match {
          case "a" => lowToHighRating
          case "b" => highToLowRatings
          case _ => highToLowRatings
        }
      case 4 => searchItemPrice
      case 5 => new InventoryOperation ().inventoryMenu ()
    }
  }

  def searchItemPrice: Map[Int, MyDatabase] = {

    val typeOfItem = StdIn.readLine ("Enter the Type Of Item: \n")
    val searching = product.filter ((t) => t._2.itemType == typeOfItem)
    log.debug (searching)
    log.debug ("\n")
    new InventoryOperation (product ++ searching).inventoryMenu ()
    product
  }
}
