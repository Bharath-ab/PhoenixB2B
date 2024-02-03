package com.runner;

import com.api.LoginApiTest;
import com.fasterxml.jackson.core.JsonProcessingException;

public class Runner {
    public static void main(String[] args) throws JsonProcessingException {
        LoginApiTest la = new LoginApiTest();
        la.generateToken();
    }
}
