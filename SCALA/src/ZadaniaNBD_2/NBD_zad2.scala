package ZadaniaNBD_2

object NBD_zad2 {

  val dni = List[String]("Poniedzialek", "Wtorek", "Sroda", "Czwartek", "Piatek", "Sobota", "Niedziela")

  def zadanie1(dzien: String): String = dzien match {
    case "Poniedzialek" | "Wtorek" | "Sroda" | "Czwartek" | "Piatek" => "Praca"
    case "Sobota" | "Niedziela" => "Weekend"
    case _ => "Nie ma takiego dnia"
  }

  def zadanie3(osoba: Osoba): String = osoba match {
    case Osoba("Jan", "Kos") => "Witamy dowódcę czołgu"
    case Osoba("Gustaw", "Jeleń") => "Witamy ładowiczego"
    case Osoba("Grigorij", "Saakaszwili") => "Witamy kierowcę-mechanika"
    case _ => "Witajcie, ale wy nie z załogi"
  }

  def zadanie4(liczba: Int, funkcja: Int => Int): Int = {
    funkcja(funkcja(funkcja(liczba)))
  }

  def main(args: Array[String]): Unit = {

    println("\n=========== 1 ===========\n")
    println(zadanie1("Poniedzialek"))
    println(zadanie1("Niedziela"))
    println(zadanie1("Jakisdzien"))
    println("\n=========== 2 ===========\n")
    val konto = new KontoBankowe()
    println(konto.balansKonta)
    val konto2 = new KontoBankowe(999
    )
    println(konto2.balansKonta)
    konto.wplata(20.3)
    println(konto.balansKonta)
    konto.wyplata(13.1)
    println(konto.balansKonta)
    println("\n=========== 3 ===========\n")
    val czolgista1 = new Osoba("Jan", "Kos")
    val czolgista2 = new Osoba("Gustaw", "Jeleń")
    val czolgista3 = new Osoba("Grigorij", "Saakaszwili")
    val czolgista4 = new Osoba("Franciszek", "Wichura")
    println(zadanie3(czolgista1))
    println(zadanie3(czolgista2))
    println(zadanie3(czolgista3))
    println(zadanie3(czolgista4))
    println("\n=========== 4 ===========\n")
    println(zadanie4(1, x => x + x))
    println("\n=========== 5 ===========\n")
    println("\n*** Student ***\n")
    val student1 = new Osoba5("jakis", "student") with Student
    println("Podatek studenta: " + student1.podatek)
    println("\n*** Pracownik ***\n")
    val pracownik1 = new Osoba5("pierwszy", "pracownik") with Pracownik
    pracownik1.pensja = 1000
    println("Pensja pracownika: " + pracownik1.pensja)
    println("Podatek pracownika: " + pracownik1.podatek)
    println("\n*** Nauczyciel ***\n")
    val nauczyciel1 = new Osoba5("pierwszy", "nauczyciel") with Nauczyciel
    nauczyciel1.pensja = 1000
    println("Pensja nauczyciela: " + nauczyciel1.pensja)
    println("Podatek Nauczyciela: " + nauczyciel1.podatek)
    println("\n*** Pracownik->Student ***\n")
    val pracownik_student = new Osoba5("pracownik", "student") with Pracownik with Student
    pracownik_student.pensja = 1000
    println("Podatek prac_stud od 1000: " + pracownik_student.podatek)
    println("\n*** Student->Pracownik ***\n")
    val student_pracownik = new Osoba5("student", "pracownik") with Student with Pracownik
    student_pracownik.pensja = 1000
    println("Podatek stud_prac od 1000: " + student_pracownik.podatek)




  }

}
