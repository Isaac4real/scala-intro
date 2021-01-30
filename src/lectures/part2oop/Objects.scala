package lectures.part2oop

object Objects extends App{

  // SCALA DOES NOT HAVE CLASS LEVEL FUNCTIONALITY ("static")
  object Person{ // type + it is its own instance (singleton)
    // "static/class" level functionality
    val N_EYES = 2
    def canFly: Boolean = true

    //factory method
    def apply(mother: Person, father: Person): Person = new Person("bob")

  }
  class Person(val name: String) // instance level functionality
  // COMPANIONS

  println(Person.N_EYES)
  println(Person.canFly)

  // Scala object = SINGLETON INSTANCE
  val mary = new Person("mary")
  val tom = new Person("tom")
  println(mary == tom)

  val person1 = Person
  val person2 = Person
  println(person1 == person2)

  val bobbie = Person(mary, tom)

  //scala applications = scala objects with
  // def main(args: Array[String]): Unit
}
