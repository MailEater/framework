package tek.dragons.cucumber.base;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import tek.dragons.cucumber.utilities.CommonUtility;

public class BaseUITest extends CommonUtility{

	/*
	 * @Before hook
	 * @Before is a cucumber hook and we can setup the block of code under this
	 * cucumber annotation under any class, but for the purpose of our test automation
	 * framework, we will setup the @Before hook in our BaseUITest class
	 * @After
	 * @After is a cucumber hook and we can setup the block of code under this
	 * annotation under any class but for the purpose of our test automation
	 * framework, we will setup the @After hook in our BaseUITest class
	 */
	
	
	/*
	 * Using Scenario class from Cucumber, we can pass this in our @After hook method
	 * parameter, so that just in case the test step fails and scenarios fails,
	 * we can take a screenshot for that failed test step
	 */
	
	@Before
	public void setupTests() {
		super.setupBrowser();
	}
	
	
	@AfterStep
	public void takeScreenShot(Scenario scenario) {
		byte[] screenshot = takeScreenShotAsBytes();
		scenario.attach(screenshot, "image/png", "Screenshot");
	}
	
	@After
	public void closeTests(Scenario scenario) {
		//we need to write our code to check and see if the scenario failed
		//it should taker a screenshot and attach it to our test report
		if(scenario.isFailed()) {
			byte[] screenshot = takeScreenShotAsBytes();
			scenario.attach(screenshot, "image/png", scenario.getName() + " scenario failed");
		}
		super.quitBrowser();
		
	}
	
	
}
