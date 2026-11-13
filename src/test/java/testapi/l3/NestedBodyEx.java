package testapi.l3;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class NestedBodyEx {
    
    public static final String LIMIT_EP = "https://api.github.com/rate_limit";

    @Test 
    void nestedBodyValidationDemo(){
        RestAssured
            .given()
                .get(LIMIT_EP)
            .then()
                .rootPath("resources.core")
                    .body("limit", Matchers.equalTo(60))
                    .body("remaining", Matchers.equalTo(60))
                    .body("reset", Matchers.notNullValue())
                .rootPath("resources.search")
                    .body("limit", Matchers.equalTo(10))
                    .body("remaining", Matchers.lessThanOrEqualTo(10))
                .noRootPath()
                    .body("resources.core.limit", Matchers.equalTo(60));
    }

}
