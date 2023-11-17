package testrunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"Features"},
		glue = {"steps"},
		plugin = {"pretty","html:report1.html"}
//		tags = "@tag5"
		)
public class testRunner{
	
	
}