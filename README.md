# retailerTransactions 
SPRING BOOT APPLICATION donne with Eclips, Maven and Spring Tool 4, H2 DB

To test this you need rest Api client like : HTTPie, Postman REST Client or ARC

In this Application we have 

# 4 POST :

http://localhost:8080/addRewardType to add one Reward point Type (100, 2) and (50, 1)

 ex : 
{
    "purchaseLimit":50,
	"rewardPoint":1
}

http://localhost:8080/addManyRewardTypes   to add many Reward point Type

http://localhost:8080/addCustomerTransaction Add one record purchase history

ex :
 {
    "transDate": "2021-11-30",
    "customerId": "CustomerA",
    "amount": 500
  }

http://localhost:8080/addManyCustomerTransactions Add many records purchase history


# 4 GET :

http://localhost:8080/rewardType/100 To get one Reward point Type.

http://localhost:8080/addManyRewardTypes To get all Reward point Type.

# calculate the reward points earned for each customer per month 

http://localhost:8080/rewardPEPerCustomerForOneMonth .

# calculate the total per customer

http://localhost:8080/totalRPEPerCustomerForLast3Months 

# Senario For testing 

Afer runing the aplication with eclipse or any other IDE, Then Open your rest Api client 


# First :  run http://localhost:8080/addManyRewardTypes 

for adding all avlaibel :

[
{
    "purchaseLimit":50,
	"rewardPoint":1
}
,
{
   "purchaseLimit":100,
   "rewardPoint":2
}
]

# And Then run http://localhost:8080/addManyCustomerTransactions

[
  {
    "transDate": "2021-11-30",
    "customerId": "CustomerA",
    "amount": 500
  },
  {
    "transDate": "2022-04-25",
    "customerId": "CustomerA",
    "amount": 90
  },
  {
    "transDate": "2022-06-15",
    "customerId": "CustomerA",
    "amount": 8200
  },
  {
    "transDate": "2022-05-30",
    "customerId": "CustomerA",
    "amount": 1200
  },
  {
    "transDate": "2022-05-30",
    "customerId": "CustomerA",
    "amount": 1200
  },
  {
    "transDate": "2022-06-30",
    "customerId": "CustomerB",
    "amount": 120
  },
  {
    "transDate": "2022-06-10",
    "customerId": "CustomerB",
    "amount": 180
  },
  {
    "transDate": "2022-05-17",
    "customerId": "CustomerB",
    "amount": 80
  },
  {
    "transDate": "2022-04-27",
    "customerId": "CustomerB",
    "amount": 800
  },
  {
    "transDate": "2022-05-20",
    "customerId": "CustomerC",
    "amount": 180
  },
  {
    "transDate": "2022-05-31",
    "customerId": "CustomerC",
    "amount": 230
  },
  {
    "transDate": "2022-04-28",
    "customerId": "CustomerC",
    "amount": 60
  },
  {
    "transDate": "2022-06-28",
    "customerId": "CustomerC",
    "amount": 110
  },
  {
    "transDate": "2022-07-14",
    "customerId": "CustomerC",
    "amount": 40
  }
]

Optional : you can check if every recor in the DB with  this link http://localhost:8080/h2Db-ui

# To get suspected result, go to the two endpoits

#1
For http://localhost:8080/rewardPEPerCustomerForOneMonth 

The output :

{
"CustomerA": {
"2022-04": 40,
"2022-05": 4500,
"2022-06": 16250
},

"CustomerB": {
"2022-04": 1450,
"2022-05": 30,
"2022-06": 300
},

"CustomerC": {
"2022-04": 10,
"2022-05": 520,
"2022-06": 70,
"2022-07": 0
}

}

#2
For http://localhost:8080/totalRPEPerCustomerForLast3Months 

The output:

{
"CustomerA": 20790,
"CustomerB": 1780,
"CustomerC": 600
}
