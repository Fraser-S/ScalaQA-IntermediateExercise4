/**
  * Created by Fraser on 06/06/2017.
  */
object Main {
  def main(args : Array[String]) : Unit ={
    var customer : Person = new Person("John", "customer")
    var car : Vehicle = new Car("Toyota", 5, customer, "Petrol", 5, 1873)

    println(car.toString)

    //delete car
    car = null
  }
}
