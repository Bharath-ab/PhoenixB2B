package com.listners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyser implements IRetryAnalyzer {
    @Override
    public boolean retry(ITestResult iTestResult) {
        return false;
    }
}
