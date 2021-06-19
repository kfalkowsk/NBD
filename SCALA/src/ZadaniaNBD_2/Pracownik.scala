package ZadaniaNBD_2

trait Pracownik extends Osoba5 {
  private var _pensja = 0
  def pensja = _pensja
  def pensja_= (wartosc:Int) = _pensja = wartosc

  override def podatek: Double = 0.2 * pensja
}
