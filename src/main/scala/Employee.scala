/**
  * Created by Fraser on 06/06/2017.
  */
class Employee(name: String, car: Vehicle) extends Person(name, "Employee") {
  var workingOn = car
  override def isFree() : Boolean = {
    workingOn match{
      case a if workingOn != null => false
      case _ => true
    }
  }

  override def setCar(car: Vehicle): Unit = { workingOn = car }
  override def toString: String = {var customerInfo = super.toString; if(isFree()) customerInfo += ", WorkingOn: Nothing"else customerInfo+=", workingOn: (" + workingOn.getModel() + ", " + workingOn.getID() + ")" ;customerInfo}
}
