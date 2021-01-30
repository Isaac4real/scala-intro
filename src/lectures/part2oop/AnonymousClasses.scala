package lectures.part2oop

object AnonymousClasses extends App{
  abstract class Animal {
    def eat: Unit = println("zyp")
  }

  val funnyAnimal: Animal = new Animal {
    override def eat: Unit = println("zup")
  }
  /*
    equivalent with

    class AnonymousClasses$$anon$1 extends Animal {
      override def eat: Unit = println("ahahahahahaah")
    }
    val funnyAnimal: Animal = new AnonymousClasses$$anon$1
   */
  println(funnyAnimal.getClass)

  class Person(name: String) {
    def hi: Unit = println(s"${name} says hi")
  }
  val tom = new Person("tom"){
    override def hi: Unit = println("hi")
  }

}
