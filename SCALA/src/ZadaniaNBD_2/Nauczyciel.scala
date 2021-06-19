package ZadaniaNBD_2

trait Nauczyciel extends Pracownik {
  override def podatek: Double = 0.1 * pensja

}
