package com.api.stepdefinitions;

import com.pojo.LoginPojo;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;

import static io.restassured.RestAssured.*;

public class Login_SD {
    Response response;
    RequestSpecification request;


    @Given("the baseurl of the backend app is {string}")
    public void theBaseurlOfTheBackendAppIs(String url) {
        baseURI = url;
    }

    @And("the header passed is {string}  {string}")
    public void theHeaderPassedIs(String name, String value) {
        request = given().header("Content-Type", "application/json");
    }

    @And("the user credentials are {string} {string}")
    public void theUserCredentialsAre(String userName, String password) {
        LoginPojo loginPojo = new LoginPojo(userName, password);
        request.body(loginPojo.toJson());

    }

    @When("I make a POST api request to the endpoint {string}")
    public void iMakeAPOSTApiRequestToTheEndpoint(String endPoint) {
        response = request.post(endPoint);

    }

    @Then("the status code needs to be {int}")
    public void theStatusCodeNeedsToBe(int statusCode) {
        response.then().log().all().assertThat().statusCode(statusCode);
    }

    @And("the response time should be less {int} ms")
    public void theResponseTimeShouldBeLessMs(int time) {
        response.then().assertThat().time(Matchers.lessThan((long) time));
    }

    @And("the response body should contain message as {string}")
    public void theResponseBodyShouldContainMessageAs(String value) {
        response.then().assertThat().body("message", Matchers.equalTo(value));
    }

    @And("a token should be generated")
    public void aTokenShouldBeGenerated() {
        response.then().assertThat().body("data.token", Matchers.notNullValue());
    }

    @And("the response body should be a json body")
    public void theResponseBodyShouldBeAJsonBody() {
        response.then().assertThat().headers("content-type", "application/json; charset=utf-8");
    }
}
