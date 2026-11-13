package testapi.l5;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static util.RequestSpec.*;

public class RequestSpecsDemo extends BaseTest {

    @Test 
    void requestSpecsDemo(){
        RestAssured
            .given()
                //.spec(reqSpec)
                .spec(getRequestSpecification())
            .when()
                .get()
            .then()
                .statusCode(200);
    }
    
}
