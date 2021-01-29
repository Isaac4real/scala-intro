package lectures.part2oop

import java.io.Writer
import java.util.concurrent.CountDownLatch

object OOBasics extends App{

  class Person(name: String, val age: Int = 0){

    // this is also a method but its more like an additional parameter
    val x = 0

    //method, injected with param with same name as self. self is accessed using this
    def greet(name: String): Unit = println(s"${this.name} says: zup, $name")

    def greet(): Unit = println(s"${name} is cool")

  }

  val jackie = new Person("jackie", 25)
  println(jackie.x)
  println(jackie.greet("isaac"))
  println(jackie.greet())

  //exercises:
  val author = new Writer("Charles", "Dickens", 1812)
  val imposter = new Writer("Charles", "Dickens", 1812)
  val novel = new Novel("Great Expectations", 1861, author)

  println(novel.authorAge)
  println(novel.isWrittenBy(imposter))

  val counter = new Counter
  counter.inc.print
  counter.inc.inc.inc.print
  counter.inc(10).print
}

/*
  Novel and a Writer

  Writer: first name, surname, year
    - method fullname

  Novel: name, year of release, author
  - authorAge
  - isWrittenBy(author)
  - copy (new year of release) = new instance of Novel


 */

class Writer(firstName: String, surname: String, val year: Int){
  def fullName: String = firstName + " " + surname
}

class Novel(name: String, yor: Int, author: Writer){
  def authorAge: Int = yor - author.year
  def isWrittenBy(author: Writer): Boolean = this.author == author
  def copy(nyof: Int): Novel = new Novel(name, nyof, author)
}


class Counter(val count: Int = 0){
  def inc : Counter = new Counter(count + 1)
  def dec : Counter = new Counter(count - 1)

  def inc(amount: Int): Counter = {
    if (amount <= 0) this
    else inc.inc(amount-1)
  }
  def dec(amount: Int): Counter = {
    if (amount <= 0) this
    else dec.dec(amount+1)
  }

  def print : Unit = println(count)
}