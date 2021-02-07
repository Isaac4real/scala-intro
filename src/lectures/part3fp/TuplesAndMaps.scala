package lectures.part3fp

import scala.annotation.tailrec

object TuplesAndMaps extends App{

  // tuples = finite ordered lists
  var aTuple = (2, "hello, scala") // Tuple2[Int, String] = (Int, String)

  println(aTuple._1) //2
  println(aTuple.copy(_2 = "bye java"))
  println(aTuple.swap) // ("hello", "scala", 2)

  // Maps - Keys -> Values
  val aMap: Map[Int, String] = Map()

  val phonebook = Map(("Jim", 555), "Daniel" -> 789, ("JIM", 9000)).withDefaultValue(-1)
  // a -> is sugar for (a, b)
  println(phonebook)

  // map ops
  println(phonebook.contains("jim"))
  println(phonebook("Mary"))

  // add a pairing
  val newPairing = "Mary" -> 678
  val newPhoneBook = phonebook + newPairing

  // functionals on maps
  // map, flatmap and filter
  println(phonebook.map(pair => pair._1.toLowerCase() -> pair._2))

  // filterKeys
  println(phonebook.filterKeys(x => x.startsWith("J")))
  // mapValues
  println(phonebook.mapValues(number => "0245-" + number))

  // conversions to other collections
  println(phonebook.toList)
  println(List(("Daniel", 555)).toMap)
  val names = List("Bob", "James", "Angela", "Mary", "Daniel", "Jim")
  println(names.groupBy(name => name.charAt(0)))

  /*
    1.  What would happen if I had two original entries "Jim" -> 555 and "JIM" -> 900

        !!! careful with mapping keys.

    2.  Overly simplified social network based on maps
        Person = String
        - add a person to the network
        - remove
        - friend (mutual)
        - unfriend

        - number of friends of a person
        - person with most friends
        - how many people have NO friends
        - if there is a social connection between two people (direct or not)
   */

  // 2.
  def add(network: Map[String, Set[String]], person: String): Map[String, Set[String]] = {
    network + (person -> Set())
  }

  def remove(network: Map[String, Set[String]], person: String): Map[String, Set[String]] = {
    @tailrec
    def removeAux(friends: Set[String], networkAcc: Map[String, Set[String]]): Map[String, Set[String]] = {
      if (networkAcc(person).isEmpty) networkAcc
      else removeAux(friends.tail, unfriend(networkAcc, person, friends.head))
    }
    val unfriended = removeAux(network(person), network)
    unfriended - person
  }

  def unfriend(network: Map[String, Set[String]], p1: String, p2: String): Map[String, Set[String]] = {
    val unfriend_p2 = network(p1) - p2
    val unfriend_p1 = network(p2) - p1
    network + (p1 -> unfriend_p2) + (p2 -> unfriend_p1)
  }

  def friend(network: Map[String, Set[String]], p1: String, p2: String): Map[String, Set[String]] = {
    val add_friend_p2 = network(p1) + p2
    val add_friend_p1 = network(p2) + p1
    network + (p1 -> add_friend_p2) + (p2 -> add_friend_p1)
  }

  def numberFriends(person: String, network: Map[String, Set[String]]): Int = {
    if (!network.contains(person)) 0
    else network(person).size
  }

  def mostPopular(network: Map[String, Set[String]]): String = {
    network.maxBy(pair => pair._2.size)._1
  }

  def nPeopleNoFriends(network: Map[String, Set[String]]): Int = {
    network.count(_._2.isEmpty)
  }

  def socialConnection(network: Map[String, Set[String]], a: String, b: String): Boolean = {
    @tailrec
    def bfs(target: String, consideredPeople: Set[String], discoveredPeople: Set[String]): Boolean = {
      if (discoveredPeople.isEmpty) false
      else {
        val person = discoveredPeople.head
        if (person == target) true
        else if (consideredPeople.contains(person)) bfs(target, consideredPeople, discoveredPeople.tail)
        else bfs(target, consideredPeople + person, discoveredPeople.tail ++ network(person))
      }
    }


}
