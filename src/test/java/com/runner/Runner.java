package com.runner;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.pojo.LoginPojo;
import com.pojo.frontdesk.*;
import com.utils.TestUtility;

import java.util.ArrayList;

public class Runner {
    public static void main(String[] args) throws JsonProcessingException {
        LoginPojo lp = new LoginPojo("iamfd","password");
        System.out.println(lp);
        System.out.println(lp.toJson());
        CustomerAddress ca = new CustomerAddress("1","1","1","1","1","1","1","1");
        CustomerProductDetails cp = new CustomerProductDetails("2023-10-30T18:30:00.000Z","1","1","1","2023-10-30T18:30:00.000Z",3,3);
        CustomerDetails c = new CustomerDetails("1","1","1","1","1","1");
        ArrayList<Object> problems = new ArrayList<>();
        Problem pb = new Problem(2,"Test");
        Problem pb1 = new Problem(1,"Test");
        Problem pb2 = new Problem(1,"Test");
        Problem pb3 = new Problem(1,"Test");
        problems.add(pb.getProblem());
        problems.add(pb1.getProblem());
        problems.add(pb2.getProblem());
        problems.add(pb3.getProblem());
        CreateRepairJobPojo cjp = new CreateRepairJobPojo(0,2,1,2,c,ca,cp,problems);
        System.out.println(cjp.toJson());
        System.out.println(TestUtility.generateISODate());
        System.out.println(TestUtility.generateCreateJobData());

    }
}
