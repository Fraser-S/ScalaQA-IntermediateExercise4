import scala.collection.mutable.ListBuffer

/**
  * Created by Fraser on 06/06/2017.
  */
class Bike(model : String,  tyres: Int, owner: Person, fuel: String, id: Int, parts: ListBuffer[Part]) extends Vehicle(model,  tyres, owner, fuel, id, parts) {
  override def toString: String = {super.toString }
}


