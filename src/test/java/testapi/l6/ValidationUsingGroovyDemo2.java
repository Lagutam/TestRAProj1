package testapi.l6;

import java.util.List;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class ValidationUsingGroovyDemo2 {
    
    static final String REPO_EP ="https://api.github.com/search/repositories?q=java";

    @Test 
    void checkLanguageUsingGroovy(){
        RestAssured
            .get(REPO_EP)
            .then()
            .body("items.findAll{it.language!='Java'}.size()", Matchers.equalTo(14));
    }

    @Test 
    void checkLanguageUsingJava(){
       List<String> result= RestAssured.get(REPO_EP).body().jsonPath().getList("items.language");

       var filtered = result.stream()
                            .filter(lang->!"Java".equalsIgnoreCase(lang))
                            .toList();
        Assert.assertEquals(filtered.size(), 14);
    }
}
