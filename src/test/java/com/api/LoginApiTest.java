package com.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.pojo.LoginPojo;
import com.utils.TestUtility;
import io.restassured.http.Header;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class LoginApiTest {
    LoginPojo lp;
@Test(description = "API Token Generation")
    public void generateToken() throws JsonProcessingException {
        baseURI = "http://139.59.91.96:9000";
        Header myHeader = new Header("Content-Type", "application/json");
        lp = new LoginPojo("iamfd", "password");
        String apiBody = TestUtility.convertToJson(lp);
        String token = given()
                .header(myHeader)
                .and()
                    .body(apiBody)
                    .log().all()
                .when()
                    .post("/v1/login")
                .then()
                    .log().all()
                .assertThat()
                    .statusCode(200)
                .and()
                    .body("message",containsString("Success"))
                .and()
                    .time(lessThan(2000L))
                    .extract().path("data.token");
        System.out.println(token);

    }
}
