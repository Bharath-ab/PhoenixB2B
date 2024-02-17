package com.listners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExtentReportAPIListener implements ITestListener {
    private ExtentReports extentReports;
    private ExtentSparkReporter sparkReporter;
    @Override
    public void onTestStart(ITestResult result) {
        ITestListener.super.onTestStart(result);
        System.out.println("---------"+result.getTestName()+"---------");
        System.out.println("---------"+result.getMethod().getMethodName()+"---------");
        System.out.println("---------"+result.getMethod().getDescription()+"-------");
        System.out.println("----------"+result.getName()+"------");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ITestListener.super.onTestSuccess(result);
        System.out.println("-----Test Passed **Extent Listener-----");
        extentReports.createTest(result.getMethod().getMethodName(),result.getMethod().getDescription());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ITestListener.super.onTestFailure(result);
        System.out.println("-----Test Failed ------");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public void onStart(ITestContext context) {
        ITestListener.super.onStart(context);
        String reportPath = System.getProperty("user.dir")+"/Reports";
        extentReports = new ExtentReports();
        sparkReporter = new ExtentSparkReporter(reportPath);
        extentReports.attachReporter(sparkReporter);
        extentReports.setSystemInfo("OS", "Windows");
        extentReports.setSystemInfo("AUT", "DEV");

    }

    @Override
    public void onFinish(ITestContext context) {
        ITestListener.super.onFinish(context);
        extentReports.flush();
    }
}
