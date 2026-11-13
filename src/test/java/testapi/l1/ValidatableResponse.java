package testapi.l1;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class ValidatableResponse {

    public static final String BASE_URL = "https://api.github.com/";

    @Test
    void basicValidatableResponse(){
        RestAssured
            .get(BASE_URL)
            .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .header("X-RateLimit-Limit", "60");
    }

    
}
