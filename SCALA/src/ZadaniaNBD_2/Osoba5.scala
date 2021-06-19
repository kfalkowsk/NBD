package ZadaniaNBD_2

class Osoba5(private var _imie: String, private var _nazwisko: String) {
//  private var _imie = imie
//  private var _nazwisko = nazwisko
  private var _podatek = 0.0
  def imie = _imie
  def nazwisko = _nazwisko
  def podatek = _podatek

  def this(imie:String){
    this(imie, "")
  }

  def this(imie: String, nazwisko: String, podatek: Double){
    this(imie, nazwisko)
    this._podatek = podatek
  }
}
