var mapFunction = function() {
  emit(this.sex, { count: 1, height: this.height, weight: this.weight });
}

var reduceFunction = function(sex, values) {
  var valtab = { count: 0, weight: 0, height: 0 };

  values.forEach(value => {
    valtab.weight += value.weight;
    valtab.height += value.height;
    valtab.count += value.count});

  return valtab;
}

var finFunction = function(key, value) {
  result = { }
  result.avg_weight = value.weight / value.count
  result.avg_height = value.height / value.count

  return result;
}

printjson(db.people.mapReduce(mapFunction,reduceFunction,
  {
    out: "Zapytanie_1_MR",
    finFunction: finFunction
  }));
printjson(db.Zapytanie_1_MR.find({}).toArray())