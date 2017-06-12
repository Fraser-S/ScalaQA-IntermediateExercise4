/**
  * Created by Fraser on 06/06/2017.
  */

abstract class Vehicle(model : String,  tyres: Int, owner: Person, fuel: String, id: Int) {
  def getModel():String = {model}
  override def toString: String = {"Model: " + model + ", Owner: " + owner.getName() + ", Fuel: " + fuel + ", NoOfTyres, " + tyres + ", ID: " + id}
}
