package tek.dragons.cucumber.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tek.dragons.cucumber.base.BaseSetup;

public class SignInPage extends BaseSetup {
	
	public SignInPage() {
		PageFactory.initElements(getDriver(), this);
	}

	@FindBy(id = "email")
	public WebElement emailField;
	
	@FindBy(id = "password")
	public WebElement passwordField;
	
	@FindBy(id = "loginBtn")
	public WebElement loginBtn;
	
	@FindBy(id = "newAccountBtn")
	public WebElement newAccountBtn;
	
	@FindBy(xpath = "//input[@id = 'nameInput']")
	public WebElement signUpName;
	
	@FindBy(xpath = "//input[@id = 'emailInput']")
	public WebElement signUpEmail;
	
	@FindBy(xpath = "//input[@id = 'passwordInput']")
	public WebElement signUpPassword;
	
	@FindBy(xpath = "//input[@id = 'confirmPasswordInput']")
	public WebElement signUpConfirmPassword;
	
	@FindBy(xpath = "//button[@id = 'signupBtn']")
	public WebElement signUpBtn;
	
	
	
}
