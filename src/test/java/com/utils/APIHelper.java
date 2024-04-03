package com.utils;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import java.util.ArrayList;
import java.util.List;
import static com.utils.TestUtil.getBaseURL;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class APIHelper {
    List<Header> requestHeader = new ArrayList<>();
    IBody body;

    public Response makeRequest(HTTPVerb httpVerb, String endpoint, Object... headerAndBody) {
        Response response = null;
        for (Object d : headerAndBody) {
            if (d instanceof Header) {
                requestHeader.add((Header) d);
            } else if (d instanceof IBody) {
                body = (IBody) d;
            }
        }
        baseURI = getBaseURL();
        if (HTTPVerb.GET == httpVerb) {
            response = given().headers(new Headers(requestHeader)).body(body.toJson()).when().get(endpoint);
        } else if (HTTPVerb.POST == httpVerb) {
            response = given().headers(new Headers(requestHeader)).body(body.toJson()).when().post(endpoint);
        } else if (HTTPVerb.PUT == httpVerb) {
            response = given().headers(new Headers(requestHeader)).body(body.toJson()).when().put(endpoint);
        } else if (HTTPVerb.DELETE == httpVerb) {
            response = given().headers(new Headers(requestHeader)).body(body.toJson()).when().delete(endpoint);
        }
        return response;
    }

}
