package org.example;

import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class ExtractExample {

    @Test
    public void extractExample() {
        Response response = given()
                .when()
                .get("https://jsonplaceholder.typicode.com/posts/2")
                .then()
                .statusCode(200)
                .body("userId", equalTo(1))
                .extract().response();

        // Extracting the response body as a String
        String responseBody = response.getBody().asString();
        System.out.println("ResponseBody:  " + responseBody);

        // Extracting a specific value using JSONPath
        String title = response.path("title");
        System.out.println("Title: " + title);

    }
}
