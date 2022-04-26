use flights 

db.flightData.insertOne({
    "departureAirport": "MUC",
    "arrivalAirport": "SFO",
    "aircraft": "Airbus A380",
    "distance": 12000,
    "intercontinental": true
  });


db.flightData.deleteOne({departureAirport: "TXL"})

db.flightData.updateOne({distance: 12000} , {$set: {marker: "delete"} })

db.flightData.updateMany({}, {$set: {marker: "toDelete"} })

db.flightData.deleteMany({marker: "toDelete"})

## Insert many 

db.flightData.insertMany([
  {
    "departureAirport": "MUC",
    "arrivalAirport": "SFO",
    "aircraft": "Airbus A380",
    "distance": 12000,
    "intercontinental": true
  },
  {
    "departureAirport": "LHR",
    "arrivalAirport": "TXL",
    "aircraft": "Airbus A320",
    "distance": 950,
    "intercontinental": false
  }
]
)

db.flightData.find({name: "venkat"}); // no data 

db.flightData.find({intercontinental: true}).pretty()

db.flightData.find({distance: 12000}).pretty()

db.flightData.find({distance: {$gt: 900} }).pretty()

db.flightData.findOne({distance: {$gt: 900} }).pretty()

db.flightData.updateOne( { "_id" : ObjectId("626759b80b453f0768934cb5")}, {$set: {delayed: true}})

db.flightData.update( { "_id" : ObjectId("626759b80b453f0768934cb5")}, {$set: {delayed: true}})

db.flightData.update( { "_id" : ObjectId("626759b80b453f0768934cb5")}, {$set: {delayed: false}})

//error
db.flightData.updateOne( { "_id" : ObjectId("626759b80b453f0768934cb5")}, {delayed: false})

db.flightData.updateMany( { "_id" : ObjectId("626759b80b453f0768934cb5")}, {delayed: false})

db.flightData.update( { "_id" : ObjectId("626759b80b453f0768934cb5")}, {delayed: false})

//Insert passengers 


db.passengers.insertMany([
  {
    "name": "Max Mul",
    "age": 29
  },
  {
    "name": "Manu Lorenz",
    "age": 30
  },
  {
    "name": "Chris Hayton",
    "age": 35
  },
  {
    "name": "Sandeep Kumar",
    "age": 28
  },
  {
    "name": "Maria Jones",
    "age": 30
  },
  {
    "name": "Alexandra Maier",
    "age": 27
  },
  {
    "name": "Dr. Phil Evans",
    "age": 47
  },
  {
    "name": "Sandra Brugge",
    "age": 33
  },
  {
    "name": "Elisabeth Mayr",
    "age": 29
  },
  {
    "name": "Frank Cube",
    "age": 41
  },
  {
    "name": "Karandeep Alun",
    "age": 48
  },
  {
    "name": "Michaela Drayer",
    "age": 39
  },
  {
    "name": "Bernd Hoftstadt",
    "age": 22
  },
  {
    "name": "Scott Tolib",
    "age": 44
  },
  {
    "name": "Freddy Melver",
    "age": 41
  },
  {
    "name": "Alexis Bohed",
    "age": 35
  },
  {
    "name": "Melanie Palace",
    "age": 27
  },
  {
    "name": "Armin Glutch",
    "age": 35
  },
  {
    "name": "Klaus Arber",
    "age": 53
  },
  {
    "name": "Albert Twostone",
    "age": 68
  },
  {
    "name": "Gordon Black",
    "age": 38
  }
]
)

db.passengers.find();

db.passengers.find().toArray()

db.passengers.find().forEach( (passengerData) => {
    printjson(passengerData)
} )

db.flightData.replaceOne( {"_id" : ObjectId("626759b80b453f0768934cb5")},   {
     "departureAirport": "MUC",
     "arrivalAirport": "SFO",
     "aircraft": "Airbus A380",
     "distance": 12000,
     "intercontinental": true
})

db.passengers.find({}, {name: 1}).pretty()

db.passengers.find({}, {_id: 0, name: 1}).pretty()


-- Add Embedded document

db.flightData.updateMany(
    {}, 
    {
        $set: {
            status: {
                description: "on-time",
                lastUpdated: "1 hours ago",
                details: {
                    responsible: "venkat"
                }
            }
        }
    }
)

