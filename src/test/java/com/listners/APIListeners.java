package com.listners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class APIListeners implements ITestListener {

    private static final String REPORT_DIR = System.getProperty("user.dir") + "/reports";

    @Override
    public void onTestStart(ITestResult result) {

        System.out.println("Test Case: " + result.getMethod().getMethodName() + " started...");
        System.out.println("Description: " + result.getMethod().getDescription());
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        ITestContext testContext = result.getTestContext();

        System.out.println("Test Case: " + result.getMethod().getMethodName() + " PASSED!!!!");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        String errorMessage = result.getThrowable().getMessage();

        System.out.println("Test Case: " + result.getMethod().getMethodName() + " FAILED!!!!");
    }

    @Override
    public void onTestSkipped(ITestResult result) {

        String errorMessage = result.getThrowable().getMessage();

        System.out.println("Test Case: " + result.getMethod().getMethodName() + " skipped!!!!");
    }

    @Override
    public void onStart(ITestContext context) {


        File reportDir = new File(REPORT_DIR);
        try {
            if (reportDir.exists()) {
                FileUtils.forceDelete(reportDir);
            }
            FileUtils.forceMkdir(reportDir);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy-HH-mm");
        String date = formatter.format(new Date());

    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("***************** Generating Reports for the tests..........");
        System.out.println("Report is CREATED at" + REPORT_DIR);

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // TODO Auto-generated method stub

    }
}
