package testapi.l5;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.hamcrest.Matchers;
import org.hamcrest.number.OrderingComparison;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class HamcrestmatchersFuncDemo {
    static final String URL ="https://api.github.com/rate_limit";

    @Test 
    void complexHamcrestMatchersHeaders1(){
        RestAssured
            .get(URL)
           .then()
            .header("x-ratelimit-limit", Matchers.equalTo("60"))
            .header("x-ratelimit-limit", s->Integer.parseInt(s), Matchers.equalTo(60))
            .header("x-ratelimit-limit", Integer::parseInt,Matchers.equalTo(60));
    }

    @Test 
    void complexHamcrestMatchersHeaders2(){
        RestAssured
            .get(URL)
            .then()
                .header("date", 
                date-> LocalDate.parse(date, DateTimeFormatter.RFC_1123_DATE_TIME)
                , OrderingComparison.comparesEqualTo(LocalDate.now()));
    }

    @Test 
    void complexHamcrestMatchersHeaders3(){
        RestAssured
            .get(URL)
            .then()
                .header("x-ratelimit-limit"
                ,response->Matchers.greaterThanOrEqualTo(response.header("x-ratelimit-remaining")));
    }
}
