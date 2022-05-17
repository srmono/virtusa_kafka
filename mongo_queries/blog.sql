use blog 

db.users.insertMany(
    [
        {
            name: "Venkat",
            age: 32,
            email: "bvsrao91@gmail.com"
        },
        {
            name: "Sai",
            age: 28,
            email: "sai@gmail.com"
        },
    ]
)

db.posts.insertOne({
    title: "My First Post",
    text: "This is my first post hope you like it...!",
    tags: ["new", "tech","IT"],
    creator: ObjectId("6269fdf6e3f0584eef343fd3"),
    comments: [
        {
            text: "I like this post !",
            author: ObjectId("6269fdf6e3f0584eef343fd4")
        }
    ]
})