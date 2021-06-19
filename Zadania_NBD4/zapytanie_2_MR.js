var mapFunction = function() {
  this.credit.forEach(credit => {
    emit(credit.currency, parseFloat(credit.balance));
  });
}

var reduceFunction = function(currency, values) {
  return Array.sum(values)
}

printjson(db.people.mapReduce(mapFunction,reduceFunction,
  {
    out: "Zapytanie_2_MR",
  }));
printjson(db.Zapytanie_2_MR.find({}).toArray())