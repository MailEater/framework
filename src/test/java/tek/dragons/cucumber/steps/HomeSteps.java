package tek.dragons.cucumber.steps;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import static org.junit.Assert.*;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tek.dragons.cucumber.pages.POMFactory;
import tek.dragons.cucumber.utilities.CommonUtility;

public class HomeSteps extends CommonUtility{

	POMFactory factory = new POMFactory();
	
	@Given("User is on retail website")
	public void userIsOnRetailWebsite() {
		Assert.assertTrue(isElementDisplayed(factory.HomePage().tekschoolLogo));
	    logger.info("User is on homepage");
	}
	
	
	@When("User click on All section")
	public void userClickOnAllSection() {
		factory.HomePage().allSectionBtn.click();
		Assert.assertTrue(isElementDisplayed(factory.HomePage().contentHeader));
		logger.info("User clicked on 'All Section button'");
	}
	
	
	@Then("below options are present in Shop by Department sidebar")
	public void belowOptionsArePresentInShopByDepartmentSidebar(io.cucumber.datatable.DataTable dataTable) {
		Assert.assertTrue(isElementDisplayed(factory.HomePage().electronics));
		Assert.assertTrue(isElementDisplayed(factory.HomePage().computers));
		Assert.assertTrue(isElementDisplayed(factory.HomePage().smartHome));
		Assert.assertTrue(isElementDisplayed(factory.HomePage().sports));
		Assert.assertTrue(isElementDisplayed(factory.HomePage().automotive));
		logger.info("User is on Shop by Deparment sidebar");
	}
	

	@And("User on {string}")
	public void userOnDepartment(String department) {
		List<WebElement> sidebarDepts = factory.HomePage().sidebarOptions;
		for (WebElement dept : sidebarDepts) {
			if (dept.getText().equals(department)) {
				click(dept);
				try {
					logger.info(dept.getText() + " is present");
				} catch (StaleElementReferenceException e) {

				}
				break;
			}
		}
	}
	
	@Then("below options are present in department")
	public void belowOptionsArePresentInDepartment(DataTable dataTable) {

		List<List<String>> expectedDeptOptions = dataTable.asLists(String.class);
		List<WebElement> actualDeptOptions = factory.HomePage().deptSubOptions;

		for (int i = 0; i < expectedDeptOptions.size(); i++) {
			for (WebElement subOption : actualDeptOptions) {
				if (subOption.getText().equals(expectedDeptOptions.get(0).get(i))) {
					assertTrue(isElementDisplayed(subOption));
					logger.info(subOption.getText() + " is present");
				}
			}
		}

	}
	
	
	
	
	
	
	
}
