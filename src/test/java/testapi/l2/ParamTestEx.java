package testapi.l2;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class ParamTestEx {
    public static final String BASE_URL = "https://api.github.com/";
    public static final String REPO_URL = "https://api.github.com/repos";
    public static final String SEARCH_REPOS = "https://api.github.com/search/repositories";

    @DataProvider 
    public Object[][] queryParams(){
        return new Object[][]{
            {
                Map.of("q", "Java","per_page", "1"), 1
            },
            {
                Map.of("q", "Python","per_page", "5"), 5
            },
            {
                Map.of("q", "C#","per_page", "2"), 2
            }
        };
    }

    @Test(dataProvider="queryParams")
    void testDataDrivenTest(Map<String, String> params, int expectedRepoCount){
        var json = RestAssured.given()
                            .params(params)
                            .get(SEARCH_REPOS)
                            .jsonPath();

        Assert.assertEquals(json.getInt("items.size()"),expectedRepoCount);
    }
}
