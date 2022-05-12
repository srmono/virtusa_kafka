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

