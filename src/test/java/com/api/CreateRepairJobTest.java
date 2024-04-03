package com.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.listners.APIListeners;
import com.listners.ExtentReportAPIListener;
import com.utils.APIHelper;
import com.utils.HTTPVerb;
import com.utils.Role;
import com.utils.TestUtility;
import io.restassured.http.Header;
import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.lessThan;
@Listeners({APIListeners.class, ExtentReportAPIListener.class})
public class CreateRepairJobTest {

    String apiToken;
    String apiBody;
    @BeforeTest(description = "Generate API Token to Authenticate")
    public void generateToken() throws JsonProcessingException {
        apiToken = TestUtility.generateTokenFor(Role.FD);
        apiBody = TestUtility.generateCreateJobData();
    }

    @Test(description = "Create Repair Job")
    public void createJob() throws JsonProcessingException {
        Header myHeader = new Header("Content-Type", "application/json");
        Header myHeader2 = new Header("Authorization",apiToken);
        APIHelper helper = new APIHelper();
        Response response = helper.makeAPIRequest("/v1/job/create",TestUtility.generateCreateJobData(), HTTPVerb.POST,myHeader,myHeader2);
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
