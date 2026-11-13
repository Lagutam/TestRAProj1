package testapi.l4;

import org.testng.annotations.Test;

import config.ConfigReader;
import io.restassured.RestAssured;

public class DeleteTest {
        private static final String REPO_EP ="https://api.github.com/repos/Lagutam/generatedThroughScript-Patched";

        @Test 
        void deleteTest(){
            RestAssured
                .given()
                    .header("Authorization", "Bearer "+ConfigReader.getToken())
                .when()
                    .delete(REPO_EP)
                .then()
                    .statusCode(204);
        }


}
