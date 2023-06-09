package tek.dragons.cucumber.steps;

import org.junit.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
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
		click(waitTillPresence(factory.RetailOrder().kasaOutDoorSmartPlugImage));
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
//
//	@When("User click on Orders section")
//	public void user_click_on_orders_section() {
//		// Write code here that turns the phrase above into concrete actions
//		throw new io.cucumber.java.PendingException();
//	}
//
//	@When("User click on first order in list")
//	public void user_click_on_first_order_in_list() {
//		// Write code here that turns the phrase above into concrete actions
//		throw new io.cucumber.java.PendingException();
//	}
//
//	@When("User click on Cancel The Order button")
//	public void user_click_on_cancel_the_order_button() {
//		// Write code here that turns the phrase above into concrete actions
//		throw new io.cucumber.java.PendingException();
//	}
//
//	@When("User select the cancelation Reason ‘Bought wrong item’")
//	public void user_select_the_cancelation_reason_bought_wrong_item() {
//		// Write code here that turns the phrase above into concrete actions
//		throw new io.cucumber.java.PendingException();
//	}
//
//	@When("User click on Cancel Order button")
//	public void user_click_on_cancel_order_button() {
//		// Write code here that turns the phrase above into concrete actions
//		throw new io.cucumber.java.PendingException();
//	}
//
//	@Then("a cancelation message should be displayed ‘Your Order Has Been Cancelled’")
//	public void a_cancelation_message_should_be_displayed_your_order_has_been_cancelled() {
//		// Write code here that turns the phrase above into concrete actions
//		throw new io.cucumber.java.PendingException();
//	}
//
//	@When("User click on Return Items button")
//	public void user_click_on_return_items_button() {
//		// Write code here that turns the phrase above into concrete actions
//		throw new io.cucumber.java.PendingException();
//	}
//
//	@When("User select the Return Reason ‘Item damaged’")
//	public void user_select_the_return_reason_item_damaged() {
//		// Write code here that turns the phrase above into concrete actions
//		throw new io.cucumber.java.PendingException();
//	}
//
//	@When("User select the drop off service ‘FedEx’")
//	public void user_select_the_drop_off_service_fed_ex() {
//		// Write code here that turns the phrase above into concrete actions
//		throw new io.cucumber.java.PendingException();
//	}
//
//	@When("User click on Return Order button")
//	public void user_click_on_return_order_button() {
//		// Write code here that turns the phrase above into concrete actions
//		throw new io.cucumber.java.PendingException();
//	}
//
//	@Then("a cancelation message should be displayed ‘Return was successful’")
//	public void a_cancelation_message_should_be_displayed_return_was_successful() {
//		// Write code here that turns the phrase above into concrete actions
//		throw new io.cucumber.java.PendingException();
//	}
//
//	@When("User click on Review button")
//	public void user_click_on_review_button() {
//		// Write code here that turns the phrase above into concrete actions
//		throw new io.cucumber.java.PendingException();
//	}
//
//	@When("User write Review headline ‘ headline value’ and ‘review text’")
//	public void user_write_review_headline_headline_value_and_review_text() {
//		// Write code here that turns the phrase above into concrete actions
//		throw new io.cucumber.java.PendingException();
//	}
//
//	@When("User click Add your Review button")
//	public void user_click_add_your_review_button() {
//		// Write code here that turns the phrase above into concrete actions
//		throw new io.cucumber.java.PendingException();
//	}
//
//	@Then("a review message should be displayed ‘Your review was added successfully’")
//	public void a_review_message_should_be_displayed_your_review_was_added_successfully() {
//		// Write code here that turns the phrase above into concrete actions
//		throw new io.cucumber.java.PendingException();
//	}

}
