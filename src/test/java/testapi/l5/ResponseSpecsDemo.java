package testapi.l5;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.filter.log.LogDetail;
import static util.ResponseSpec.*;

public class ResponseSpecsDemo extends BaseTest {

    @Test 
    void responseSpecsDemo(){
        RestAssured
            .given()   
                .spec(reqSpec)
                .log().all()
                .log().headers()
                .log().body()
            .when()
                .get()
            .then()
                .log().headers()
                .log().ifValidationFails(LogDetail.ALL)
                //.spec(resSpec)
                .spec(getResponseSpecification());
    }
    
}
