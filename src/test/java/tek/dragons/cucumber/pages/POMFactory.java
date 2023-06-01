package tek.dragons.cucumber.pages;

import tek.dragons.cucumber.base.BaseSetup;

public class POMFactory extends BaseSetup {

	private HomePage homePage;
	private SignInPage signInPage;
	private RetailAccount retailAccount;
	private RetailOrder retailOrder;
	
	public POMFactory() {
		this.homePage = new HomePage();
		this.signInPage = new SignInPage();
		this.retailAccount = new RetailAccount();
		this.retailOrder = new RetailOrder();
	}
	
	public HomePage HomePage() {
		return this.homePage;
	}

	public SignInPage SignInPage() {
		return this.signInPage;
	}
	
	public RetailAccount RetailAccount() {
		return this.retailAccount;
	}
	
	public RetailOrder RetailOrder() {
		return this.retailOrder;
	}
	
}
