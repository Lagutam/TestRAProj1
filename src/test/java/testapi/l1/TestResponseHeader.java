package testapi.l1;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class TestResponseHeader {
    public static final String BASE_URL = "https://api.github.com/";

    @Test 
    void testConvenienceMethods(){
        Response response = RestAssured
                                .get(BASE_URL);

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.contentType(), "application/json; charset=utf-8");
    }

    @Test 
    void genericHeader(){
        Response response = RestAssured.get(BASE_URL);

        System.out.println(response.getHeaders());

        Assert.assertEquals(response.getHeader("server"), "github.com");
        Assert.assertEquals(response.getHeader("X-RateLimit-Limit"), "60");
        Assert.assertEquals(Integer.parseInt(response.getHeader("X-RateLimit-Limit")), 60);
    }

    @Test 
    void testGenericHeader(){

        Response response = RestAssured.get(BASE_URL);

        Headers header = response.headers();

        String val = response.getHeader("eTag");
        List<Header> list = header.asList();

        System.out.println("ETag: "+val);
        System.out.println("No. of Headers: "+list.size());

        Assert.assertTrue(header.hasHeaderWithName("Referrer-Policy"));   
    }

    @Test 
    void getResponseTime(){
        Response response = RestAssured.get(BASE_URL);

        System.out.println(response.getTime());
        System.out.println(response.getTimeIn(TimeUnit.SECONDS));
    }

}
