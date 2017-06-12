/**
  * Created by Fraser on 06/06/2017.
  */
object Main {
  def main(args : Array[String]) : Unit ={
    val customer : Person = new Customer("John")
    val nonWorkingEmployee : Person = new Employee("Bill", null)
    var car : Vehicle = new Car("Toyota", 5, customer, "Petrol", 1873, 5)
    val workingEmployee: Person = new Employee("Angus", car)

    println(nonWorkingEmployee.toString)
    println(car.toString)
    println(workingEmployee.toString)

    //delete car
    car = null
  }
}
