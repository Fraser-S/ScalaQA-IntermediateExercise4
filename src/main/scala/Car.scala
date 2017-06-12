/**
  * Created by Fraser on 06/06/2017.
  */
class Car(model : String,  tyres: Int, owner: Person, fuel: String, id: Int, doors : Int) extends Vehicle(model,  tyres, owner, fuel, id) {
  override def toString: String = {var vehicleInfo:String = super.toString; vehicleInfo+=", noOfDoors: " + doors; vehicleInfo }
}