package com.bharath.utils;

import com.bharath.pojo.LoginPojo;
import com.fasterxml.jackson.core.JsonProcessingException;

public class Runner {
    public static void main(String[] args) throws JsonProcessingException {
        LoginPojo lp = new LoginPojo("iamfd","password");
        System.out.println(lp);
        System.out.println(lp.toJson());
    }
}
