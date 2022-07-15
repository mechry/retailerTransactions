# retailerTransactions 
SPRING BOOT APPLICATION donne with Eclips, Maven and Spring Tool 4

To test this you need rest Api client like : HTTPie, Postman REST Client or ARC

In this Application we have 

4 POST :

http://localhost:8080/addRewardType to add one Reward point Type (100, 2) and (50, 1)

http://localhost:8080/addManyRewardTypes   to add many

http://localhost:8080/rewardType/100 To get one Reward point Type.

here the result will be :

{
"purchaseLimit": 100,
"rewardPoint": 2
}

