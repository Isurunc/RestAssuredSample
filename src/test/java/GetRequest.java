import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetRequest {

    @Test
    public void exampleTest() {
        given().
                log().all().
                when().
                get("http://zippopotam.us/us/90210").
                then().
                log().body().
                assertThat().
                body("places[0].'place name'", equalTo("Beverly Hills")).
                statusCode(200).
                contentType(ContentType.JSON);
    }
}
