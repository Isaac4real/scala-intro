package lectures.part2oop

object MethodNotations extends App {

  class Person(val name: String, favortieMovie: String, val age: Int = 0){
    def likes(movie: String): Boolean = movie == favortieMovie
    def +(person: Person): String = s"${this.name} likes ${person.name}"
    def +(nickname: String): Person = new Person(s"${name} ${nickname}", favortieMovie, age)
    def unary_! : String = s"${name}, wtf"
    def unary_+ : Person = new Person(name, favortieMovie, age + 1)
    def isAlive: Boolean = true
    def apply(): String = s"${name} is cool"
    def apply(n: Int): String = s"${name} is ${n}x cool"
    def learn(what: String): String = s"${name} learns ${what}"
    def learnScala: String = this learn "Scala"
  }

  val mary = new Person("mary", "interstellar", 25)
  println(mary.likes("interstellar"))
  println(mary likes "interstellar") //  equivalent!!

  // "operators" in scala
  val tom = new Person("tom", "inception", 25)
  println(mary.+(tom))
  println(mary + tom) //equivalent

  println(1 + 2)
  println(1.+(2)) //eq!!

  // all operators are methods!!


  // prefix notation
  val x = +1
  val y = 1.unary_+ // eq!!

  println(!mary)
  println(mary.unary_!) //eq!!

  // postfix notation
  println(mary.isAlive)
  println(mary isAlive) //eq!!!

  // apply
  println(mary())
  println(mary.apply()) //eq!!

  //////
  println((mary + "The Boss").apply())
  println(+mary age)
  println(mary learnScala)
  println(mary(10))
}
