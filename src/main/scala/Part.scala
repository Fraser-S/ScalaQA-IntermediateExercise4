/**
  * Created by Administrator on 12/06/2017.
  */
class Part(partName: String, partCost: Double, partBroken: Boolean, repairTime: Int ) {
  var name: String = partName
  var cost: Double = partCost
  var broken: Boolean = partBroken
  var wasBroken: Boolean = partBroken//used for billing
  var timeToFix: Int = repairTime
  var timeSpentFixing: Int = 0

  def isBroken(): Boolean = {partBroken}

  def getCost(): Double = {partCost}

  def timeSpentFixing(hoursSpent: Int): Unit = {
    timeSpentFixing+=hoursSpent
    timeSpentFixing match{
      case a if timeSpentFixing >= timeToFix => broken = false//part fixed
      case _ => //do nothing
    }
  }

  override def toString : String = {"Name: "+name+", Cost: "+cost+", isBroken: "+broken+", wasBroken: "+wasBroken+", TimeToFix: "+timeToFix+", TimeSpentFixing: "+timeSpentFixing}
}
