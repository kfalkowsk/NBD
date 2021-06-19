printjson(
  db.people.insert({
    sex: "Male",
    first_name: "Kacper",
    last_name: "Falkowski",
    job: "Student",
    email: "s23868@pjwstk.edu.pl",
    location: { city: "Warszawa", adress: { streetname: "Płocka", streetnumber: "15"} },
    description: "Dodawanie siebie do bazy",
    height: "184",
    weight: "85",
    birth_date: "1993-09-27T01:01:01Z",
    nationality: "Polish",
    credit: [{
      type: "PKOBP",
      number: "1111222233334444",
      currency: "PLN",
      balance: "1234"
    }]
  })
)