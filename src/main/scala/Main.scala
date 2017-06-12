import scala.collection.mutable.ListBuffer
import scala.util.Random

/**
  * Created by Fraser on 06/06/2017.
  */
object Main {

  def hireEmployees(garage: Garage) = {
    garage.registerEmployee(new Employee("John Smith", null))
    garage.registerEmployee(new Employee("Mike Kurt", null))
    garage.registerEmployee(new Employee("Bill Doe", null))
  }

  //returns a customer
  def customerList(num: Int) : Person = num match {
    case 0 => new Customer("Michael")
    case 1 => new Customer("Jennifer")
    case 2 => new Customer("Angus")
    case 3 => new Customer("William")
    case 4 => new Customer("David")
    case 5 => new Customer("Molly")
    case 6 => new Customer("Richard")
    case 7 => new Customer("Arther")
    case 8 => new Customer("Richard")
    case 9 => new Customer("Alice")
    case _ => new Customer("Sue")
  }

  def partGenerationIter10Times(i: Int, parts : ListBuffer[Part], rnd :Random): ListBuffer[Part] = i match {
      //each car will include the following parts, each part has name, price, working, and time to fix
    case 0 => parts+=new Part("Engine", 750.99, rnd.nextBoolean(), 12); partGenerationIter10Times(i+1,parts,rnd)
    case 1 => parts+=new Part("Tyres", 250.99, rnd.nextBoolean(), 1); partGenerationIter10Times(i+1,parts,rnd)
    case 2 => parts+=new Part("Brakes", 180.99, rnd.nextBoolean(), 4); partGenerationIter10Times(i+1,parts,rnd)
    case 3 => parts+=new Part("Battery", 81.99, rnd.nextBoolean(), 2); partGenerationIter10Times(i+1,parts,rnd)
    case 4 => parts+=new Part("GearBox", 218.99, rnd.nextBoolean(), 7); partGenerationIter10Times(i+1,parts,rnd)
    case 5 => parts+=new Part("Electrics", 195.99, rnd.nextBoolean(), 5); partGenerationIter10Times(i+1,parts,rnd)
    case 6 => parts+=new Part("Lights", 45.99, rnd.nextBoolean(), 1); partGenerationIter10Times(i+1,parts,rnd)
    case 7 => parts+=new Part("Handbrake", 75.50, rnd.nextBoolean(), 2); partGenerationIter10Times(i+1,parts,rnd)
    case 8 => parts+=new Part("Radio", 101.99, rnd.nextBoolean(), 3); partGenerationIter10Times(i+1,parts,rnd)
    case 9 => parts+=new Part("Suspension", 367.99, rnd.nextBoolean(), 8); partGenerationIter10Times(i+1,parts,rnd)
    case _ => parts
  }

  def generateVehicle(i : Int, rnd : Random): Vehicle = {
    //start by generating parts
    var parts : ListBuffer[Part] = partGenerationIter10Times(0, new ListBuffer[Part], rnd)
    var car : Vehicle = null
    i match {
      case 0 => car =  new Car("Mercedes", 5, customerList(i), "Diesel", i, 3, parts)
      case 1 => car =  new Car("BMW", 5, customerList(i), "Petrol", i, 5, parts)
      case 2 => car =  new Car("Toyota", 5, customerList(i), "Electric", i, 5, parts)
      case 3 => car =  new Car("Renault", 5, customerList(i), "Petrol", i, 5, parts)
      case 4 => car =  new Car("Lotus", 5, customerList(i), "Petrol", i, 5, parts)
      case 5 => car =  new Car("Volkswagen", 5, customerList(i), "Diesel", i, 5, parts)
      case 6 => car =  new Car("Peugeot", 5, customerList(i), "Diesel", i, 5, parts)
      case 7 => car =  new Bike("Ducati", 2, customerList(i), "Petrol", i, parts)
      case 8 => car =  new Bike("Honda", 2, customerList(i), "Petrol", i, parts)
      case _ => car =  new Bike("Harley Davidson", 2, customerList(i), "Petrol", i, parts)
    }

    car
  }

  def addVehicles(garage: Garage) : Unit ={
    val rnd : Random = new Random()
    for(i<-0 to 9){
      garage.addVehicle(generateVehicle(i, rnd))
    }
  }

  def main(args : Array[String]) : Unit ={
    //create the garage
    val garage : Garage = new Garage()
    hireEmployees(garage)
    garage.displayEmployees()
    //open the garage
    garage.openGarage()
    //add cars to the garage
    addVehicles(garage)
    //display the vehicles
    garage.displayVehicles()

  }
}
