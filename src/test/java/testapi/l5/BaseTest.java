package testapi.l5;

import org.hamcrest.Matchers;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import config.ConfigFactory;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class BaseTest {

    private static final String BASE_EP ="https://api.github.com/";

    RequestSpecification reqSpec = new RequestSpecBuilder().setBaseUri(BASE_EP).build();

    ResponseSpecification resSpec = new ResponseSpecBuilder()
                                        .expectStatusCode(200)
                                        .expectContentType(ContentType.JSON)
                                        .expectBody(Matchers.notNullValue())
                                        .build();

    @BeforeSuite 
    void suiteSetup(){
        RestAssured.config = ConfigFactory.getDefaultConfig();
    }
    
    @BeforeMethod(onlyForGroups = {"requiresSetup"})
    public void setUp(){
        RestAssured.baseURI ="https://reqres.in/";
        RestAssured.basePath ="api/users";
        RestAssured.rootPath ="data";
    }

    @AfterMethod(onlyForGroups = {"requiresSetup"})
    public void cleanUp(){
        RestAssured.baseURI =null;
        RestAssured.basePath =null;
        RestAssured.rootPath =null;
    }
}
