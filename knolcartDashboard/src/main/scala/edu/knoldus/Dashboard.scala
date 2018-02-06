package edu.knoldus

import org.apache.log4j.Logger

import scala.io.StdIn

class Dashboard {

  def dashBoardMenu () = {

    val log = Logger.getLogger (this.getClass)

    log.info ("KNOLKART DASHBOARD")
    log.info (" 1: Registration \n 2: Sorted Data \n")
    log.info ("Enter your choice")
    val choice = StdIn.readInt ()
    choice match {
      case 1 => new AccountServices ().registration
      case 2 => new InventoryOperation ().inventoryMenu ()
      case _ => exit ()
    }
  }

  def exit () = {
    "Thanks For Using KnolKart"
  }


}
