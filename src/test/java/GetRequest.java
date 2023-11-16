import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

public class GetRequest {

    @Test
    public void MainTest() {
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

    @Test
    public void Hamcrest_checkStateNameInResponseBody_equalTo() {

        given().
                when().
                get("http://zippopotam.us/us/90210").
                then().
                assertThat().
                body("places[0].state", equalTo("California"));
    }

    //Negative test
    @Test
    public void Hamcrest_checkStateNameInResponseBody_equalToNegative() {

        given().
                when().
                get("http://zippopotam.us/US/90210").
                then().
                assertThat().
                body("places[0].state", equalTo("CA"));
    }

    @Test
    public void requestUsZipCode90210_hasItem() {

        given().
                when().
                get("http://zippopotam.us/us/90210").
                then().
                assertThat().
                body("places.'place name'", hasItem("Beverly Hills"));
    }


    @Test
    public void requestUsZipCode90210_hasSize() {

        given().
                when().
                get("http://zippopotam.us/us/90210").
                then().
                assertThat().
                body("places.'place name'", hasSize(1));
    }


}
