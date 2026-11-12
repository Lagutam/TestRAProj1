package testapi.m3;

import org.hamcrest.Matchers;
//import org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class ValidateRepeatedItems {
        public static final String USERS_EP = "https://reqres.in/api/users?page=1";

        @Test 
        void validateRepeatedItemsDemo(){
            RestAssured.get(USERS_EP)
                    .then()
//                    .body("data.id",Matchers.equalTo(1));
                    .body("data.id[0]", Matchers.equalTo(1))
                    .body("data.first_name[2]", Matchers.equalTo("Emma"))
                    .body("data.first_name[3]", Matchers.equalTo("Eve"))
//                    .body("data.first_name", Matchers.containsInAnyOrder("Emma", "Eve"))
                    .body("data.first_name", Matchers.hasItem("Eve"))
                    .body("data.first_name", Matchers.hasItems("Emma", "Eve"))
                    .body("data.first_name", Matchers.hasItem(Matchers.endsWith("ma")));
        }

}
