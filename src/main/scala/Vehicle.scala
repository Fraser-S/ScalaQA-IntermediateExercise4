/**
  * Created by Fraser on 06/06/2017.
  */

abstract class Vehicle(model : String,  tyres: Int, owner: Person, fuel: String, id: Int) {
  //variables
  private var beingFixed: Boolean = false//assign false at the start

  //functions
  final def getModel(): String = { model }
  final def getOwner(): Person = { owner }
  final def getID(): Int = { id }
  final def startRepair() =  {beingFixed = true}
  final def beingRepaired(): Boolean = {beingFixed}
  override def toString: String = {"Model: " + model + ", Owner: " + owner.getName() + ", Fuel: " + fuel + ", NoOfTyres, " + tyres + ", ID: " + id + ", Being Repaired: " + beingFixed}
}
