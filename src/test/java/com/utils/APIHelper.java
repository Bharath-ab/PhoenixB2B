package com.utils;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import java.util.ArrayList;
import java.util.Arrays;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class APIHelper {
    public Response makeAPIRequest(String endPoint, String apiBody, HTTPVerb apiAction, Header... header) {
        Response response = null;
        baseURI = "http://139.59.91.96:9000";
        ArrayList<Header> apiHeader = new ArrayList<>(Arrays.asList(header));
        Headers myHeaders = new Headers(apiHeader);
        System.out.println(myHeaders);
        if (apiAction == HTTPVerb.GET) {
            response = given()
                    .headers(myHeaders)
                    .and()
                    .log().all()
                    .when()
                    .get(endPoint);
        } else if (apiAction == HTTPVerb.POST) {
            response = given()
                    .headers(myHeaders)
                    .and()
                    .body(apiBody)
                    .log().all()
                    .when()
                    .post(endPoint);
        } else if (apiAction == HTTPVerb.DELETE) {

        } else if (apiAction == HTTPVerb.PUT) {

        } else {
            System.out.println("Please Use Valid API Action GET,POST,DELETE,PUT");
        }
        return response;
    }
}
