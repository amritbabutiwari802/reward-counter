# Read Me First
this application is a web application based on spring boot. It calculates rewards
for each customer
# Api description
swagger url: http://localhost:8080/swagger-ui/index.html
#  localhost:8080/transaction
the above endpoint generates reward points for all customer. http method is
post. the request body is of following 
# Request body
[
{
"customerName": "Benjamin Rodriguez",
"date": "2023-02-17",
"amount": 170.0
},
{
"customerName": "Evelyn Lopez",
"date": "2023-03-25",
"amount": 508.0
},
{
"customerName": "Isabella Martinez",
"date": "2023-02-03",
"amount": 85.0
},
{
"customerName": "Emma Johnson",
"date": "2023-02-15",
"amount": 67.0
},
{
"customerName": "Mia Anderson",
"date": "2023-01-14",
"amount": 170.0
},
{
"customerName": "Amelia Moore",
"date": "2023-03-18",
"amount": 755.0
},
{
"customerName": "Sophia Davis",
"date": "2023-02-11",
"amount": 988.0
},
{
"customerName": "Daniel Jackson",
"date": "2023-03-08",
"amount": 337.0
},
{
"customerName": "Michael Williams",
"date": "2023-02-23",
"amount": 395.0
},
{
"customerName": "Charlotte Thomas",
"date": "2023-02-23",
"amount": 34.0
},
{
"customerName": "Harper Thompson",
"date": "2023-01-30",
"amount": 109.0
},
{
"customerName": "Benjamin Rodriguez",
"date": "2023-03-06",
"amount": 503.0
},
{
"customerName": "Harper Thompson",
"date": "2023-03-16",
"amount": 326.0
},
{
"customerName": "James Miller",
"date": "2023-01-30",
"amount": 53.0
},
{
"customerName": "Harper Thompson",
"date": "2023-01-04",
"amount": 983.0
},
{
"customerName": "Ethan Taylor",
"date": "2023-02-17",
"amount": 844.0
},
{
"customerName": "Jacob Wilson",
"date": "2023-03-18",
"amount": 805.0
},
{
"customerName": "Matthew White",
"date": "2023-01-27",
"amount": 261.0
},
{
"customerName": "Harper Thompson",
"date": "2023-03-14",
"amount": 321.0
},
{
"customerName": "John Smith",
"date": "2023-02-15",
"amount": 338.0
},
{
"customerName": "Isabella Martinez",
"date": "2023-01-23",
"amount": 631.0
},
{
"customerName": "Benjamin Rodriguez",
"date": "2023-03-22",
"amount": 687.0
},
{
"customerName": "Ethan Taylor",
"date": "2023-03-25",
"amount": 718.0
},
{
"customerName": "Harper Thompson",
"date": "2023-02-03",
"amount": 231.0
},
{
"customerName": "Mia Anderson",
"date": "2023-03-18",
"amount": 877.0
},
{
"customerName": "James Miller",
"date": "2023-01-29",
"amount": 54.0
},
{
"customerName": "Daniel Jackson",
"date": "2023-01-23",
"amount": 515.0
},
{
"customerName": "Ethan Taylor",
"date": "2023-01-23",
"amount": 345.0
},
{
"customerName": "Emma Johnson",
"date": "2023-03-14",
"amount": 267.0
},
{
"customerName": "Michael Williams",
"date": "2023-01-23",
"amount": 237.0
},
{
"customerName": "James Miller",
"date": "2023-02-03",
"amount": 223.0
},
{
"customerName": "Olivia Brown",
"date": "2023-03-18",
"amount": 794.0
},
{
"customerName": "Evelyn Lopez",
"date": "2023-02-23",
"amount": 387.0
},
{
"customerName": "Emma Johnson",
"date": "2023-03-25",
"amount": 349.0
},
{
"customerName": "Harper Thompson",
"date": "2023-03-25",
"amount": 769.0
},
{
"customerName": "Isabella Martinez",
"date": "2023-01-10",
"amount": 547.0
},
{
"customerName": "Sophia Davis",
"date": "2023-01-23",
"amount": 235.0
},
{
"customerName": "Harper Thompson",
"date": "2023-01-29",
"amount": 711.0
},
{
"customerName": "Amelia Moore",
"date": "2023-03-16",
"amount": 112.0
},
{
"customerName": "Olivia Brown",
"date": "2023-02-17",
"amount": 208.0
}
]


# localhost:8080/get-rewards-by-customer?customer=Amelia%20Moore
use above endpoint for generating reward points for a customer. pass customer name 
as query param
# request body
[
{
"customerName": "Benjamin Rodriguez",
"date": "2023-02-17",
"amount": 170.0
},
{
"customerName": "Evelyn Lopez",
"date": "2023-03-25",
"amount": 508.0
},
{
"customerName": "Isabella Martinez",
"date": "2023-02-03",
"amount": 85.0
},
{
"customerName": "Emma Johnson",
"date": "2023-02-15",
"amount": 67.0
},
{
"customerName": "Mia Anderson",
"date": "2023-01-14",
"amount": 170.0
},
{
"customerName": "Amelia Moore",
"date": "2023-03-18",
"amount": 755.0
},
{
"customerName": "Sophia Davis",
"date": "2023-02-11",
"amount": 988.0
},
{
"customerName": "Daniel Jackson",
"date": "2023-03-08",
"amount": 337.0
},
{
"customerName": "Michael Williams",
"date": "2023-02-23",
"amount": 395.0
},
{
"customerName": "Charlotte Thomas",
"date": "2023-02-23",
"amount": 34.0
},
{
"customerName": "Harper Thompson",
"date": "2023-01-30",
"amount": 109.0
},
{
"customerName": "Benjamin Rodriguez",
"date": "2023-03-06",
"amount": 503.0
},
{
"customerName": "Harper Thompson",
"date": "2023-03-16",
"amount": 326.0
},
{
"customerName": "James Miller",
"date": "2023-01-30",
"amount": 53.0
},
{
"customerName": "Harper Thompson",
"date": "2023-01-04",
"amount": 983.0
},
{
"customerName": "Ethan Taylor",
"date": "2023-02-17",
"amount": 844.0
},
{
"customerName": "Jacob Wilson",
"date": "2023-03-18",
"amount": 805.0
},
{
"customerName": "Matthew White",
"date": "2023-01-27",
"amount": 261.0
},
{
"customerName": "Harper Thompson",
"date": "2023-03-14",
"amount": 321.0
},
{
"customerName": "John Smith",
"date": "2023-02-15",
"amount": 338.0
},
{
"customerName": "Isabella Martinez",
"date": "2023-01-23",
"amount": 631.0
},
{
"customerName": "Benjamin Rodriguez",
"date": "2023-03-22",
"amount": 687.0
},
{
"customerName": "Ethan Taylor",
"date": "2023-03-25",
"amount": 718.0
},
{
"customerName": "Harper Thompson",
"date": "2023-02-03",
"amount": 231.0
},
{
"customerName": "Mia Anderson",
"date": "2023-03-18",
"amount": 877.0
},
{
"customerName": "James Miller",
"date": "2023-01-29",
"amount": 54.0
},
{
"customerName": "Daniel Jackson",
"date": "2023-01-23",
"amount": 515.0
},
{
"customerName": "Ethan Taylor",
"date": "2023-01-23",
"amount": 345.0
},
{
"customerName": "Emma Johnson",
"date": "2023-03-14",
"amount": 267.0
},
{
"customerName": "Michael Williams",
"date": "2023-01-23",
"amount": 237.0
},
{
"customerName": "James Miller",
"date": "2023-02-03",
"amount": 223.0
},
{
"customerName": "Olivia Brown",
"date": "2023-03-18",
"amount": 794.0
},
{
"customerName": "Evelyn Lopez",
"date": "2023-02-23",
"amount": 387.0
},
{
"customerName": "Emma Johnson",
"date": "2023-03-25",
"amount": 349.0
},
{
"customerName": "Harper Thompson",
"date": "2023-03-25",
"amount": 769.0
},
{
"customerName": "Isabella Martinez",
"date": "2023-01-10",
"amount": 547.0
},
{
"customerName": "Sophia Davis",
"date": "2023-01-23",
"amount": 235.0
},
{
"customerName": "Harper Thompson",
"date": "2023-01-29",
"amount": 711.0
},
{
"customerName": "Amelia Moore",
"date": "2023-03-16",
"amount": 112.0
},
{
"customerName": "Olivia Brown",
"date": "2023-02-17",
"amount": 208.0
}
]


