package testapi.l5;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class GlobalVariablesDemo extends BaseTest{

        @Test (groups = {"requiresSetup"})
    public void globalVariablesDemo(){
        RestAssured
            .given()
            .get()
            .then()
            .statusCode(200)
            .body("id[0]", Matchers.equalTo(1));
    }
    
    @Test (groups = {"requiresSetup"})
    public void globalVariablesOverrideDemo(){
        RestAssured
            .given()
            .get()
            .then()
            .statusCode(200)
            .rootPath("support")
            .body("sponsored_by", Matchers.equalTo("Clerk"));
    }

        @Test(groups = {"requiresSetup"})
    public void globalVariablesRemoveDemo(){
        RestAssured
            .given()
            .get()
            .then()
            .statusCode(200)
            .noRootPath()
            .body("page", Matchers.equalTo(1));
    }
}
