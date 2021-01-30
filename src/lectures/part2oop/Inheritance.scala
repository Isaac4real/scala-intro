package lectures.part2oop

object Inheritance extends App {

  //single class inheritance
  sealed class Animal{
    val creatureType: String = "wild"
    def eat: Unit = print("mhmh")
  }

  class Cat extends Animal {
    def crunch: Unit = {
      eat
      println("crunch crunch")
    }
  }
  val cat = new Cat
  cat.crunch

  // constructors
  class Person(name: String, age: Int){
    def this(name: String) = this(name, 0)
  }
  class Adult(name: String, age: Int, id: String) extends Person(name)

  // overrriding
  class Dog(override val creatureType: String) extends Animal{
    override def eat: Unit = {
      super.eat
      println("zup zup")
    }
  }

  val dog = new Dog("k9")
  dog.eat
  println(dog.creatureType)

  // type substitution (broad: polimorphism)
  val unknownAnimal: Animal = new Dog("k9")
  unknownAnimal.eat

  // overRIDING vs overLOADING

  // super

  // preventing overrides
  // 1 - use final on member
  // 2 - use final on the entire class
  // 3 - seal the class = extend classes in THIS FILE, prevent extension in other files
}
