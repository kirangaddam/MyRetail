#MyRetail services to perform GET and PUT requests.
.Spring 4
.Maven
.Apache tomcat 8
.jUnit
.Swagger

Services URL: http://localhost:8080/MyRetail/
Swagger : http://localhost:8080/MyRetail/swagger-ui.html
Default API docs: http://localhost:8080/MyRetail/v2/api-docs

#Mongo DB Details:
database name: mydb
collection name: product

*** Please execute ProductControllerTest.Java -> createProducts() to insert initial set of products to Mongo DB***

#Sample collection
db.product.find()
{ "_id" : NumberLong(13860428), "_class" : "com.myRetail.model.ProductModel", "price" : "20.5", "currencyCode" : "USD" }
{ "_id" : NumberLong(13860429), "_class" : "com.myRetail.model.ProductModel", "price" : "10.5", "currencyCode" : "USD" }
{ "_id" : NumberLong(13860430), "_class" : "com.myRetail.model.ProductModel", "price" : "11.5", "currencyCode" : "USD" }
{ "_id" : NumberLong(13860431), "_class" : "com.myRetail.model.ProductModel", "price" : "12.5", "currencyCode" : "USD" }
{ "_id" : NumberLong(13860432), "_class" : "com.myRetail.model.ProductModel", "price" : "13.5", "currencyCode" : "USD" }