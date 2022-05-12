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

db.persons.aggregate(
    { 
        $project: {
            _id: 0, 
            gender: 1, 
            fullName: { 
                $concat: [
                    {$toUpper: { $substrCP: ['$name.first', 0, 1] } },
                    {
                        $substrCP: [
                            '$name.first',
                            1,
                            { $subtract: [{ $strLenCP: '$name.first'}, 1 ]}
                            ]
                    },
                     " ",
                    {$toUpper: { $substrCP: ['$name.last', 0, 1] } },
                    {
                        $substrCP: [
                            '$name.last',
                            1,
                            { $subtract: [{ $strLenCP: '$name.last'}, 1 ]}
                            ]
                    }
                ]  
            } 
        } 
    }
)

-----------------------------------------------

-- Turning the location into geoJSON object

db.persons.aggregate([
    {
        $project: {
            _id: 0,
            name: 1,
            email: 1,
            location: {
                type: "Point",
                coordinates: [
                    {
                        $convert: {
                            input: '$location.coordinates.longitude',
                            to: 'double',
                            onError: 0.0,
                            onNull: 0.0
                        }
                    },
                    {
                        $convert: {
                            input: '$location.coordinates.latitude',
                            to: 'double',
                            onError: 0.0,
                            onNull: 0.0
                        }
                    }
                ]
            }
        }
    },
    { 
        $project: {
            gender: 1, 
            email: 1,
            location: 1,
            fullName: { 
                $concat: [
                    {$toUpper: { $substrCP: ['$name.first', 0, 1] } },
                    {
                        $substrCP: [
                            '$name.first',
                            1,
                            { $subtract: [{ $strLenCP: '$name.first'}, 1 ]}
                            ]
                    },
                     " ",
                    {$toUpper: { $substrCP: ['$name.last', 0, 1] } },
                    {
                        $substrCP: [
                            '$name.last',
                            1,
                            { $subtract: [{ $strLenCP: '$name.last'}, 1 ]}
                            ]
                    }
                ]  
            } 
        } 
    }
]).pretty()

------------------------------------------------------------
-- Working with date

db.persons.aggregate([
    {
        $project: {
            _id: 0,
            name: 1,
            email: 1,
            birthdDate: { 
                $convert: {
                    input: '$dob.date',
                    to: 'date'
                }
            },
            age: "$dob.age",
            location: {
                type: "Point",
                coordinates: [
                    {
                        $convert: {
                            input: '$location.coordinates.longitude',
                            to: 'double',
                            onError: 0.0,
                            onNull: 0.0
                        }
                    },
                    {
                        $convert: {
                            input: '$location.coordinates.latitude',
                            to: 'double',
                            onError: 0.0,
                            onNull: 0.0
                        }
                    }
                ]
            }
        }
    },
    { 
        $project: {
            gender: 1, 
            email: 1,
            location: 1,
            birthdDate: 1,
            age: 1,
            fullName: { 
                $concat: [
                    {$toUpper: { $substrCP: ['$name.first', 0, 1] } },
                    {
                        $substrCP: [
                            '$name.first',
                            1,
                            { $subtract: [{ $strLenCP: '$name.first'}, 1 ]}
                            ]
                    },
                     " ",
                    {$toUpper: { $substrCP: ['$name.last', 0, 1] } },
                    {
                        $substrCP: [
                            '$name.last',
                            1,
                            { $subtract: [{ $strLenCP: '$name.last'}, 1 ]}
                            ]
                    }
                ]  
            } 
        } 
    }
]).pretty()


-- Use Shortcuts

db.persons.aggregate([
    {
        $project: {
            _id: 0,
            name: 1,
            email: 1,
            birthdDate: { $toDate: '$dob.date' },
            age: "$dob.age",
            location: {
                type: "Point",
                coordinates: [
                    {
                        $convert: {
                            input: '$location.coordinates.longitude',
                            to: 'double',
                            onError: 0.0,
                            onNull: 0.0
                        }
                    },
                    {
                        $convert: {
                            input: '$location.coordinates.latitude',
                            to: 'double',
                            onError: 0.0,
                            onNull: 0.0
                        }
                    }
                ]
            }
        }
    },
    { 
        $project: {
            gender: 1, 
            email: 1,
            location: 1,
            birthdDate: 1,
            age: 1,
            fullName: { 
                $concat: [
                    {$toUpper: { $substrCP: ['$name.first', 0, 1] } },
                    {
                        $substrCP: [
                            '$name.first',
                            1,
                            { $subtract: [{ $strLenCP: '$name.first'}, 1 ]}
                            ]
                    },
                     " ",
                    {$toUpper: { $substrCP: ['$name.last', 0, 1] } },
                    {
                        $substrCP: [
                            '$name.last',
                            1,
                            { $subtract: [{ $strLenCP: '$name.last'}, 1 ]}
                            ]
                    }
                ]  
            } 
        } 
    },
    { $group: { _id: { birthYear: { $isoWeekYear: "$birthdDate" } }, numPersons: { $sum: 1} }},
    { $sort: {numPersons: -1}}
]).pretty()

---------------------------------------------

-- Push array data into db
-- use array-data.json

-- db.friends.insertMany([ "copy data from array-data.json and paste here" ])

db.friends.aggregate([
    {$group: {_id: {age: "$age"}, allHobbies: { $push: "$hobbies" }  }}
]).pretty()

-- using unwind

db.friends.aggregate([
    { $unwind: "$hobbies" },
    {$group: {_id: {age: "$age"}, allHobbies: { $push: "$hobbies" }  }}
]).pretty()


-- remove dupliates in output
db.friends.aggregate([
    { $unwind: "$hobbies" },
    {$group: {_id: {age: "$age"}, allHobbies: { $addToSet: "$hobbies" }  }}
]).pretty()



-- using projection with arrays
db.friends.aggregate([
    { $project: { _id: 0, examScore: { $slice: [ "$examScores", 1 ] } }}
]).pretty()

db.friends.aggregate([
    { $project: { _id: 0, examScore: { $slice: [ "$examScores", -1 ] } }}
]).pretty()

db.friends.aggregate([
    { $project: { _id: 0, examScore: { $slice: [ "$examScores", 2, 1 ] } }}
]).pretty()

-- length of an array

db.friends.aggregate([
    { $project: { _id: 0, numScores: { $size: "$examScores" } }}
]).pretty()


--Using filters

db.friends.aggregate([
    { 
        $project: { 
            _id: 0,
            scores: {
                $filter: {
                    input: '$examScores',
                    as: "sc",
                    cond: {
                        $gt: [ "$$sc.score", 60 ]
                    }
                }
            }
        }
    }
]).pretty()

-- apply multiple operators on array

db.friends.aggregate([
    { $unwind: "$examScores"},
    { $sort : {examScores: -1}}
]).pretty()


db.friends.aggregate([
    { $unwind: "$examScores"},
    { $project: { _id: 1, name: 1, age: 1, score: "$examScores.score"} },
    { $sort : {score: -1}},
    { $group: { _id: "$_id", name: { $first: "$name"} , maxScore: { $max: "$score"} }},
    { $sort: { maxScore: -1}}
]).pretty()


-----------------------------------------------------

-- $bucket 

db.persons.findOne()

db.persons.aggregate([
    {
        $bucket: {
            groupBy: "$dob.age",
            boundaries: [0, 10, 30, 50, 80, 120],
            output: {
                numPersons: { $sum: 1},
                averageAge: { $avg: "$dob.age"}
            }
        }
    }
]).pretty()

> db.persons.find({ "dob.age": {$lt: 18} })
> db.persons.find({ "dob.age": {$gt: 80} })
>

db.persons.aggregate([
    {
        $bucket: {
            groupBy: "$dob.age",
            boundaries: [18, 30, 40, 50, 60, 120],
            output: {
                numPersons: { $sum: 1},
                averageAge: { $avg: "$dob.age"}
            }
        }
    }
]).pretty()


-- auto bucketing

db.persons.aggregate([
    {
        $bucketAuto: {
            groupBy: "$dob.age",
            buckets: 5,
            output: {
                numPersons: { $sum: 1},
                averageAge: { $avg: "$dob.age"}
            } 
        }
    }
]).pretty()