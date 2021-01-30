package lectures.part2oop

object Generics extends App {

  class MyList[+A] {
    // use type A
    // the + means that it allows "children" of A ??
    // using - would mean that it only allows parents of A or A itself (dont allows children of A)??
    def add[B >: A](element: B) = ???
    /*
      A = Cat
      B = Animal
    */
  }
  class MyMap[Key, Value]

  val listOfIntegers = new MyList[Int]
  val listOfStrings = new MyList[String]

  // generic methods
  object MyList {
    def empty[A]: MyList[A] = ???
  }
  val emptyListOfIntegers = MyList.empty[Int]

  // variance problem
  class Animal
  class Cat extends Animal
  class Dog extends Animal

  // 1. Yes, List[Cat] extends List[Animal] = COVARIANCE
  class covariantList[+A]
  val animal: Animal = new Cat
  val listOfAnimals: covariantList[Animal] = new covariantList[Cat]

  // 2. No = Invariance
  class InvariantList[A]
  val invariantAnimalList: InvariantList[Animal] = new InvariantList[Animal]

  // 3. Hell, no! Contravariance
  class Trainer[-A]
  val trainer: Trainer[Cat] = new Trainer[Animal]

  // bounded types
  class Cage[A <: Animal](animal: A)
  val cage = new Cage(new Cat)
  //val cage: Cage[Cat] = new Cage[Cat](new Cat)

}
