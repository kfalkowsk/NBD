var mapFunction = function() {
  this.credit.forEach(credit => {
    emit(null, { count: 1, bal: parseFloat(credit.balance) });
  });
}

var reduceFunction = function(key, values) {
  var output = { count: 0, bal: 0 };

  values.forEach(value => {
    output.bal += value.bal;
    output.count += value.count
  });

  return output;
}

var finFunction = function(key, value) {
  result = { }
  result.bal_sum = value.bal
  result.bal_avg = value.bal / value.count

  return result;
}

printjson(db.people.mapReduce(mapFunction,reduceFunction,
  {
    out: "Zapytanie_5_MR",
    finFunction: finFunction,
    query: { "nationality": "Poland", "sex": "Female" }
  }));
printjson(db.Zapytanie_5_MR.find({}).toArray())