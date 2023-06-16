package tek.dragons.cucumber.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



import tek.dragons.cucumber.base.BaseSetup;

public class RetailAccount extends BaseSetup {

	public RetailAccount() {
		PageFactory.initElements(getDriver(), this);
	}

	@FindBy(xpath = "//input[@id = 'nameInput']")
	public WebElement accountNameField;

	@FindBy(xpath = "//input[@id = 'personalPhoneInput']")
	public WebElement accountPhoneField;

	@FindBy(xpath = "//input[@id = 'emailInput']")
	public WebElement accountEmailField;

	@FindBy(xpath = "//input[@id = 'previousPasswordInput']")
	public WebElement previousPasswordField;

	@FindBy(xpath = "//input[@id = 'newPasswordInput']")
	public WebElement newPasswordInput;

	@FindBy(xpath = "//input[@id = 'confirmPasswordInput']")
	public WebElement confirmPasswordInput;

	@FindBy(xpath = "//img[@id = 'profileImage']")
	public WebElement profileImage;

	@FindBy(xpath = "//h1[@class = 'account__personal-title']")
	public WebElement yourProfileText;

	@FindBy(xpath = "//button[@id = 'personalUpdateBtn']")
	public WebElement updateBtn;

	@FindBy(xpath = "//div[@class = 'Toastify__toast-icon Toastify--animate-icon Toastify__zoom-enter']")
	public WebElement checkMarkLogo;

	@FindBy(xpath = "//p[@class = 'text-sm text-blue-700 hover:underline hover:text-red-700']")
	public WebElement addPaymentMethodLink;

	@FindBy(xpath = "//input[@id = 'cardNumberInput']")
	public WebElement cardNumberInput;

	@FindBy(xpath = "//input[@id = 'nameOnCardInput']")
	public WebElement nameOnCardInput;

	@FindBy(xpath = "//select[@id = 'expirationMonthInput']")
	public WebElement expirationMonthInput;

	@FindBy(xpath = "//select[@id = 'expirationYearInput']")
	public WebElement expirationYearInput;

	@FindBy(xpath = "//input[@id = 'securityCodeInput']")
	public WebElement securityCodeInput;

	@FindBy(xpath = "//button[@id = 'paymentSubmitBtn']")
	public WebElement addPaymentSubmitBtn;

	@FindBy(xpath = "//div[@class = 'Toastify__toast-body']")
	public WebElement paymentSubmittedSuccessfullyMessage;

	@FindBy(xpath = "//button[text() ='Edit']")
	public WebElement editCardInfo;

	@FindBy(xpath = "//p[@class = 'account__payment-ad-text']")
	public WebElement editCardForm;

	@FindBy(xpath = "//button[@id = 'paymentSubmitBtn']")
	public WebElement updateCardBtn;

	@FindBy(xpath = "//div[@class = 'Toastify__toast-body']")
	public WebElement paymentMethhodUpdateSuccessMessage;

	@FindBy(xpath = "//button[text() = 'remove']")
	public WebElement removeCardBtn;

	@FindBy(xpath = "//p[@class = 'account__payment__sub-text']")
	public WebElement accountPaymentSubText;

	@FindBy(xpath = "//div[@class = 'account__address-new']")
	public WebElement addAddressBox;

	@FindBy(xpath = "//select[@id = 'countryDropdown']")
	public WebElement countryDropDown;

	@FindBy(xpath = "//input[@id = 'fullNameInput']")
	public WebElement fullNameInput;

	@FindBy(xpath = "//input[@id = 'phoneNumberInput']")
	public WebElement phoneNumberInput;

	@FindBy(xpath = "//input[@id = 'streetInput']")
	public WebElement streetInput;

	@FindBy(xpath = "//input[@id = 'cityInput']")
	public WebElement cityInput;

	@FindBy(xpath = "//select[@name = \"state\"]")
	public WebElement stateDropDownOption;

	@FindBy(xpath = "//input[@id = 'zipCodeInput']")
	public WebElement zipCodeInput;

	@FindBy(xpath = "//input[@id = 'apartmentInput']")
	public WebElement apartmentInput;

	@FindBy(xpath = "//button[@id = 'addressBtn']")
	public WebElement addAddressBtn;

	@FindBy(xpath = "//div[@class = 'Toastify__toast-body']")
	public WebElement addressAddedSuccessfullyMessage;

	@FindBy(xpath = "(//button[@class = 'account__address-btn'])[1]")
	public WebElement editAddressBtn;

	@FindBy(xpath = "//button[. = 'Remove']")
	public WebElement removeAddressBtn;

	@FindBy(xpath = "//button[@id = 'addressBtn']")
	public WebElement updateAddressBtn;

	@FindBy(xpath = "//div[@class = 'Toastify__toast-body']")
	public WebElement addressUpdatedSuccessfullyMessage;

	@FindBy(xpath = "//div[contains(@class, 'false account__payment-item')][1]")
	public WebElement firstPaymentcard;

	@FindBy(xpath = "//div[@class = 'account__payment-sub']")
	public List<WebElement> listOfCards;

	@FindBy(xpath = "//img[@alt = 'Master Card']")
	public WebElement bankCard;

	// @FindBy(xpath = "account__address-grid")
	@FindBy(xpath = "//div[@class = 'account__address-single']")
	public List<WebElement> addressCount;
	
	

}
