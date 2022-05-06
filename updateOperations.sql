use user

db.users.find().pretty()

db.users.updateOne(
    { _id: ObjectId("6271d9a277ecc9828367e7c4") },
    {
        $set: {
            hobbies: [
                {
                    title: "Sports",
                    frequency: 5
                },
                {
                    title: "Cooking",
                    frequency: 3
                },
                {
                    title: "Hiking",
                    frequency: 1
                }
            ]
        }
    }
)

db.users.updateMany(
    {"hobbies.title": "Sports"},
    {
        $set: { isSporty: true}
    }
)

db.users.updateOne(
    { _id: ObjectId("6271d9a277ecc9828367e7c4") },
    {
        $set: {
            age: 40,
            phone: 879879797
        }
    }
)

db.users.updateOne(
    {name: "snuti"},
    {
        $inc: { age: -1 }
    }
)

db.users.updateOne(
    {name: "snuti"},
    {
        $inc: { age: 1 },
        $set: {age: 40}
    }
)

db.users.updateOne(
    { name: "Chris"},
    { $min: {age: 36}}
)

db.users.updateOne(
    { name: "Chris"},
    { $max: {age: 36}}
)

db.users.updateOne(
    { name: "Chris"},
    { $mul: {age: 1.1}}
)

db.users.updateMany({isSporty: true}, {$set: {phone: null}})

db.users.updateMany({isSporty: true}, {$unset: {phone: ""}})

--rename fields

db.users.updateMany({}, { $rename : { age: "totalAge" }})



-- Understanding Upsert()

db.users.updateOne(
    { name: "Maria"},
    { $set: {
        age: 29,
        hobbies: [
            {
                title: "Good food",
                frequency: 3
            }
        ],
        isSporty: true
    }}
)

db.users.updateOne(
    { name: "Maria"},
    { $set: {
        age: 29,
        hobbies: [
            {
                title: "Good food",
                frequency: 3
            }
        ],
        isSporty: true
    }},
    { upsert: true}
)

------------------------------------
-- Updating array elements

-- find and update 

db.users.find({
    $and: [
        { "hobbies.title": "Sports"},
        { "hobbies.frequency": {$gte: 3}}
    ]
}).pretty()


db.users.find(
    {
        hobbies: {
            $elemMatch: {
                title: "Sports",
                frequency: {
                    $gte: 3
                }
            }
        }
    }
).pretty()


db.users.find(
    {
        hobbies: {
            $elemMatch: {
                title: "Sports",
                frequency: {
                    $gte: 3
                }
            }
        }
    }
).count()
> 2

db.users.updateMany(
    {
        hobbies: {
            $elemMatch: {
                title: "Sports",
                frequency: {
                    $gte: 3
                }
            }
        }
    },
    {
        $set: {
            "hobbies.$.highFrequency": true
        }
    }
)

db.users.find({"hobbies.frequency": {$gt: 2} }).pretty()
db.users.find({"hobbies.frequency": {$gt: 2} }).count()

db.users.updateMany(
    {"hobbies.frequency": {$gt: 2} },
    {
       $set: {
            "hobbies.$.goodFrequency": true
        }
    }
)

db.users.updateMany(
    {"hobbies.frequency": {$gt: 2} },
    {
       $set: {
            "hobbies.$[el].goodFrequency": true
        }
    },
    {
        arrayFilters: [ {"el.frequency": { $gt: 2 }} ]
    }
)

---------------

db.users.find( {totalAge: {$gt: 30}}).pretty()


db.users.updateMany( 
    {totalAge: {$gt: 30}},
    { $inc: {
        "hobbies.frequency": -1
    }}
)


db.users.updateMany( 
    {totalAge: {$gt: 30}},
    { $inc: {
        "hobbies.$[].frequency": -1
    }}
)

---------------------------
-- Add Elements to an Array

db.users.updateOne(
    {name: "Maria"},
    {
        $push: {
            hobbies: {
                title: "Sports",
                frequency: 2
            }
        }
    }
)
-- if you execute multiple time's it add duplicate value
db.users.updateOne(
    {name: "Maria"},
    {
        $push: {
            hobbies: {
                title: "Sports",
                frequency: 2
            }
        }
    }
)

db.users.updateOne(
    {name: "Maria"},
    {
        $push: {
            hobbies: {
                
            }
        }
    }
)












