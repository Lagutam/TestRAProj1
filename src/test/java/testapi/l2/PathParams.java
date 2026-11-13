package testapi.l2;

import java.util.Map;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class PathParams {
    public static final String BASE_URL = "https://api.github.com/";
    public static final String REPO_URL = "https://api.github.com/repos";

    @Test 
    void testWIthPathParam(){
        RestAssured
                .given()
                .pathParam("user", "Lagutam")
                .pathParam("repo_name", "OpenCartV1")
                .get(REPO_URL+"/{user}/{repo_name}")
                .then()
                .statusCode(200)
                .body("id", Matchers.equalTo(977449374));


    }

    @Test void testWIthPathParamAsMap(){
        Map<String, String> pathParamMap = Map.of("user", "Lagutam", "repo_name","TestWebAuto1" );

        RestAssured
            .given()
            .pathParams(pathParamMap)
            .get(REPO_URL+"/{user}/{repo_name}")
            .then()
            .statusCode(200)
            .body("id", Matchers.equalTo(1286008375));
    }
}
