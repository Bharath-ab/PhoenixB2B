package com.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.utils.APIHelper;
import com.utils.HTTPVerb;
import com.utils.Role;
import com.utils.TestUtility;
import io.restassured.http.Header;
import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class UserDetailsTest {

    String apiToken;
    String apiBody;
    Response response;
    @BeforeTest(description = "Generate API Token to Authenticate")
    public void generateToken() throws JsonProcessingException {
        apiToken = TestUtility.generateTokenFor(Role.FD);
        apiBody = TestUtility.generateCreateJobData();
    }

    @Test(description = "Get User Details for Logged in User")
    public void getUserDetails(){
        APIHelper helper = new APIHelper();
        Header myHeader = new Header("Content-Type", "application/json");
        Header authorization = new Header("Authorization",apiToken);
        response =helper.makeAPIRequest("/v1/userdetails","", HTTPVerb.GET,myHeader,authorization);
        response.then().log().all();
    }
}
