package com.test.TestRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features", glue = "com.test.StepDefinition", plugin = { "pretty",
        "html:target/cucumber-reports.html" }, monochrome = true)
public class TestRunner {
    public static void main(String[] args) throws Exception {
        org.junit.runner.JUnitCore.main("com.test.TestRunner.TestRunner");
    }
}
