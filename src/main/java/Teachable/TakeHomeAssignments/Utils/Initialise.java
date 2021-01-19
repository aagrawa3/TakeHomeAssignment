package Teachable.TakeHomeAssignments.Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import Teachable.TakeHomeAssignment.Pages.TeachableLoginPage;

public class Initialise {

	static WebDriver driver = null;
	private static TeachableLoginPage login = null;
	
	public static TeachableLoginPage getTeachableLogin() {
		return login;
	}
	
	public static void init() {
		login = new TeachableLoginPage();
		WebDriverSetup driverSetup = new WebDriverSetup();
	    driver = driverSetup.setupWebDriver();
	    login = PageFactory.initElements(driver, TeachableLoginPage.class);
	}
	
	/*
	 * Function to quit current web driver
	 */
	public static void close() {
		   driver.quit();
	   }
	
}
