package testapi.l4;

import org.testng.annotations.Test;

import config.ConfigReader;
import io.restassured.RestAssured;

public class PatchTest {
    private static final String PATCH_EP ="https://api.github.com/repos/Lagutam/generatedThroughScript";

    @Test 
    void patchTest(){
        RestAssured
                .given()
                    .header("Authorization", "Bearer "+ConfigReader.getToken())
                    .body("{\"name\": \"generatedThroughScript-Patched\"}")
                .when()
                    .patch(PATCH_EP)
                .then()
                    .statusCode(200);
    }

}
