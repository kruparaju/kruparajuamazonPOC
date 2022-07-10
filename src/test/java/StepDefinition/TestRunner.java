package StepDefinition;

import java.io.File;

import org.junit.runner.RunWith;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/resources/Features/",
		glue= {"StepDefinition"},
		plugin= {"pretty","html:target/cucumber-reports/cucumber.html"}
		)

public class TestRunner {
}
		
