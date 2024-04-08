package com.runner;

import io.cucumber.junit.platform.engine.Constants;
import org.junit.platform.suite.api.*;

@Suite
@IncludeEngines("cucumber")
@SuiteDisplayName("Phoenix B2B Automation")
@SelectPackages("com.api")
@ConfigurationParameter(key = Constants.FEATURES_PROPERTY_NAME,value = "src/test/resources/apifeatures")
@ConfigurationParameter(key = Constants.GLUE_PROPERTY_NAME,value = "com/api/stepdefinitions")
@ConfigurationParameter(key = Constants.FILTER_TAGS_PROPERTY_NAME,value = "@E2E")
@ConfigurationParameter(key = Constants.EXECUTION_DRY_RUN_PROPERTY_NAME,value = "false")
@ConfigurationParameter(key = Constants.PLUGIN_PROPERTY_NAME,value = "pretty, html:target/cucumber-report/cucumber.html")
public class CucumberJunit {
}
