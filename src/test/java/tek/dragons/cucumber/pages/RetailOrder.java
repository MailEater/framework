package tek.dragons.cucumber.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tek.dragons.cucumber.base.BaseSetup;

public class RetailOrder extends BaseSetup {

	public RetailOrder() {
		PageFactory.initElements(getDriver(), this);
	}

	@FindBy(xpath = "//select[@id = 'search']")
	public WebElement allDepartmentsBtn;

	@FindBy(xpath = "//input[@id = 'searchInput']")
	public WebElement searchInputField;

	@FindBy(xpath = "//button[@id = 'searchBtn']")
	public WebElement searchBtn;

	@FindBy(xpath = "//img[@class = 'image']")
	public WebElement itemToselect;

	@FindBy(xpath = "//select[@class = 'product__select']")
	public WebElement productQuantitySelection;

	@FindBy(xpath = "//button[@id = 'addToCartBtn']")
	public WebElement addCartBtn;

	@FindBy(xpath = "//span[@id = 'cartQuantity']")
	public WebElement cartQuantity;

	@FindBy(xpath = "//*[contains(@id, 'cartBtn')]")
	public WebElement cartBtn;

	@FindBy(xpath = "//*[contains(@id, 'proceedBtn')]")
	public WebElement checkoutBtn;

	@FindBy(id = "placeOrderBtn")
	public WebElement placeOrderBtn;

	@FindBy(xpath = "//p[contains(text(), 'Order Placed, Thanks')]")
	public WebElement orderPlacedText;
	
	@FindBy(xpath = "//a[@id = \"orderLink\"]")
	public WebElement orderBtn;
	
	@FindBy(xpath = "//p[@class = 'order__header-btn']")
	public List<WebElement> showDetailsBtn;
	
	@FindBy(xpath = "//button[@id = 'cancelBtn']")
	public WebElement cancelOrder;
	
	@FindBy(xpath = "//select[@id = 'reasonInput']")
	public WebElement selectCancellationReasonDropDown;

	@FindBy(xpath = "//button[@id = 'orderSubmitBtn']")
	public WebElement cancelOrderBtn;
	
	@FindBy(xpath = "//p[contains(text(),'Your Order Has Been Cancelled')]")
	public WebElement cancelText;
	
	@FindBy(xpath = "//button[@id = 'returnBtn']")
	public WebElement returnBtn;
	
	@FindBy(xpath = "//select[@id = 'dropOffInput']")
	public WebElement dropOffOption;
	
	@FindBy(xpath = "//button[@id = 'orderSubmitBtn']")
	public WebElement returnOrderBtn;
	
	@FindBy(xpath = "//p[contains(text(), 'Return was successfull')]")
	public WebElement returnSuccessMessage;
	
	@FindBy(xpath = "//button[@id='reviewBtn']")
	public WebElement reviewBtn;
	
	@FindBy(xpath = "//input[@id='headlineInput']")
	public WebElement headlineReview;
	
	@FindBy(xpath = "//textarea[@id='descriptionInput']")
	public WebElement reviewBody;
	
	@FindBy(xpath = "//button[@id='reviewSubmitBtn']")
	public WebElement addReviewBtn;
	
	@FindBy(xpath = "//div[contains(text(), 'Your review was added successfully')]")
	public WebElement reviewAddedSuccessfullyMessage;
	
}
