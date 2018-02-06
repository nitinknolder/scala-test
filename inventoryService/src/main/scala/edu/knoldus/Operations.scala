package edu.knoldus

import edu.knoldus.database.MyDatabase
import org.apache.log4j.Logger

object Operations extends App {
  val log = Logger.getLogger (this.getClass)
  val iType = "Shoes"
  val iName = "Sports Shoes"
  val info = "Branded"
  val price = 1000
  val vendInfo = "Adidas"
  val ratings = 3

  val objShoes = MyDatabase (iType, iName, info, price, vendInfo,ratings)
  val objClothes = MyDatabase ("Clothes", "Shirt", "Cotton 100%", 2999, "Levis", 6)
  val objTv = MyDatabase ("Television", "LedTv", "40 inch", 35000, "Sony", 4)
  val objMobiles = MyDatabase ("Mobiles", "SmartPhone", "5 inch", 12000, "Asus", 2)
  val objSports = MyDatabase("Cricket", "Bat","nice Stroke",3900,"Reebok",4)
  val objCloth  = MyDatabase("Clothes", "Trouser","pure Fabric",2223,"Levis",9)
  val map = Map (1 -> objShoes, 2 -> objClothes, 3 -> objTv, 4 -> objMobiles)
  val inventObj = new InventoryOperation (map)
  inventObj.inventoryMenu ()
  }