package Teachable.TakeHomeAssignments.Utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverSetup {
	
	private static WebDriver driver = null;

	public WebDriver getWebDriver() {
		return driver;
	}
	
	/*
	 * Function to Setup and initiate new WebDriver
	 */
	public WebDriver setupWebDriver() {
		if(driver == null) {
			try {
				System.setProperty("webdriver.chrome.driver", TeachableUtils.getPropertyValue("chromeDriverPath"));
			} catch (IOException e) {
				System.err.println("IO Exception while accessing file");
			}
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}
		return driver;
	}

	/*
	 * Function to close and quit current WebDriver
	 */
	public void quit() {
		getWebDriver().close();
		getWebDriver().quit();
	}
}
