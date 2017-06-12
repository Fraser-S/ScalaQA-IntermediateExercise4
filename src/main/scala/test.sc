class Person(var name: String) {

  override def toString() = {""}
}

val person = new Person("Blas")
person.name = "ted"
println(person.name)
