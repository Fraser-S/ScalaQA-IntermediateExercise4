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
  final def getWorker():Person = {engineer}

  final def displayParts(): Unit ={
    def displayPartsIter(i:Int): Unit = i match {
      case a if i == partList.size => //do nothing
      case _ => println("           " + partList(i));displayPartsIter(i+1)
    }
    displayPartsIter(0)
  }

  final def repaired(): Boolean = {
    def Iter(index : Int): Boolean = index match {
      case a if index == parts.size => true //if it got here all parts fixed
      case a if !parts(index).broken =>Iter(index+1) //if part is working go to the next one
      case _ => false//part is broken return false
    }
    Iter(0)
  }

  final def getPartsCost():Double = {
    def Iter(index : Int, cost: Double): Double = index match {
      case a if index == parts.size => cost //if it got here all parts cost added
      case a if parts(index).wasBroken => Iter(index+1, cost+parts(index).getCost())
      case _ => Iter(index+1, cost)
    }
    Iter(0, 0)
  }

  final def getHoursWorked():Int = {
    def Iter(index : Int, hoursSpent: Int): Int = index match {
      case a if index == parts.size => hoursSpent
      case a if parts(index).wasBroken => Iter(index+1,hoursSpent+parts(index).timeToFix)
      case _ => Iter(index+1,hoursSpent)
    }
    Iter(0, 0)
  }

  override def toString(): String = {"Model: " + model + ", Owner: " + owner.getName() + ", Fuel: " + fuel + ", NoOfTyres, " + tyres + ", ID: " + id + ", Being Repaired: " + beingFixed }
}
