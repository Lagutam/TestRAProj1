package testapi.l1;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class HamcrestmatcherEx {
    public static final String BASE_URL = "https://api.github.com/";
    
    @Test 
    void hamcrestMatcherEx(){
        RestAssured
            .get(BASE_URL)
            .then()
                .statusCode(200)
                .statusCode(Matchers.lessThan(300))
                .header("cache-control", Matchers.containsStringIgnoringCase("max-age=60"))
                .time(Matchers.lessThan(2L),TimeUnit.SECONDS)
                .header("etag", Matchers.notNullValue())
                .header("etag", Matchers.not(Matchers.emptyString()));

    }

    @Test 
    void matchersHeadersUsingMaps(){
        Map<String, String> expectedHeaders = Map.of("Content-Encoding", "gzip",
                                               "Access-Control-Allow-Origin", "*",
                                            "X-RateLimit-Limit", "60",
                                        "Server", "github.com"); 

        RestAssured.get(BASE_URL)
                    .then()
                        .statusCode(200)
                        .header("Content-Type", Matchers.equalTo("application/json; charset=utf-8"))
                        .headers("X-Frame-Options", "deny", "X-Content-Type-Options", "nosniff")
                        .headers(expectedHeaders);
    }
}
