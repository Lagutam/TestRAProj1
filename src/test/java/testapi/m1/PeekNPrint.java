package testapi.m1;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class PeekNPrint {
    public static final String BASE_URL = "https://api.github.com/";

    @Test 
    void testPeek(){
        RestAssured
            .get(BASE_URL)
            .peek();
    }

    @Test 
    void testPrettyPeek(){
        RestAssured
            .get(BASE_URL)
            .prettyPeek();
    }

        @Test 
    void testPrint(){
        RestAssured
            .get(BASE_URL)
            .print();
    }

    @Test 
    void testPrettyPrint(){
        RestAssured
            .get(BASE_URL)
            .prettyPrint();
    }

}
