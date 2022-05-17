db.runCommand({
    collMod: "posts",
    validator: {
        $jsonSchema: {
            bsonType: "object",
            required: ["title", "text", "creator", "comments"],
            properties: {
                title: {
                    bsonType: "string",
                    description: "must be string and it is required"
                },
                text: {
                    bsonType: "string",
                    description: "must be string and it is required"
                },
                creator: {
                    bsonType: "objectId",
                    description: "must be ObjectId and it is required"
                },
                comments: {
                    bsonType: "array",
                    description: "must be an Array and required",
                    items: {
                        bsonType: "object",
                        required: ["text", "author"],
                        properties: {
                            text: {
                                bsonType: "string",
                                description: "must be string and it is required"
                            },
                            author: {
                                bsonType: "objectId",
                                description: "must be ObjectId and it is required"
                            }
                        }
                    }
                }
            }
        }
    },
    validationAction: 'warn'
})