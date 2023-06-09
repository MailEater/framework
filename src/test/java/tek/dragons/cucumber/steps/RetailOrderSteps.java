package tek.dragons.cucumber.steps;

import org.junit.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tek.dragons.cucumber.pages.POMFactory;
import tek.dragons.cucumber.utilities.CommonUtility;

public class RetailOrderSteps extends CommonUtility{

	POMFactory factory = new POMFactory();

	@And("User change the category to {string}")
	public void userChangeTheCategoryTo(String category) {
		selectByVisibleText(factory.RetailOrder().allDepartmentsBtn, category);
		logger.info("User changed department category");
	}
	
	@And("User search for an item {string}")
	public void userSearchForAnItem(String inputField) {
		sendText(factory.RetailOrder().searchInputField, inputField);
		logger.info("User has entered " + inputField + " into the search field");
	}
	
	@And("User click on Search icon")
	public void userClickOnSearchIcon() {
		click(factory.RetailOrder().searchBtn);
		logger.info("User clicked on search button");
	}
	
	@And("User click on item")
	public void userClickOnItem() {
		click(waitTillPresence(factory.RetailOrder().kasaOutDoorSmartPlugImage));
		logger.info("User clicked on item");
	}
	
	@And("User select quantity ‘{int}’")
	public void userSelectQuantity(Integer qnty) {
		selectByValue(factory.RetailOrder().productQuantitySelection, "" + qnty);
		logger.info("User changed the quantity of the item");
	}
	
	@And("User click add to Cart button")
	public void userClickAddToCartButton() {
		click(factory.RetailOrder().addCartBtn);
		logger.info("User clicked on add to cart button");
	}
	
	@Then("the cart icon quantity should change to ‘{int}’")
	public void theCartIconQuantityShouldChangeTo(Integer qnty) {
		waitTillPresence(factory.RetailOrder().cartQuantity);
		Assert.assertEquals(getElementText(factory.RetailOrder().cartQuantity), "" + qnty);
		logger.info("Cart icon quantity has succesfully changed");
	}
	
	
	
}
