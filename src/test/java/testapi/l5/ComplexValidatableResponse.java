package testapi.l5;

import org.hamcrest.Matchers;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ComplexValidatableResponse extends BaseTest {
    
    @Test 
    void complexValidatableResponse1(){

        Response resp = RestAssured
                                .given()
                                .spec(reqSpec)
                                .get("/users/Lagutam");

            System.out.println(resp.body().jsonPath().getString("login"));
       
       RestAssured
        .given()
            .spec(reqSpec)
        .get("/users/Lagutam")
        .then()
            .body("url", response-> Matchers.endsWith(response.body().jsonPath().get("login")));
   }

   @Test(dataProvider = "userList")
   void complexValidatableResponse(String user){
    RestAssured
        .given()
            .spec(reqSpec)
        .get("users/"+user)
        .then()
            .body("url"
            ,response->Matchers.endsWith(response.body().jsonPath().get("login")));
   }

   @DataProvider
   Object[][] userList(){
    return new Object[][]{
        {"Lagutam"}
        ,{"RestAssured"}
        };
    }
}
