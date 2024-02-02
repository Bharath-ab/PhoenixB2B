package com.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.utils.Role;
import com.utils.TestUtility;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CreateJobTest {

    String apiToken;
    @BeforeTest(description = "Generate API Token to Authenticate")
    public void generateToken() throws JsonProcessingException {
        apiToken = TestUtility.generateTokenFor(Role.FD);
    }

    @Test(description = "Create Repair Job")
    public void createJob(){

    }
}
