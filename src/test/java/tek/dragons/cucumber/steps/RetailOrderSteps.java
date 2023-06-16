package tek.dragons.cucumber.steps;

import org.junit.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tek.dragons.cucumber.pages.POMFactory;
import tek.dragons.cucumber.utilities.CommonUtility;

public class RetailOrderSteps extends CommonUtility {

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
		click(waitTillPresence(factory.RetailOrder().itemToselect));
		logger.info("User clicked on item");
	}

	@And("User click add to Cart button")
	public void userClickAddToCartButton() {
		click(factory.RetailOrder().addCartBtn);
		logger.info("User clicked on add to cart button");
	}

	@And("User select quantity '{int}'")
	public void user_select_quantity(Integer qnty) {
		selectByValue(factory.RetailOrder().productQuantitySelection, "" + qnty);
		logger.info("User changed the quantity of the item");
	}

	@Then("the cart icon quantity should change to ‘{int}’")
	public void the_cart_icon_quantity_should_change_to(Integer qnty) {
		waitTillPresence(factory.RetailOrder().cartQuantity);
		Assert.assertEquals(getElementText(factory.RetailOrder().cartQuantity), "" + qnty);
		logger.info("Cart icon quantity has succesfully changed");
	}

	@Then("User click on Cart option")
	public void user_click_on_cart_option() {
		click(factory.RetailOrder().cartBtn);
		logger.info("User clicked on cart button");
	}

	@Then("User click on Proceed to Checkout button")
	public void user_click_on_proceed_to_checkout_button() {
		click(factory.RetailOrder().checkoutBtn);
		logger.info("User clicked on Proceed to Checkout button");
	}

	@Then("User click on Place Your Order")
	public void user_click_on_place_your_order() {
		click(factory.RetailOrder().placeOrderBtn);
		logger.info("User clicked on Place Your Order button");
	}

	@Then("a message should be displayed {string}")
	public void a_message_should_be_displayed(String text) {
		Assert.assertEquals(factory.RetailOrder().orderPlacedText.getText(), text);
		logger.info("Order confirmation is displayed : " + text);
	}

	@And("User click on Orders section")
	public void user_click_on_orders_section() {
		click(factory.RetailOrder().orderBtn);
		logger.info("User clicked on order button");
	}

	@When("User click on first order in list")
	public void user_click_on_first_order_in_list() {
		for (int i = 0; i < factory.RetailOrder().showDetailsBtn.size(); i++) {
			if (factory.RetailOrder().showDetailsBtn.get(i).getText().equals("Show Details")) {
				click(factory.RetailOrder().showDetailsBtn.get(i));
			}
		}
		Assert.assertTrue(isElementDisplayed(factory.RetailOrder().cancelOrder));
		logger.info("User is on first order in list");
	}

	@When("User click on Cancel The Order button")
	public void user_click_on_cancel_the_order_button() {
		click(factory.RetailOrder().cancelOrder);
		logger.info("User clicked on cancel button");
	}

	@When("User select the cancelation Reason {string}")
	public void userSelectTheCancelationReason(String reason) {
		click(factory.RetailOrder().selectCancellationReasonDropDown);
		selectByVisibleText(factory.RetailOrder().selectCancellationReasonDropDown, reason);
		logger.info("User clicked on cancellation reason");
	}

	@When("User click on Cancel Order button")
	public void user_click_on_cancel_order_button() {
		click(factory.RetailOrder().cancelOrderBtn);
		logger.info("User clicked on cancel order");
	}

	@Then("a cancelation message should be displayed ‘Your Order Has Been Cancelled’")
	public void aCancelationMessageShouldBeDisplayedYourOrderHasBeenCancelled() {
		waitTillPresence(factory.RetailOrder().cancelText);
		Assert.assertTrue(isElementDisplayed(factory.RetailOrder().cancelText));
		logger.info("Cancel text successfully displayed to the user");
	}

	@When("User click on Return Items button")
	public void user_click_on_return_items_button() {
		click(factory.RetailOrder().returnBtn);
		logger.info("User clicked on return button");
	}

	@When("User click on Return Order button")
	public void user_click_on_return_order_button() {
		click(factory.RetailOrder().returnOrderBtn);
		logger.info("User clicked on return button");
	}

	@And("User select the Return Reason {string}")
	public void userSelectTheReturnReasonItemDamaged(String reason) {
		click(factory.RetailOrder().selectCancellationReasonDropDown);
		selectByVisibleText(factory.RetailOrder().selectCancellationReasonDropDown, reason);
		logger.info("User clicked on damage option");
	}

	@And("User select the drop off service {string}")
	public void userSelectTheDropOffService(String reason) {
		click(factory.RetailOrder().dropOffOption);
		selectByVisibleText(factory.RetailOrder().dropOffOption, reason);
		logger.info("User selected option for return service");
	}

	@Then("a cancelation message should be displayed ‘Return was successful’")
	public void aCancelationMessageShouldBeDisplayedReturnWasSuccessful() {
		waitTillPresence(factory.RetailOrder().returnSuccessMessage);
		Assert.assertTrue(isElementDisplayed(factory.RetailOrder().returnSuccessMessage));
		logger.info("Return message is displayed to the user");
	}
	
	@And("User click on Review button")
	public void userClickOnReviewButton() {
	    click(factory.RetailOrder().reviewBtn);
	    logger.info("User clicked on review button");
	}
	
	@And("User write Review headline {string} and {string}")
	public void userWriteReviewHeadlineHeadlineValueAndReviewText(String headline, String review) {
	    sendText(factory.RetailOrder().headlineReview, headline);
	    sendText(factory.RetailOrder().reviewBody, review);
	    logger.info("User wrote a review on the item");
	}
	
	@When("User click Add your Review button")
	public void userClickAddYourReviewButton() {
	    click(factory.RetailOrder().addReviewBtn);
	    logger.info("User clicked on add review button");
	}
	
	@Then("a review message should be displayed ‘Your review was added successfully’")
	public void aReviewMessageShouldBeDisplayedYourReviewWasAddedSuccessfully() {
	    waitTillPresence(factory.RetailOrder().reviewAddedSuccessfullyMessage);
	    Assert.assertTrue(isElementDisplayed(factory.RetailOrder().reviewAddedSuccessfullyMessage));
	    logger.info("Review was successfully added");
	}

}
