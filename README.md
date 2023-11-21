# RestAssuredSample
Practice Rest Assured with TestNG

# Theory

RequestSpecification:
* RequestSpecification is used to define the details of an HTTP request before it is sent. It allows you to specify things like request method, headers, parameters, authentication, and other details.


ResponseSpecification:
* ResponseSpecification is used to define the expected details of an HTTP response. It allows you to specify things like expected status codes, headers, and response body details.
* When you create a ResponseSpecification object, you can use it to validate the actual response against your expectations.


Example :

RequestSpecification requestSpec = given()
.baseUri("https://api.example.com")
.header("Authorization", "Bearer myAccessToken")
.param("key", "value");

ResponseSpecification responseSpec = expect()
.statusCode(200)
.contentType(ContentType.JSON)
.body("key", equalTo("expectedValue"));

given()
.spec(requestSpec)
.when()
.get("/endpoint")
.then()
.spec(responseSpec);


