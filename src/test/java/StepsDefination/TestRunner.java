package StepsDefination;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/resources/Features",
		glue={"StepsDefination"}, 
		monochrome=true,
//plugin={"pretty", "json:target/JSONReports/reports.json"}
//plugin= {"pretty","junit:target/JUnitReports/report.xml"})
plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
tags="@Smoke"
		 )


public class TestRunner {
	
	

}
