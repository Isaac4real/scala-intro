package lectures.part4.pm

import scala.annotation.tailrec
import scala.util.Random

object PatterMatching extends App{
  // switch on steroids
  val random = new Random()
  val x = random.nextInt(10)

  val description = x match {
    case 1 => " the ONE"
    case 2 => "double or nothing"
    case 3 => "third time is the charm"
    case _ => "something else"
  }

  // 1. decompose values
  case class Person(name: String, age: Int)
  val bob = Person("bob", 20)

  val greeting = bob match {
    case Person(name, age) if age < 21 =>  s"Hi, mi name is $name and i can't drink in the US"
    case Person(name, age) => s"Hi my name is $name and I am $age years old"
    case _ => "dont know who I am"
  }
  println(greeting)

  /*
  1. cases are matched in order
  2. what if no cases match? MatchError
  3. type of the PM expressoion? unified type of all the types in all the cases
  4. PM works really well with case classes*

 */

  // PM on sealed hierarchies
  sealed class Animal
  case class Dog(breed: String) extends Animal
  case class Parrot(greeting: String) extends Animal

  val animal: Animal = Dog("Terra Nove")
  animal match {
    case Dog(breed) => println(s"Dog of the ${breed} breed")
  }

  // match everything
  val isEven = x match {
    case n % 2 == 0 => true
    case _ => false
  }
  // why ??
  val isEvenCond = if (x%2 == 0) true else false
  val isEvenNormal = x % 2 == 0

  /*
      Exercise
      simple function uses PM
       takes an Expr => human readable form

       Sum(Number(2), Number(3)) => 2 + 3
       Sum(Number(2), Number(3), Number(4)) => 2 + 3 + 4
       Prod(Sum(Number(2), Number(1)), Number(3)) = (2 + 1) * 3
       Sum(Prod(Number(2), Number(1)), Number(3)) = 2 * 1 + 3
     */

  trait Expr
  case class Number(n: Int) extends Expr
  case class Sum(e1: Expr, e2: Expr) extends Expr
  case class Prod(e1: Expr, e2: Expr) extends Expr

  def show(e: Expr): String = e match {
    case Number(n) => s"$n"
    case Sum(e1, e2) => show(e1) + "+" + show(e2)
    case Prod(e1, e2) => {
      def maybeParentheses(e: Expr): String = e match {
        case Prod(_, _) => show(e)
        case Number(_) => show(e)
        case _ => "(" + show(e) + ")"
      }
      maybeParentheses(e1)  + "*" + maybeParentheses(e2)
    }
  }

}
