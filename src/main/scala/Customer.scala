/**
  * Created by Fraser on 12/06/2017.
  */
class Customer(name: String) extends Person(name, "Customer") {
  override def toString: String = {super.toString}
  override def isFree():Boolean = {false}
  override def setCar(car: Vehicle) = {}
}