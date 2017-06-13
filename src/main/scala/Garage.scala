import sun.text.UCompactIntArray

import scala.collection.mutable.ListBuffer

/**
  * Created by Administrator on 12/06/2017.
  *
  * Design a Garage class, this class will have all the functionality that a garage should offer.
  */

class Garage {
  //variables
  private var vehicleList: ListBuffer[Vehicle] = ListBuffer()
  private var employeeList: ListBuffer[Person] = ListBuffer()
  private var open: Boolean = false
  private var labourCostPerHour: Double = 10
  private var VAT: Double = 1.20
  private var hoursPerDay = 10
  private var assigmentAvailable = false
  //functions

  //only add the vehicle if it is open
  def addVehicle(vehicle: Vehicle):Unit = vehicle match {
    case a if vehicle != null && open && vehicle.getOwner()!=null => vehicleList += vehicle; assigmentAvailable = true
    case _ => println("Vehicle not added")
  }

  def registerEmployee(employee: Employee):Unit = employee match {
    case a if employee != null => employeeList += employee; assigmentAvailable = true
    case _ => println("Employee not added")
  }

  def removeVehicle(carID : Int):Unit = {
    def Iter(i : Int, carID : Int) : Unit = i match{
      case a if i == vehicleList.size => println("Car with ID of '" + carID + "' cannot be found")
      case b if vehicleList(i).getID() == carID => vehicleList(i) = null ; vehicleList.remove(i);println("Car Removed")
      case _ => Iter(i+1, carID)
    }
    if(vehicleList.nonEmpty) Iter(0, carID) else println("Cannot remove vehicle, no vehicles in the garage")
  }

  def removeVehicle(model: String):Unit = {
    def Iter(i : Int, model : String) : Unit = i match{
      case a if i == vehicleList.size => println("No Cars from '" + model + "' are currently in the garage")
      case b if vehicleList(i).getModel() == model => vehicleList(i) = null ; vehicleList.remove(i);println("Car Removed")
      case _ => Iter(i+1, model)
    }
    if(vehicleList.nonEmpty) Iter(0, model) else println("Cannot remove vehicle, no vehicles in the garage")
  }

  //opens the garage
  def openGarage():Unit = {
    open = true
  }

  //closes the garage
  def closeGarage():Unit = {
    open = false
  }

  def isOpen():Boolean = {open}

  def calculateBill(vehicle: Vehicle): Unit = {
    /* cost should be the labour cost + part cost + vat
    println("Labour Cost: " + labourCostPerHour*hoursWorked)
    println("Part Cost: " + partCost)
    var totalCost = (labourCostPerHour*hoursWorked) + partCosts
    println("Before Tax: " + totalCost)
    taxValue = (totalCost*Tax) - totalCost
    println("Tax: " + taxValue)
    totalCost +=taxValue
    println("After Tax: " + totalCost")
    totalCost*/
  }

  def fixVehicles():Unit = {
    for (i <- employeeList.indices) {
      //find the car that the engineer is working on
      var vehicle = vehicleList.indexOf(employeeList(i).getCar())
      println(vehicle)
    }

    def displayVehicles(): Unit = {
      def displayIter(i: Int): Unit = i match {
        case a if i != vehicleList.size => println("  " + (i + 1) + ") " + vehicleList(i).toString); vehicleList(i).displayParts(); displayIter(i + 1)
        case _ => //do nothing
      }

      println("Current vehicles: ")
      if (vehicleList.nonEmpty) displayIter(0) else println("  No vehicles")
    }
  }

  def displayEmployees(): Unit = {
    def displayIter(i : Int) : Unit = i match{
      case a if i != employeeList.size => println("  " + (i+1) + ") " + employeeList(i).toString); displayIter(i+1)
      case _ => //do nothing
    }
    println("Current Employees: ")
    if(employeeList.nonEmpty) displayIter(0) else println("  No Employees")
  }

  override def toString : String = {
    "Open: " + open + ", Employees: " + employeeList + ", Vehicles: " + vehicleList
  }

  //the assignment will only run if there is a possibility of work being start, this will ensure that this function will only run when needed
  def assignEmployeesToCars(): Unit ={
    //loop through employees to see if any are free then loop through the cars to see if any cars are available
    if(vehicleList.nonEmpty && employeeList.nonEmpty && assigmentAvailable){
      //loop through the employee list
      var i,j :Int = 0
      do{
        do{
          j match{
            case a if j == vehicleList.size || employeeList.size == i => assigmentAvailable = false
            case a if !vehicleList(j).beingRepaired() => vehicleList(j).startRepair(); employeeList(i).setCar(vehicleList(j))
            case _ => //do nothing
          }
          j+=1
        }while(assigmentAvailable && employeeList(i).isFree())
        j=0//reset size
        i+=1
      }while(assigmentAvailable)
    } else {
      assigmentAvailable = false
    }
  }
}