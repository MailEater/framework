package tek.dragons.cucumber.pages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tek.dragons.cucumber.base.BaseSetup;

public class HomePage extends BaseSetup {

	public HomePage() {
		PageFactory.initElements(getDriver(), this);
	}

	/*
	 * findElement() or findElements() We use @FindBY annotation to find element or
	 * elements
	 * 
	 * @FindBy is a Selenium annotation, it is used as an alternative way to
	 * findElement or findElements
	 */

	@FindBy(linkText = "TEKSCHOOL")
	public WebElement tekschoolLogo;

	@FindBy(id = "signinLink")
	public WebElement signInBtn;

	@FindBy(id = "logoutBtn")
	public WebElement logOutBtn;

	@FindBy(id = "hamburgerBtn")
	public WebElement allSectionBtn;

	@FindBy(id = "contentHeader")
	public WebElement contentHeader;

	@FindBy(xpath = "//div[@class='sidebar_content-item' and @data-id='1']")
	public WebElement electronics;

	@FindBy(xpath = "//div[@class='sidebar_content-item' and @data-id='2']")
	public WebElement computers;

	@FindBy(xpath = "//div[@class='sidebar_content-item' and @data-id='3']")
	public WebElement smartHome;

	@FindBy(xpath = "//div[@class='sidebar_content-item' and @data-id='4']")
	public WebElement sports;

	@FindBy(xpath = "//div[@class='sidebar_content-item' and @data-id='5']")
	public WebElement automotive;

	@FindBy(xpath = "//a[@id = 'accountLink']")
	public WebElement accountOption;

	@FindBy(xpath = "//div[@class ='sidebar_content-item']/span")
	public List<WebElement> sidebarOptions;

	@FindBy(xpath = "//div[@class ='sidebar_content-item']/span")
	public List<WebElement> deptSubOptions;

}
