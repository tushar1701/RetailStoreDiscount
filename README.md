# Introduction: 
This project consists of RESTful services that implement a Retail Store Discounts that scans products and generates itemized bill.

It provides services for managing products and orders.  Products can be configured with rate and category (Groceries & Non Groceries). Discount is applied based on the following:
1.	If the user is an employee of the store, he gets a 30% discount
2.	If the user is an affiliate of the store, he gets a 10% discount
3.	If the user has been a customer for over 2 years, he gets a 5% discount.
4.	For every $100 on the bill, there would be a $ 5 discount (e.g. for $ 990, you get $ 45 as a discount). - This will be additional discount on total bill.
5.	The percentage based discounts do not apply on groceries. - For all non groceries & discount will be applicable and applied according to points 1,2 & 3
6.	A user can get only one of the percentage based discounts on a bill.

Bill details the products, quantity, total cost,discount and the total value of the bill.Data for 10 Products and 1 bill are added during startup to browse.

# REST endpoints
Client can add/update/modify products and orders using the REST endpoints.Below is overview of REST end points:

## Products
*  GET /products - fetches list of all product data
*  GET /products/{id} - fetch a specific product
*  POST /products/{custId} - Creates a new product based on request JSON
*  PUT /products/{id} - Updates product data based on request JSON
*  DELETE /products/{id} - Delete an existing product if it is not associated with a bill.


## Bills
*  GET /bills - fetches all bill data
*  GET /bills/{id} - fetches bill of a particular id
*  POST /bills - creates a bill Id. Client has to use this bill Id while adding and removing products
*  PUT /bills/{id} - Updates bill data. Client can add or remove products to bill sending a JSON request.
*  DELETE /bills/{id} - Delete bill from the system.

###NOTE
Customer ID should be of the following format:
		 * If you are an Employee   - EMP_DDMMYY
		 * If you are an Affiliate  - AFF_DDMMYY
		 * If you are a User        - <ALIAS>_DDMMYY
		 * <ALIAS> should be of 3 letter
		 * DDMMYY is the date on which bill is generated.
Cuatomer ID of any other format will throw internal server error 500.

Also for now point 3. If the user has been a customer for over 2 years, he gets a 5% discount is out of scope for this implementation. As I am currently using in memory Database which do not persist the data on session exit. However if we use some persistent database we an easily incorporate this point as well. 

 These REST end points are secured using basic authentication mechanism. Code uses in-memory repository with 'bob' as single user.

# About Implementation

This application has been using SpringBoot as it provides a wide variety of features that aid development and maintainence. Some features that were utilised were: Spring Security, Spring Data/JPA and starters.

This program and instructions have been tested on following versions on Windows laptop.
*  Apache Maven 3.5.0 
*  Java version: 1.8.0_131
*  git version 2.9.0.windows.1



# How to run the application locally?

Pre-requisites to run application are Java, Maven and Git. 
*  Installation instructions for Maven are available at https://maven.apache.org/install.html
*  Java can be installed from http://www.oracle.com/technetwork/java/javase/downloads/index.html
*  Latest Git version can be installed from https://git-scm.com/downloads

Steps to build and run locally:
* Open commandline
* Create a new directory called "retailstoreapp" 
* Clone repository using following command=>   git clone https://github.com/satishpeyyety/retailstore.git .
* Build the executable jar using maven=> mvn package  
* Go to eclipse => maven install
* Run spring boot main class RetailStoreApplication.java
* Optionally, one can configure port using commandline parameter => --server.port=9090 
* Access and invoke APIs using url => http://localhost:8080/swagger-ui.html
* Application will ask for authentication credentials during invocation of API's. Use 'bob' as user id and password.

This application uses H2 database and does not persist data on application restarts. 

