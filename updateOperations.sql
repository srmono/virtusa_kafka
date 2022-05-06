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















