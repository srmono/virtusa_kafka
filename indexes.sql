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
-----------------------------------------------

-- Multi - key indexes 

use contactData
db.contacts.drop()

db.contacts.insertOne(
    {
        name: "Venkat",
        hobbies: ["Cooking", "Sports"],
        addresses: [
            {
                street: "Main Street"
            },
            {
                street: "Second Street"
            }
        ]
    }
)

db.contacts.createIndex({ hobbies: 1})

db.contacts.find({hobbies: "Sports"}).pretty()

db.contacts.explain("executionStats").find({hobbies: "Sports"})


db.contacts.createIndex({ addresses: 1})

db.contacts.explain("executionStats").find({ "addresses.street": "Main Street"})

db.contacts.explain("executionStats").find({
    addresses: {
        street: "Main Street"
    }
})

db.contacts.createIndex({ name: 1, hobbies: 1})

db.contacts.createIndex({ addresses: 1, hobbies: 1})

-------------------------------
-- Text indexes

db.products.insertMany(
    [
        {
            title: "A Book",
            description: "This is an awesome book about a young artist!"
        },
        {
            title: "Red T-Shirt",
            description: "This T-Shirt is red and it's pretty awesome"
        }
    ]
)

db.products.createIndex({description: 1})
db.products.dropIndex({description: 1})

db.products.createIndex({description: "text"})

db.products.find( { $text : {
    $search: "awesome"
}}).pretty()

db.products.find( { $text : {
    $search: "book"
}}).pretty()

db.products.find( { $text : {
    $search: "red book"
}}).pretty()

db.products.find( { $text : {
    $search: "\"red book\""
}}).pretty()

db.products.find( { $text : {
    $search: "\"awesome book\""
}}).pretty()

db.products.find( { $text : {
    $search: "awesome t-shirt"
}}).pretty()

db.products.find(
    {
        $text: {
            $search: "awesome t-shirt"
        }
    },
    {
        score: { 
            $meta: "textScore"
        }
    }
).pretty()

db.products.getIndexes()

db.products.dropIndex("description_text")

db.products.createIndex( { title: "text", description: "text"})

db.products.insertOne({
    title: "A Ship",
    description: "Floats perfectly!"
})

db.products.find( { $text : {
    $search: "ship some"
}}).pretty()

db.products.find( { $text : {
    $search: "awesome"
}}).pretty()

db.products.find( { $text : {
    $search: "awesome -t-shirt"
}}).pretty()

db.products.getIndexes()

db.products.dropIndex("title_text_description_text")


db.products.createIndex( 
    { title: "text", description: "text"},
    { 
        default_language: "english",
        weights: {
            title: 1,
            description: 10
        }
    }
)


db.products.find({
    $text: {
        $search: "",
        $language: "german",
        $caseSensitive: true
    }
})

db.products.find(
    {
        $text: {
            $search: "red"
        }
    },
    {
        score: { 
            $meta: "textScore"
        }
    }
).sort({score: { $meta: "textScore"}})

db.products.dropIndex("title_text_description_text")


db.products.createIndex( 
    { title: "text", description: "text"},
    { 
        default_language: "english"
    }
)