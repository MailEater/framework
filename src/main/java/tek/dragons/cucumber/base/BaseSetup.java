package tek.dragons.cucumber.base;

import java.util.HashMap;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;

import tek.dragons.cucumber.config.Browser;
import tek.dragons.cucumber.config.ChromeBrowser;
import tek.dragons.cucumber.config.ChromeHeadless;
import tek.dragons.cucumber.config.EdgeBrowser;
import tek.dragons.cucumber.config.FireFoxBrowser;
import tek.dragons.cucumber.utilities.ReadYamlFiles;

public class BaseSetup {

	private static WebDriver webDriver;
	private final ReadYamlFiles environmentVariables;
	public static Logger logger;

	public BaseSetup() {
		// we need to get the path to env_config and log4j files and storre them
		// as a String
		String filePath = ".\\src\\main\\resources\\env_config.yml";
		String log4jPath = ".\\src\\main\\resources\\log4j.properties";
		try {
			environmentVariables = ReadYamlFiles.getInstance(filePath);
		} catch (Exception e) {
			System.out.println("Failed to load env_config property. Check your filePath");
			throw new RuntimeException("Failed to load env_config file: " + e.getMessage());
		}
		logger = Logger.getLogger("logger_file");
		PropertyConfigurator.configure(log4jPath);

	}

	public WebDriver getDriver() {
		return webDriver;
	}

	public void setupBrowser() {
		HashMap uiProperty = environmentVariables.getYamlProperty("ui");
		String url = uiProperty.get("url").toString().toLowerCase();
		Browser browser;
		switch (uiProperty.get("browser").toString().toLowerCase()) {
		case "chrome":
			if ((boolean) uiProperty.get("headless")) {
				browser = new ChromeHeadless();
			} else {
				browser = new ChromeBrowser();
			}
			webDriver = browser.openBrowser(url);
			break;
		case "firefox":
			browser = new FireFoxBrowser();
			webDriver = browser.openBrowser(url);
			break;
		case "edge":
			browser = new EdgeBrowser();
			webDriver = browser.openBrowser(url);
			break;
		default:
			throw new RuntimeException("Browser name in config file does not match any of the cases");
		}
	}

	public void quitBrowser() {
		if (webDriver != null)
			webDriver.quit();
	}

}
