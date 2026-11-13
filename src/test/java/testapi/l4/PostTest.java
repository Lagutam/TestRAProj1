package testapi.l4;

import org.testng.annotations.Test;

import config.ConfigReader;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PostTest {
    private static final String REPO_EP ="https://api.github.com/user/repos";
    

    @Test 
    void postTest(){
        String token =ConfigReader.getToken();
        RestAssured
            .given()
                .header("Authorization", "Bearer "+token)
                .contentType(ContentType.JSON)
               .body("{\"name\":\"generatedThroughScript\"}")
                .log().all()
            .when()
                .post(REPO_EP)
            .then()
                .log().all()
                .statusCode(201);
    }

}
