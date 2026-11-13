package testapi.l3;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class BasicResponseBody {
    public static final String LIMIT_EP = "https://api.github.com/rate_limit";

    @Test 
    void jsonPathReturnsMap(){
        Response response = RestAssured.get(LIMIT_EP);
        ResponseBody<?> body = response.getBody();

        JsonPath jsonPath = body.jsonPath();

        JsonPath jsonPath2 = response.body().jsonPath();

        Map<String, String> fullJson  = jsonPath.get();
        Map<String, String> subMap = jsonPath2.get("resources");
        Map<String, String> subMap2 = jsonPath2.get("resources.core");

        int value = jsonPath2.get("resources.core.limit");
        int value2 =jsonPath2.get("resources.core.remaining");

        System.out.println(fullJson);
        System.out.println(subMap);
        System.out.println(subMap2);
        System.out.println(value);
        System.out.println(value2);
    }
}
