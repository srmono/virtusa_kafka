-- Insert persons.json

mongoimport persons.json -d contactData -c contacts --jsonArray

use contactData
db.contacts.findOne()

db.contacts.find(
    {
        "dob.age": {$gt: 60}
    }
).pretty()

db.contacts.find(
    {
        "dob.age": {$gt: 60}
    }
).count()

> 1222

-- using explain()

db.contacts.explain().find(
    {
        "dob.age": {$gt: 60}
    }
)

db.contacts.explain("executionStats").find(
    {
        "dob.age": {$gt: 60}
    }
)

-- Create first index on age field

-- db.collectionname.createIndex({fieldName: order})

db.contacts.createIndex({ "dob.age": 1 })

db.contacts.explain("executionStats").find(
    {
        "dob.age": {$gt: 60}
    }
)

db.contacts.explain("executionStats").find(
    {
        "dob.age": {$gt: 20}
    }
)

-- Dropping index
-- db.collectionname.dropIndex({fieldName: order})

db.contacts.dropIndex({ "dob.age": 1 })

--compound indexes

db.contacts.findOne()


db.contacts.createIndex({ gender: 1 })

db.contacts.explain("executionStats").find(
    {
        gender: "male"
    }
)

db.contacts.dropIndex({ gender: 1 })

db.contacts.createIndex({ "dob.age": 1 ,gender: 1 })

db.contacts.explain("executionStats").find(
    {
        "dob.age": 35,
        gender: "male"
    }
)

-- index behaviour is left to right
db.contacts.explain("executionStats").find({ "dob.age": 35 } ); -- uses index scan
db.contacts.explain("executionStats").find({ gender: "male" } ) -- uses default COLLSCAN


-- Using indexes for sorting
db.contacts.explain().find({"dob.age": 35}).sort({gender: 1})

-- List indexes 
-- db.collectionname.getIndexes()

db.contacts.getIndexes()

-- Configuring indexes

db.contacts.findOne()

> db.contacts.createIndex({email: 1}, {unique: true})
{
        "ok" : 0,
        "errmsg" : "Index build failed: a5be7d06-eab7-414f-ae1f-eb75585b3afb: Collection contactData.contacts ( 4669f7e1-628e-49a7-b853-6a64e8da35e2 ) :: caused by :: E11000 duplicate key error collection: contactData.contacts index: email_1 dup key: { email: \"abigail.clark@example.com\" }",
        "code" : 11000,
        "codeName" : "DuplicateKey",
        "keyPattern" : {
                "email" : 1
        },
        "keyValue" : {
                "email" : "abigail.clark@example.com"
        }
}

db.contacts.find({"email" : "abigail.clark@example.com"}).count()

db.contacts.dropIndex({ "dob.age": 1 ,gender: 1 })


-- Partial indexes
db.contacts.createIndex({"dob.age": 1}, {partialFilterExpression: { gender: "male"}})

db.contacts.find({"dob.age": {$gt: 60}}).pretty()

db.contacts.explain().find({"dob.age": {$gt: 60}})


db.contacts.explain().find({"dob.age": {$gt: 60}, gender: "male"})

----------------------------------------------
db.users.insertMany([
    {name: "Venkat", email: "venkat@test.com"},
    {name: "Snuti"}
])


db.users.createIndex({email: 1})

db.users.dropIndex({email: 1})

db.users.createIndex({email: 1}, {unique: true})

db.users.insertOne({name: "Snuti"}) 
--duplicate error

db.users.dropIndex({email: 1})

db.users.createIndex({email: 1}, {unique: true, partialFilterExpression: {email: {$exists: true} }})

db.users.insertOne({name: "Snuti"}) 

db.users.find().pretty()

db.users.insertOne({name: "Venkat", email: "venkat@test.com"})

-- TTL Time to Live

db.sessions.insertOne(
    {
        data: "Just a message",
        createAt: new Date()
    }
)

db.sessions.find().pretty()

db.sessions.createIndex( {createAt: 1} )

db.sessions.dropIndex( {createAt: 1} )

db.sessions.createIndex( 
    {createAt: 1},  
    {expireAfterSeconds: 10 }
)

--Query Diagnosis & Query planning

explain()
    "queryPlanner":
        shows summary for executed query + Winning plan 
    "executionStats":
        shows detailed summary for
            Executed Query + 
            Winning Plan +
            Possibly Rejected Plans
    "allPlansExecution":
        shows detailed summary of
            Executed Query + 
            Winning Plan +
            Winning plan Decision Proces


-- understand covered queries

db.customers.insertMany(
    [
        { name: "Venkat", age: 32, salary: 3800},
        { name: "Manu", age: 45, salary: 4000}
    ]
)

db.customers.createIndex({name: 1})

db.customers.explain("executionStats").find({name: "Venkat"})
db.customers.explain("allPlansExecution").find({name: "Venkat"})

------------------
-- How mongo rejects a plan

db.customers.getIndexes()

db.customers.createIndex( {age: 1, name: 1})

db.customers.explain("allPlansExecution").find({ name: "Manu", age: 45} )

db.customers.explain("allPlansExecution").find({ age: 32,name: "Venkat"})

--Cleaning the winning plan from cache?

Stored forever?
    write threshold (currently 1000)
    when indexes are rebuild
    other indexes are added or removed
    Mongo db server restored 
