package testapi.l6;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class JsonSchemaValidationDemo {
    static final String POSTS_EP ="https://jsonplaceholder.typicode.com/posts/1";

    @Test 
    void basicJsonSchemaValidation_1(){
        RestAssured
            .get(POSTS_EP)
            .then()
                .body(matchesJsonSchemaInClasspath("basicSchema.json"));
    }
}
