package util;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class RequestSpec {
    private static final String BASE_EP ="https://api.github.com/";

    
    public static RequestSpecification getRequestSpecification(){
        return new RequestSpecBuilder().setBaseUri(BASE_EP).build();
    }
}
