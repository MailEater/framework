package tek.dragons.cucumber.steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tek.dragons.cucumber.pages.POMFactory;
import tek.dragons.cucumber.utilities.CommonUtility;
import tek.dragons.cucumber.utilities.DataGenerator;

public class SignInStepDefinitions extends CommonUtility {

	POMFactory factory = new POMFactory();

	@When("User click on Sign in option")
	public void userClickOnSignInOption() {
		click(waitTillClickable(factory.HomePage().signInBtn));
		logger.info("User clicked on Sign In option");
	}

	@When("User enter email {string} and password {string}")
	public void userEnterEmailAndPassword(String emailValue, String passwordValue) {
		sendText(factory.SignInPage().emailField, emailValue);
		sendText(factory.SignInPage().passwordField, passwordValue);
		logger.info("User entered email and password field");
	}

	@When("User click on login button")
	public void userClickOnLoginButton() {
		click(factory.SignInPage().loginBtn);
		;
		logger.info("User clicked on login button");
	}

	@Then("User should be logged in into Account")
	public void userShouldBeLoggedInIntoAccount() {
		Assert.assertTrue(isElementDisplayed(factory.HomePage().logOutBtn));
		logger.info("User is signed into account");
	}

	@And("User click on Create New Account button")
	public void userClickOnCreateNewAccountButton() {
		click(waitTillClickable(factory.SignInPage().newAccountBtn));
		logger.info("User clicked on create new account button");
	}

	@And("User fill the signUp information with below data")
	public void userFillTheSignUpInformationWithBelowData(DataTable table) {
		List<Map<String, String>> signUpInfo = table.asMaps(String.class, String.class);
		sendText(factory.SignInPage().signUpName, DataGenerator.data(signUpInfo.get(0).get("name")));
		sendText(factory.SignInPage().signUpEmail, DataGenerator.data(signUpInfo.get(0).get("email")));
		sendText(factory.SignInPage().signUpPassword, signUpInfo.get(0).get("password"));
		sendText(factory.SignInPage().signUpConfirmPassword, signUpInfo.get(0).get("confirmPassword"));
		logger.info("User entered Name : Email : Password : Confirm Password");
	}

	@And("User click on SignUp button")
	public void userClickOnSignUpButton() {
		click(factory.SignInPage().signUpBtn);
		logger.info("User clicked on sign up button");
	}

	@Then("User should be logged into account page")
	public void userShouldBeLoggedIntoAccountPage() {
		waitTillPresence(factory.RetailAccount().profileImage);
		waitTillPresence(factory.RetailAccount().yourProfileText);
		logger.info("User is logged into account page");
	}

}
