package tek.dragons.cucumber.pages;

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

	@FindBy(xpath = "//img[@alt = 'Kasa Outdoor Smart Plug']")
	public WebElement kasaOutDoorSmartPlugImage;

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

}
