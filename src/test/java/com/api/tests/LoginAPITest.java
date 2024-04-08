package com.api.tests;

import com.pojo.LoginPojo;
import com.utils.APIHelper;
import com.utils.HTTPVerb;
import io.restassured.http.Header;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class LoginAPITest {
    APIHelper helper;
    Response response;
    String apiToken;

    @Test()
    @DisplayName("To Test Login API of Phoenix App")
    public void loginAPI() {
        helper = new APIHelper();
        response = helper
                .makeRequest(
                        HTTPVerb.POST, "/v1/login",
                        new Header("Content-Type", "application/json"),
                        new LoginPojo("iamfd", "password")
                );
        apiToken = response
                .then()
                .statusCode(200)
                .and()
                .body("message", Matchers.equalTo("Success"))
                .extract().path("data.token");
    }

}
