package ZadaniaNBD_1

import scala.annotation.tailrec

object NBD_zad1 {

  val dni = List[String]("Poniedzialek", "Wtorek", "Sroda", "Czwartek", "Piatek", "Sobota", "Niedziela")
  val produkty = Map("Ksiazka" -> 10.00, "Torba" -> 13.39, "Kwiat" -> 4.99, "Obraz" -> 99.90, "TV" -> 1234.56)
  val stolice = Map("Polska" -> "Warszawa", "Japonia" -> "Tokio", "Niemcy" -> "Berlin")
  val calkowite = List[Int](3, 0, 1, 21, 0, 1, 0, 8, 16, -7, 19, 0, 4, 0, -2, -4, 0, -1)

  def zadanie1a(): String = {
    var listadni = ""
    for (dzien <- dni) {
      if (dzien == dni.last)
        listadni += dzien
      else
        listadni += dzien + ", "
    }
    return listadni
  }

  def zadanie1b(): String = {
    var listadninap = ""
    for (dzien <- dni if dzien.startsWith("P")) {
      listadninap += dzien + ", "
    }
    return listadninap.substring(0, listadninap.length - 2)
  }

  def zadanie1c(): String = {
    var listadnizwhile = ""
    var i = 0
    while (i < dni.length) {
      listadnizwhile += dni(i) + ", "
      i += 1
    }
    return listadnizwhile.substring(0, listadnizwhile.length - 2)
  }

  def zadanie2a(dni: List[String]): String = {
    if (dni.tail.isEmpty)
      return dni.head
    return dni.head + ", " + zadanie2a(dni.tail)
  }

  def zadanie2b(dni: List[String]): String = {
    if (dni.tail.isEmpty)
      return dni.head
    return zadanie2b(dni.tail) + ", " + dni.head
  }

  @tailrec
  def zadanie3(dni: List[String], resztadni: String): String = {
    if (dni.tail.isEmpty)
      return resztadni + dni.head
    else zadanie3(dni.tail, resztadni + dni.head + ", ")
  }

  def zadanie4a(dni: List[String]): String = {
    dni.foldLeft("")(_ + _ + ", ").dropRight(2)
  }

  def zadanie4b(dni: List[String]): String = {
    dni.foldRight("")(_ + ", " + _).dropRight(2)
  }

  def zadanie4c(dni: List[String]): String = {
    dni.foldLeft("") { (reszta, dzien) => {
      if (dzien.startsWith("P")) reszta + dzien + ", " else reszta
    }
    }.dropRight(2)
  }

  def zadanie5(): Map[String, Double] = {
    produkty.map(produkt => (produkt._1, (produkt._2) * 0.9))
  }

  def zadanie6(tuple: (Int, Double, String)) = {
    println("tuple(1): " + tuple._1)
    println("tuple(2): " + tuple._2)
    println("tuple(3): " + tuple._3)
    println("tuple: " + tuple)
  }

  def zadanie7(option: Option[String]) = option match {
    case Some(x) => x
    case None => "Brak danych"
  }

  def zadanie7b[klucz, wartosc](map: Map[klucz, wartosc], key: klucz) = {
    map.getOrElse(key, "Default")
  }

  @tailrec
  def zadanie8(liczby: List[Int], reszta: List[Int] = List.empty[Int]): List[Int] = {
    liczby match {
      case Nil => reszta
      case 0 :: tail  => zadanie8(tail, reszta)
      case head :: tail => zadanie8(tail, reszta :+ head)
    }
  }

  def zadanie9(liczby: List[Int]): List[Int] = {
    liczby.map(_+1)
  }

  def zadanie10(liczby: List[Int]): List[Int] = {
    liczby.filter(liczba => liczba >= -5 && liczba <= 12).map(_.abs)
  }


  def main(args: Array[String]): Unit = {

    println("\n=========== 1a ===========\n")
    println(zadanie1a())
    println("\n=========== 1b ===========\n")
    println(zadanie1b())
    println("\n=========== 1c ===========\n")
    println(zadanie1c())
    println("\n=========== 2a ===========\n")
    println(zadanie2a(dni))
    println("\n=========== 2b ===========\n")
    println(zadanie2b(dni))
    println("\n=========== 3 ===========\n")
    println(zadanie3(dni, ""))
    println("\n=========== 4a ===========\n")
    println(zadanie4a(dni))
    println("\n=========== 4b ===========\n")
    println(zadanie4b(dni))
    println("\n=========== 4c ===========\n")
    println(zadanie4c(dni))
    println("\n=========== 5 ===========\n")
    println(zadanie5())
    println("\n=========== 6 ===========\n")
    zadanie6(5, 3.14, "krotka")
    println("\n=========== 7 ===========\n")
    println(zadanie7(stolice.get("Japonia")))
    println(zadanie7(stolice.get("Anglia")))
    println(zadanie7b(stolice, "Anglia"))
    println(zadanie7b(stolice, "Polska"))
    println("\n=========== 8 ===========\n")
    println("Original: " + calkowite)
    println("Bez zer: " + zadanie8(calkowite))
    println("\n=========== 9 ===========\n")
    println("Original: " + calkowite)
    println("Increment: " + zadanie9(calkowite))
    println("\n=========== 10 ===========\n")
    println("Original: " + calkowite)
    println("Filtered: " + zadanie10(calkowite))

  }
}
