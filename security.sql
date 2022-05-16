-- Authentication and authorization
-- Transport encryption 
-- Encryption at best 
-- Audit 
-- Server network config 
-- Backup and software updates

-- Authentication and authorization

-- client app -> mongo server -> db

-- Admin , Developer , Data Scientist 

-- createUser(...) 
-- updateUser(...)

mongo -u user -p pw

use admin 

db.createUser({user: "venkat", pwd: "123", roles: ["userAdminAnyDatabase"] })

db.createUser({user: "appdev", pwd: "dev", roles: ["readWrite"] })

db.updateUser( "appdev", { roles: ["readWrite", { role: "readWrite", db: "blog" }] } )

