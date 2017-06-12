/**
  * Created by fraser on 06/06/2017.
  */
class Person(name: String, role : String) {
  def getName() : String = {name}
  override def toString: String = {"Name: " + name + ", role: " + role}
}