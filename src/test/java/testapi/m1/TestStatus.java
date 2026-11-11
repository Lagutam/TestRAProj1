package testapi.m1;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class TestStatus {

    public static final String BASE_URL = "https://api.github.com/";
    @Test 
    public void testAPIStatus(){
        RestAssured
            .get(BASE_URL)
            .then()
            .statusCode(200);
    }
}
