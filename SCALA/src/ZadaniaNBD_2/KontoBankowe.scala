package ZadaniaNBD_2

class KontoBankowe {

  private var _balansKonta: Double = 0

  def this(balansKonta: Double) {
    this()
    this._balansKonta = balansKonta
  }

  def balansKonta = _balansKonta

  def wplata(piniondze: Double): Double = {
    this._balansKonta += piniondze
    return _balansKonta
  }

  def wyplata(piniondze: Double): Double = {
    if (_balansKonta - piniondze < 0)
      return _balansKonta
    this._balansKonta -= piniondze
    return _balansKonta
  }


}
