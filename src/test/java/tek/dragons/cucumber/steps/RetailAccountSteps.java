package tek.dragons.cucumber.steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.Dimension;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tek.dragons.cucumber.pages.POMFactory;
import tek.dragons.cucumber.utilities.CommonUtility;
import tek.dragons.cucumber.utilities.DataGenerator;
import static org.junit.Assert.*;

public class RetailAccountSteps extends CommonUtility {

	POMFactory factory = new POMFactory();

	@When("User click on Account option")
	public void userClickOnAccountOption() {
		click(waitTillClickable(factory.HomePage().accountOption));
		logger.info("User clicked on account option");
	}

	@And("User update Name ‘NameValue’ and Phone ‘PhoneValue’")
	public void userUpdateNameNameValueAndPhonePhoneValue() {
		clearTextUsingSendKeys(factory.RetailAccount().accountNameField);
		sendText(factory.RetailAccount().accountNameField, DataGenerator.data("fullName"));
		clearTextUsingSendKeys(factory.RetailAccount().accountPhoneField);
		sendText(factory.RetailAccount().accountPhoneField, DataGenerator.data("phone"));
		logger.info("User updated name and phone values");
	}

	@And("User click on Update button")
	public void userClickOnUpdateButton() {
		click(factory.RetailAccount().updateBtn);
		logger.info("User clicked on update button");
	}

	@Then("user profile information should be updated")
	public void userProfileInformationShouldBeUpdated() {
		waitTillPresence(factory.RetailAccount().checkMarkLogo);
		Assert.assertTrue(isElementDisplayed(factory.RetailAccount().checkMarkLogo));
		String name = getAttribute(factory.RetailAccount().accountNameField, "value");
		String phone = getAttribute(factory.RetailAccount().accountPhoneField, "value");
		logger.info("User information has been updated!");
		logger.info("New Name: " + name);
		logger.info("New Phone Number: " + phone);
	}

	@And("User click on Add a payment method link")
	public void userClickOnAddAPaymentMethodLink() {
		click(factory.RetailAccount().addPaymentMethodLink);
		logger.info("User clicked on add payment method link");
	}

	@And("User fill Debit or credit card information")
	public void userFillDebitOrCreditCardInformation(DataTable table) {
		List<Map<String, String>> creditOrDebitCardInformation = table.asMaps(String.class, String.class);
		sendText(factory.RetailAccount().cardNumberInput,
				DataGenerator.data(creditOrDebitCardInformation.get(0).get("cardNumber")));
		sendText(factory.RetailAccount().nameOnCardInput,
				getAttribute(factory.RetailAccount().accountNameField, "value"));
		selectByValue(factory.RetailAccount().expirationMonthInput,
				creditOrDebitCardInformation.get(0).get("expirationMonth"));
		selectByValue(factory.RetailAccount().expirationYearInput,
				creditOrDebitCardInformation.get(0).get("expirationYear"));
		sendText(factory.RetailAccount().securityCodeInput,
				DataGenerator.data(creditOrDebitCardInformation.get(0).get("securityCode")));
		logger.info("User has filled in their debit/credit information");
	}

	@And("User click on Add your card button")
	public void userClickOnAddYourCardButton() {
		click(factory.RetailAccount().addPaymentSubmitBtn);
		logger.info("User clicked on add your card button");
	}

	@Then("a message should be displayed ‘Payment Method added successfully’")
	public void aMessageShouldBeDisplayedPaymentMethodAddedSuccessfully() {
		waitTillPresence(factory.RetailAccount().paymentSubmittedSuccessfullyMessage);
		Assert.assertTrue(isElementDisplayed(factory.RetailAccount().paymentSubmittedSuccessfullyMessage));
		logger.info("User has seccessfully added their payment method");
	}

	@And("User click on Edit option of card section")
	public void userClickOnEditOptionOfCardSection() {
		click(waitTillClickable(factory.RetailAccount().bankCard));
		click(factory.RetailAccount().editCardInfo);
		Assert.assertTrue(isElementDisplayed(factory.RetailAccount().editCardForm));
		logger.info("User is on the card edit section");
	}

	public void clearCardInformation() {
		factory.RetailAccount().nameOnCardInput.clear();
		factory.RetailAccount().cardNumberInput.clear();
		factory.RetailAccount().securityCodeInput.clear();
	}

	@And("user edit information with below data")
	public void userEditInformationWithBelowData(DataTable table) {
		List<Map<String, String>> editCreditOrDebitCardInformation = table.asMaps(String.class, String.class);
		clearCardInformation();
		sendText(factory.RetailAccount().cardNumberInput,
				DataGenerator.data(editCreditOrDebitCardInformation.get(0).get("cardNumber")));
		sendText(factory.RetailAccount().nameOnCardInput,
				DataGenerator.data(editCreditOrDebitCardInformation.get(0).get("nameOnCard")));
		selectByValue(factory.RetailAccount().expirationMonthInput,
				editCreditOrDebitCardInformation.get(0).get("expirationMonth"));
		selectByValue(factory.RetailAccount().expirationYearInput,
				editCreditOrDebitCardInformation.get(0).get("expirationYear"));
		sendText(factory.RetailAccount().securityCodeInput,
				DataGenerator.data(editCreditOrDebitCardInformation.get(0).get("securityCode")));
		logger.info("User has successfully edited their debit/credit information");
	}

	@And("user click on Update Your Card button")
	public void userClickOnUpdateYourCardButton() {
		click(factory.RetailAccount().updateCardBtn);
		logger.info("User has clicked on update your card button");
	}

	@Then("a message should be displayed ‘Payment Method updated Successfully’")
	public void aMessageShouldBeDisplayedPaymentMethodUpdatedSuccessfully() {
		waitTillPresence(factory.RetailAccount().paymentMethhodUpdateSuccessMessage);
		Assert.assertTrue(isElementDisplayed(factory.RetailAccount().paymentMethhodUpdateSuccessMessage));
		logger.info("User has successfully updated their card information");
	}

	public static int cardListSize;

	@When("User click on remove option of card section")
	public void userClickOnRemoveOptionOfCardSection() {
		click(waitTillClickable(factory.RetailAccount().firstPaymentcard));
		cardListSize = factory.RetailAccount().listOfCards.size();
		click(factory.RetailAccount().removeCardBtn);
		logger.info("User clicked on remove card information");
	}

	@Then("payment details should be removed")
	public void paymentDetailsShouldBeRemoved() {
		assertNotEquals(factory.RetailAccount().listOfCards.size(), cardListSize);
		logger.info("Payement details has been removed successfully");
	}

	@And("User click on Add address option")
	public void userClickOnAddAddressOption() {
		scrollPageDownWithJS();
		click(factory.RetailAccount().addAddressBox);
		logger.info("User clicked on add address box");
	}

	public void clearAddressInformation() {
		factory.RetailAccount().fullNameInput.clear();
		factory.RetailAccount().phoneNumberInput.clear();
		factory.RetailAccount().streetInput.clear();
		factory.RetailAccount().apartmentInput.clear();
		factory.RetailAccount().cityInput.clear();
		factory.RetailAccount().zipCodeInput.clear();
	}

	@And("user fill new address form with below information")
	public void userFillNewAddressFormWithBelowInformation(DataTable table) {
		List<Map<String, String>> addressFormTable = table.asMaps(String.class, String.class);
		selectByValue(factory.RetailAccount().countryDropDown, addressFormTable.get(0).get("country"));
		sendText(factory.RetailAccount().fullNameInput, DataGenerator.data(addressFormTable.get(0).get("fullName")));
		sendText(factory.RetailAccount().phoneNumberInput,
				DataGenerator.data(addressFormTable.get(0).get("phoneNumber")));
		sendText(factory.RetailAccount().streetInput, DataGenerator.data(addressFormTable.get(0).get("streetAddress")));
		sendText(factory.RetailAccount().apartmentInput, DataGenerator.data(addressFormTable.get(0).get("apt")));
		sendText(factory.RetailAccount().cityInput, DataGenerator.data(addressFormTable.get(0).get("city")));
		selectByValue(factory.RetailAccount().stateDropDownOption,
				DataGenerator.data(addressFormTable.get(0).get("state")));
		sendText(factory.RetailAccount().zipCodeInput, DataGenerator.data(addressFormTable.get(0).get("zipCode")));
		logger.info("User has sucessfully entered information into the address form");
	}

	@And("User click Add Your Address button")
	public void userClickAddYourAddressButton() {
		click(factory.RetailAccount().addAddressBtn);
		logger.info("User clicked on address button");
	}

	@Then("a message should be displayed ‘Address Added Successfully’")
	public void aMessageShouldBeDisplayedAddressAddedSuccessfully() {
		waitTillPresence(factory.RetailAccount().addressAddedSuccessfullyMessage);
		Assert.assertTrue(isElementDisplayed(factory.RetailAccount().addressAddedSuccessfullyMessage));
		logger.info("Address has been successfully added");
	}

	@And("User click on edit address option")
	public void userClickOnEditAddressOption() {
		click(factory.RetailAccount().editAddressBtn);
		logger.info("User clicked on edit address button");
	}

	@When("user fill new address form with new information")
	public void userFillNewAddressFormWithNewInformation(DataTable table) {
		clearAddressInformation();
		List<Map<String, String>> addressFormTable = table.asMaps(String.class, String.class);
		selectByValue(factory.RetailAccount().countryDropDown, addressFormTable.get(0).get("country"));
		sendText(factory.RetailAccount().fullNameInput, DataGenerator.data(addressFormTable.get(0).get("fullName")));
		sendText(factory.RetailAccount().phoneNumberInput,
				DataGenerator.data(addressFormTable.get(0).get("phoneNumber")));
		sendText(factory.RetailAccount().streetInput, DataGenerator.data(addressFormTable.get(0).get("streetAddress")));
		sendText(factory.RetailAccount().apartmentInput, DataGenerator.data(addressFormTable.get(0).get("apt")));
		sendText(factory.RetailAccount().cityInput, DataGenerator.data(addressFormTable.get(0).get("city")));
		selectByValue(factory.RetailAccount().stateDropDownOption,
				DataGenerator.data(addressFormTable.get(0).get("state")));
		sendText(factory.RetailAccount().zipCodeInput, DataGenerator.data(addressFormTable.get(0).get("zipCode")));
		logger.info("User changed their address information");
	}

	@And("User click update Your Address button")
	public void userClickUpdateYourAddressButton() {
		click(factory.RetailAccount().updateAddressBtn);
		logger.info("User clicked on the update address button");
	}

	@Then("a message should be displayed ‘Address Updated Successfully’")
	public void aMessageShouldBeDisplayedAddressUpdatedSuccessfully() {
		waitTillPresence(factory.RetailAccount().addressUpdatedSuccessfullyMessage);
		Assert.assertTrue(isElementDisplayed(factory.RetailAccount().addressUpdatedSuccessfullyMessage));
		logger.info("User has successfully updated their address information");
	}

	@And("User click on remove option of Address section")
	public void userClickOnRemoveOptionOfAddressSection() {
		scrollPageDownWithJS();
		click(factory.RetailAccount().removeAddressBtn);
		logger.info("User clicked on remove address button");
	}

	@Then("Address details should be removed")
	public void addressDetailsShouldBeRemoved() {
		assertFalse(isElementDisplayed(factory.RetailAccount().removeAddressBtn));
		logger.info("Address details has been removed successfully.");
	}

}
