package sportyshoes.teststeps;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "Features//buy_sporty_shoes.feature",
		glue = "sportyshoes.teststeps"
		)

public class TestRunner extends AbstractTestNGCucumberTests {

}
