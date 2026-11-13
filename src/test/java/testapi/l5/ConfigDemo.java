package testapi.l5;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.config.FailureConfig;
import io.restassured.filter.log.LogDetail;
import io.restassured.listener.ResponseValidationFailureListener;

public class ConfigDemo {
    static final String BASE_EP ="https://api.github.com/";

    @Test 
    void configDemo(){
        ResponseValidationFailureListener onFailure = (reqSpec, resSpec, response) ->{
            System.out.printf("We have a failure and the response body is %s, and the response status is %s", response.getBody().prettyPrint(), response.getStatusCode());
        };

        RestAssured.config = RestAssured.config()
                .failureConfig(FailureConfig.failureConfig()
                        .failureListeners(onFailure));

        //RestAssured.config = failureConfig;

        RestAssured
            .given()
                //.log().all()
                .log().headers()
            .when()
                .get(BASE_EP+"users/Lagutam")
            .then()
                .log().ifValidationFails(LogDetail.URI)
                .body("some.path", Matchers.equalTo("thing"));
    }
}
