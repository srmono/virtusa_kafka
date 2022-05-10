use awesomeplaces

db.places.insertOne(
    {
        name: "my first location",
        location: {
            type: "Point",
            coordinates: [77.713038, 12.899048]
        }
    }
)

12.90014, 77.71396

db.places.find(
    {
        location: {
            $near: {
                $geometry: {
                    type: "Point",
                    coordinates: [77.71396, 12.90014]
                }
            }
        }
    }
).pretty()

db.places.createIndex({location: "2dsphere"})


db.places.find(
    {
        location: {
            $near: {
                $geometry: {
                    type: "Point",
                    coordinates: [77.71396, 12.90014]
                },
                $maxDistance: 30,
                $minDistance: 10
            }
        }
    }
).pretty()