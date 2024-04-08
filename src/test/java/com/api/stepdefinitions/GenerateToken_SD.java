package com.api.stepdefinitions;

import com.pojo.LoginPojo;
import com.utils.APIHelper;
import com.utils.HTTPVerb;
import com.utils.TestUtil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.Header;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.Assert;


public class GenerateToken_SD extends TestUtil {

    APIHelper helper;
    Response response;

    @Given("User Logged in with userName {string} and password {string}")
    public void userLoggedInWithUserNameAndPassword(String userName, String password) {
        helper = new APIHelper();
        response = helper
                .makeRequest(
                        HTTPVerb.POST, "/v1/login",
                        new Header("Content-Type", "application/json"),
                        new LoginPojo(userName, password)
                );
    }

    @Then("User generate Login Token")
    public void userGenerateLoginToken() {

        apiToken = response
                .then()
                .statusCode(200)
                .and()
                .body("message", Matchers.equalTo("Success"))
                .extract().path("data.token");
    }


    @Then("User get master Data")
    public void userGetMasterData() {
        helper = new APIHelper();
        response = helper
                .makeRequest(
                        HTTPVerb.POST, "/v1/master",
                        new Header("Content-Type", "application/json"),
                        new Header("Authorization", apiToken)
                );
        Assert.assertEquals(200, response.getStatusCode());
        TestUtil.masterAPIResponse = response.asString();
    }
}
