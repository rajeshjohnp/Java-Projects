# Java-Projects

1. Download the zip file. (SpringBootBankingApplication.zip file)
2. Extract the contents and import to Eclipse as a Maven project
3. After getting all the dependencies and build completed, run the springboot application.
4. 
4. The properties specified in the application.properties will connect to the H2 database (in memeory DB)
5. Go to the browser URL : http://localhost:8080/customers will display an empty array initially
6. Go to Postman and POST the below JSON to the above URL,

{
    "customerId": "10002",
    "firstName": "James",
    "lastName": "Alex",
    "address": "Main St.",
    "phoneNo": "1010000110",
    "ssn": "1000000000",
    "accounts" : [
        {
        "accountId" : "1000001",
        "accountType" : "Savings",
        "amount" : "1000"
        },
        {
        "accountId" : "1000002",
        "accountType" : "Checking",
        "amount" : "2000"
        }
    ]
}

7. The data will get created in the H2 database with Customer and Account tables with the provided values
8. Query the URL again or you will be able to see the data in the browser.(http://localhost:8080/customers)
9. You can also check the H2 database in memory database)
9. Go to the browser URL: http://localhost:8080/transferAcct1ToAcct2?id=10002&srcAcctId=1000001&tgtAcctId=1000002&trnfrAmount=100
10. The browser will display the account details with the specified transferred amount reflecting for both the accounts.