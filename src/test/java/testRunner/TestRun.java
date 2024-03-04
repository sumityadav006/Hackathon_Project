package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
					features = {"src/test/resources/featureFiles/bike_details.feature"},
					glue={"com.stepDefinitions"},
					plugin = {
									"pretty", "html:reports/myreport.html",
									"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" },
					dryRun = false,
					monochrome = false,
					publish = false
					
					
				)

public class TestRun {

}
