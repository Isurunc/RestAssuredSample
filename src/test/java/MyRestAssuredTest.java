import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class MyRestAssuredTest {

    @Test
    public void exampleTest() {
        // Specify the base URI of the API
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        // Perform a GET request and validate the response
        RestAssured.given()
                .when()
                .get("/posts/1")
                .then()
                .statusCode(200);
    }
}
