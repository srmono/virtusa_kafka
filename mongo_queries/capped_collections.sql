use performance

db.createCollection("capped", { capped: true, size: 10000, max: 3} )