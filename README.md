# retailerTransactions 
SPRING BOOT APPLICATION donne with Eclips, Maven and Spring Tool 4

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

ex : 
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

http://localhost:8080/addCustomerTransaction Add one record purchase history

ex :
 {
    "transDate": "2021-11-30",
    "customerId": "CustomerA",
    "amount": 500
  }

http://localhost:8080/addManyCustomerTransactions Add many records purchase history

exmple used for testing :

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


# 4 GET :

http://localhost:8080/rewardType/100 To get one Reward point Type.

http://localhost:8080/addManyRewardTypes To get all Reward point Type.

# calculate the reward points earned for each customer per month 

http://localhost:8080/rewardPEPerCustomerForOneMonth .

# calculate the total per customer

http://localhost:8080/totalRPEPerCustomerForLast3Months 
