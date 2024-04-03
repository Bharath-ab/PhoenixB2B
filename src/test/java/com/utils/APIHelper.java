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

    public Response makeRequest(HttpVerb httpVerb, String endpoint, Object... headerAndBody) {
        Response response = null;
        for (Object d : headerAndBody) {
            if (d instanceof Header) {
                requestHeader.add((Header) d);
            } else if (d instanceof IBody) {
                body = (IBody) d;
            }
        }
        baseURI = getBaseURL();
        if (HttpVerb.GET == httpVerb) {
            response = given().headers(new Headers(requestHeader)).body(body.toJson()).when().get(endpoint);
        } else if (HttpVerb.POST == httpVerb) {
            response = given().headers(new Headers(requestHeader)).body(body.toJson()).when().post(endpoint);
        } else if (HttpVerb.PUT == httpVerb) {
            response = given().headers(new Headers(requestHeader)).body(body.toJson()).when().put(endpoint);
        } else if (HttpVerb.DELETE == httpVerb) {
            response = given().headers(new Headers(requestHeader)).body(body.toJson()).when().delete(endpoint);
        }
        return response;
    }

}
