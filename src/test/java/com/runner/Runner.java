package com.runner;

import com.api.LoginApiTest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.utils.APIHelper;
import com.utils.HTTPVerb;
import io.restassured.http.Header;
import io.restassured.response.Response;

public class Runner {
    public static void main(String[] args) throws JsonProcessingException {
        LoginApiTest la = new LoginApiTest();
        la.generateToken();
        Header myHeader = new Header("Content-Type", "application/json");
        Header myHeader2 = new Header("Authorization","abcd");
        APIHelper helper = new APIHelper();
        Response response = helper.makeAPIRequest("/v1/cat","sdsd", HTTPVerb.GET,myHeader,myHeader2);
    }
}
