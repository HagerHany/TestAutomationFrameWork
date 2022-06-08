package runner;


import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(features = "src/test/java/features",glue={"StepDefinition"},
        plugin = {"pretty","html:target/cucumber-html-report"})

public class TestRunner extends AbstractTestNGCucumberTests {



}
