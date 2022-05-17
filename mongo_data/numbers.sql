-- integers                     int32  -2147483648 to 2147483648
-- longs                        int64
-- doubles                      64 bit
-- High precision doubles       128 bit

> use numdb
switched to db numdb
>
> db.persons.insertOne({name: "venkat", age: 29})
{
        "acknowledged" : true,
        "insertedId" : ObjectId("627dbc20a95b9c1d7eca8a08")
}
>

db.persons.deleteMany({})

> db.persons.insertOne({age: 29})

db.persons.deleteMany({})

> db.persons.insertOne({age: NumberInt("29")})