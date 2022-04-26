//2015 -> es6 

var person = {
    name: "venkat",
    prof: "trainer",
    address: {
        city: "Bangalore",
        state: "KA"
    },
    data: [ {}, {}]
}

var welcome = (name, x) =>  {
    return "Hello " + name;
}

console.log(welcome("venkat"))

//while, do while, for, for in , for of 

//[{}, {}, {}, ]

const array1 = [
    {
        name: "venkat",
        prof: "trainer"
    },
    {
        name: "sai",
        prof: "sr. developer"
    }
];

//array1[0].name

array1.forEach(el => {
    for(prop in el){
        console.log(prop, " - ", el[prop])
    }
});



