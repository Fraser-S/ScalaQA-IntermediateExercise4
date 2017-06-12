/**
  * Created by Fraser on 06/06/2017.
  */
object Main {
  def main(args : Array[String]) : Unit ={
    //create the garage
    val garage : Garage = new Garage()

    garage.displayEmployees()
    garage.displayVehicles()

    //give the garage a couple of employees
    garage.registerEmployee(new Employee("John", null))
    garage.registerEmployee(new Employee("Mike", null))

    //display garage information
    garage.displayEmployees()
    garage.displayVehicles()
    println(garage.toString)

    //try to add a vehicle to the garage while its closed
    garage.addvehicle(new Car("Mercedes", 5, null, "Diesel", 134, 5))
    //open the garage and try again
    garage.openGarage()
    garage.addvehicle(new Car("Mercedes", 5, null, "Diesel", 134, 5))
    var customer : Person = new Customer("Jill")
    garage.addvehicle(new Car("Mercedes", 5, customer, "Diesel", 134, 5))

    //display details again
    garage.displayEmployees()
    garage.displayVehicles()
    println(garage.toString)

    garage.assignEmployeesToCars()

    garage.displayVehicles()
    println(garage.toString)
  }
}
