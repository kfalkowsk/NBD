var mapFunction = function() {
  emit('jobs', this.job )
}

var reduceFunction = function(key, values) {
  var result = {}
  values.forEach((k, v) => {
    result[k] = true
  })

  return result
}

var finFunction = function(key, value) {
  return Object.keys(value)
}

printjson(db.people.mapReduce(mapFunction,reduceFunction,
  {
    out: "Zapytanie_3_MR",
    finFunction,
  }));
printjson(db.Zapytanie_3_MR.find({}).toArray())