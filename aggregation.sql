mongoimport persons.json -d analytics -c persons --jsonArray

db.persons.aggregate([
    {$match: {gender: "female"} },
    {$group: { _id: {state: "$location.state" }, totalPersons: { $sum: 1} } },
    {$sort: { totalPersons: -1}}
]).pretty()

db.persons.aggregate(
    { $project: {_id: 0, gender: 1, fullName: { $concat: ["Hello" , "World"]  } } }
)

db.persons.aggregate(
    { $project: {_id: 0, gender: 1, fullName: { $concat: ["Hello" , " ", "World"]  } } }
)

