import scala.collection.mutable.ListBuffer

/**
  * Created by Fraser on 06/06/2017.
  */

abstract class Vehicle(model : String,  tyres: Int, owner: Person, fuel: String, id: Int, parts: ListBuffer[Part]) {
  //variables
  private var beingFixed: Boolean = false//assign false at the start
  private var partList: ListBuffer[Part] = parts
  private var engineer: Person = null
  //functions
  final def getModel(): String = { model }
  final def getOwner(): Person = { owner }
  final def getID(): Int = { id }
  final def startRepair() =  {beingFixed = true}
  final def beingRepaired(): Boolean = {beingFixed}
  final def getParts():ListBuffer[Part] = {partList}
  final def setWorker(worker:Person) = {engineer = worker}

  final def displayParts(): Unit ={
    def displayPartsIter(i:Int): Unit = i match {
      case a if i == partList.size => //do nothing
      case _ => println("           " + partList(i));displayPartsIter(i+1)
    }
    displayPartsIter(0)
  }
  override def toString(): String = {"Model: " + model + ", Owner: " + owner.getName() + ", Fuel: " + fuel + ", NoOfTyres, " + tyres + ", ID: " + id + ", Being Repaired: " + beingFixed }
}
