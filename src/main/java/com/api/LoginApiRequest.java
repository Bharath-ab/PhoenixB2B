package com.api;

import io.restassured.http.Header;

import static io.restassured.RestAssured.*;

public class LoginApiRequest {
    public static String loginPojoBody = "{\"username\":\"iamfd\",\"password\":\"password\"}";

    public static void main(String[] args) {
        baseURI = "http://139.59.91.96:9000";
        Header h1 = new Header("Content-Type", "application/json");
        given().log().all()
                .header(h1)
                .and()
                .body(loginPojoBody)
                .log()
                .all()
                .post("/v1/login")
                .then()
                .statusCode(200)
                .log().all();
    }
}

