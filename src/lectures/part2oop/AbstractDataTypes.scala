package lectures.part2oop

object AbstractDataTypes extends App {
    // abstract
    abstract class Animal {
      val creatureType: String = "wild"

      def eat: Unit
    }

    class Dog extends Animal {
      override val creatureType: String = "canine"

      def eat: Unit = println("crunch")
    }

    trait Carnivore {
      def eat(animal: Animal): Unit

      val prefferedMeal: String = "meat"
    }

    trait coldBlood

    class Croc extends Animal with Carnivore with coldBlood {
      override val creatureType: String = "croc"

      def eat: Unit = println("momom")

      def eat(animal: Animal): Unit = println(s"${creatureType} eats ${animal.creatureType}")
    }

    val dog = new Dog
    val croc = new Croc
    croc.eat(dog)

    // traits vs abstract classes
    // 1 - traits do not have constructor parameters
    // 2 - multiple traits may be  inherited by the same class
    // 3 - traits = behavior, abstract class = "thing"
}
