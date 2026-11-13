package testapi.l2;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class ParamsEx {
    public static final String BASE_URL = "https://api.github.com/";
    public static final String REPO_URL = "https://api.github.com/repos";
    public static final String SEARCH_REPOS = "https://api.github.com/search/repositories";

    @Test 
    void withoutParams(){
        RestAssured
        .get(SEARCH_REPOS+"?q=java&per_page=1")
        .prettyPeek()
        .then()
        .statusCode(200);
    }

    @Test 
    void withParams(){
        RestAssured
            .given()
            .param("q", "Java")
            .param("per_page", "5")
            .get(SEARCH_REPOS)
            .then()
            .statusCode(200);
    }

    @Test 
    void withParamsAsMap(){
        Map<String, String> paramMap = Map.of("q", "Java","per_page", "5" );

        RestAssured
        .given()
        .params(paramMap)
        .get(SEARCH_REPOS)
        .then()
        .statusCode(200);
    }
    
}
