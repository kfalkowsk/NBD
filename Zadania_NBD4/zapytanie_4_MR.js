var mapFunction = function() {
  var bmi = this.weight / Math.pow(this.height/100, 2)
  emit(this.nationality, { count: 1, bmi_min: bmi, bmi_max: bmi, bmi_sum: bmi } )
}

var reduceFunction = function(sex, values) {
  var output = { count: 0, bmi_sum: 0, bmi_min: values[0].bmi_min, bmi_max: values[0].bmi_max };

  values.forEach(value => {
    if (value.bmi_min < output.bmi_min) {
      output.bmi_min = value.bmi_min
    }
    if (value.bmi_max > output.bmi_max) {
      output.bmi_max = value.bmi_max
    }
    output.bmi_sum += value.bmi_sum
    output.count += value.count});

  return output;
}

var finFunction = function(key, value) {
  result = { }
  result.avg_bmi = value.bmi_sum / value.count
  result.bmi_max = value.bmi_max
  result.bmi_min = value.bmi_min


  return result;
}
printjson(db.people.mapReduce(mapFunction, reduceFunction,
  {
    out: "Zapytanie_4_MR",
    finFunction,
  }));
printjson(db.Zapytanie_4_MR.find({}).toArray())