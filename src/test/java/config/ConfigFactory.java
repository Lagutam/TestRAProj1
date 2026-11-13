package config;

import io.restassured.RestAssured;
import io.restassured.config.FailureConfig;
import io.restassured.config.RedirectConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.listener.ResponseValidationFailureListener;

public class ConfigFactory {
    
    public static RestAssuredConfig getDefaultConfig(){
        ResponseValidationFailureListener onFailure = (reqSpec, resSpec, response) -> {
            System.out.printf("We have a failure, the response status is %s, and response body is %s", response.statusCode(), response.getBody().prettyPrint());
        };

        return RestAssured.config()
        .redirect(RedirectConfig.redirectConfig().maxRedirects(1))
        .failureConfig(FailureConfig.failureConfig().failureListeners(onFailure));
    }
}
