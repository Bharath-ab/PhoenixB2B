package com.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.utils.Role;
import com.utils.TestUtility;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.lessThan;

public class CreateJobTest {

    String apiToken;
    String apiBody;
    @BeforeTest(description = "Generate API Token to Authenticate")
    public void generateToken() throws JsonProcessingException {
        apiToken = TestUtility.generateTokenFor(Role.FD);
        apiBody = TestUtility.generateCreateJobData();
    }

    @Test(description = "Create Repair Job")
    public void createJob(){
        baseURI = "http://139.59.91.96:9000";
        Header myHeader = new Header("Content-Type", "application/json");
        Header myHeader2 = new Header("Authorization",apiToken);
        Headers apiHeaders = new Headers(myHeader,myHeader2);
            given()
                .headers(apiHeaders)
                .and()
                .body(apiBody)
                .log().all()
                .when()
                .post("/v1/job/create")
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .and()
                .body("message",containsString("Job created successfully"))
                .and()
                .time(lessThan(2000L));
    }
}
