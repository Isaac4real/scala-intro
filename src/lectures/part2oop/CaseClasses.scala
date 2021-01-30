package lectures.part2oop

object CaseClasses extends App{
  /*
    equals, hashCode, toString
   */

  case class Person(name: String, age: Int)

  // 1. CC parameters are fields
  val matilde = new Person("Matilde", 25)
  println(matilde.name)

  // 2. sensible toString
  // println(instance) = println(instance.toString) // syntactic sugar
  println(matilde)

  // 3. equals and hashCode implemented OOFB
  val matilde2 = new Person("Matilde", 25)
  println(matilde == matilde2)

  // 4. CC have handy copy method
  val matilde3 = matilde.copy(age=24)
  println(matilde3)

  // 5. CC have companion objects
  val thePerson = Person
  val mary = Person("mary", 23)

  // 6. CC are serializable
  // Akka

  // 7. CCs have extractor patterns = CCs can be used in PATTERN MATCHING

  case object UnitedKingdom {
    def name: String = "The UK of GB and NI"
  }

}
