/**
  * Created by Fraser on 06/06/2017.
  */
class Bike(model : String,  tyres: Int, owner: Person, fuel: String, id: Int, engineSize: String) extends Vehicle(model,  tyres, owner, fuel, id) {
  override def toString: String = {var info:String = super.toString; info+=", EngineSize: " + engineSize; info }
}


