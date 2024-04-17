package com.api.tests;

import com.pojo.CreateRepairJobPojo;
import com.utils.APIHelper;
import com.utils.GenerateAPIData;
import com.utils.HTTPVerb;
import com.utils.Role;
import io.restassured.http.Header;
import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.Matchers.lessThan;

public class CreateRepairJobTest {
    String apiToken;
    CreateRepairJobPojo apiBody;
    @BeforeTest(description = "Generate API Token to Authenticate")
    public void generateToken()  {
        apiToken = GenerateAPIData.generateTokenFor(Role.FD);
        apiBody = GenerateAPIData.generateCreateJobData();
    }

    @Test(description = "Create Repair Job")
    public void createJob()  {
        Header myHeader = new Header("Content-Type", "application/json");
        Header myHeader2 = new Header("Authorization",apiToken);
        APIHelper helper = new APIHelper();
        Response response = helper.makeRequest(HTTPVerb.POST,"/v1/job/create",myHeader,myHeader2,apiBody);
        String jobNumber = response.then()
                .assertThat()
                .statusCode(200)
                .and()
                .body("message",containsString("Job created successfully"))
                .and()
                .time(lessThan(2000L))
                .and()
                .extract()
                .path("data.job_number");
        System.out.println("******* JOB NUMBER ***********");
        System.out.println(jobNumber);
    }
}
