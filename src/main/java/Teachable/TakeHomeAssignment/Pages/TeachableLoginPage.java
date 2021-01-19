package Teachable.TakeHomeAssignment.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import Teachable.TakeHomeAssignment.helper.TeachableConstants;
import Teachable.TakeHomeAssignments.Utils.Log;
import Teachable.TakeHomeAssignments.Utils.TeachableUtils;
import Teachable.TakeHomeAssignments.Utils.WebDriverSetup;

public class TeachableLoginPage {

	WebDriverSetup webDriver = new WebDriverSetup();
	TeachableUtils teachableUtils = new TeachableUtils();
	
	public static final String url	= "https://takehome.zeachable.com";
	
	/*
	 * Web Elements to interact with Web Page
	 */
	@FindBy(xpath = TeachableConstants.XPATH_USERNAME)
	private WebElement username;
	
	@FindBy(xpath = TeachableConstants.XPATH_PASSWORD)
	private WebElement password;
	
	@FindBy(xpath = TeachableConstants.XPATH_LOGIN_BUTTON)
	private WebElement loginButton;

	@FindBy(xpath = TeachableConstants.XPATH_USER_AVATAR_IMAGE)
	private WebElement userAvatarImage;
	
	@FindBy(xpath = TeachableConstants.XPATH_ERROR_MESSAGE)
	private WebElement errorMessage;
	
	/*
	 * Function to navigate to application URL
	 */
	public void navigateToApplicationURL() {
		Log.INFO("Navigating to URL..." + url);
		webDriver.getWebDriver().get(url);
	}
	
	/*
	 * Function to perform click action on Link
	 * 
	 * @param   linkName 	Name of link to be clicked on
	 */
	public void clickLink(String linkName) {
		teachableUtils.waitForPageLoad();
		WebElement link = webDriver.getWebDriver().findElement(By.linkText(linkName));
		link.click();
	}

	/*
	 * Function to enter username in input text box
	 * 
	 * @param   userID 	  User ID to be entered in Username text field
	 */
	public void enterUserName(String userID) {
		teachableUtils.waitForElement(username);
		username.click();
		username.clear();
		username.sendKeys(userID);
	}
	
	/*
	 * Function to enter password in input text box
	 * 
	 * @param   inputPassword 	  password to be entered in password text field
	 */
	public void enterPassword(String inputPassword) {
		password.click();
		password.clear();
		password.sendKeys(inputPassword);
	}
	
	/*
	 * Function to click on Log In button
	 */
	public void clickLoginBtn() {
		loginButton.click();
	}
	
	/*
	 * Function to click on Log Out button
	 */
	public void clickLoginOutBtn() {
		userAvatarImage.click();
		clickLink("Log Out");
		Log.INFO("Clicked Log Out");
	}
	
	/*
	 * Function to validate Login is Successful
	 */
	public void verifyLoginSuccessful() {
		if(userAvatarImage.isDisplayed()) {
			Log.INFO("Login Successful");
		}
		
		Assert.assertTrue(userAvatarImage.isDisplayed(), "Login is not successful!!!");
	}
	
	/*
	 * Function to validate Login is not Successful
	 */
	public void verifyLoginNotSuccessful() {
		String expectedURL = url;
		String actualURL = webDriver.getWebDriver().getCurrentUrl();
		teachableUtils.waitForElement(errorMessage);
		if(errorMessage.isDisplayed()) {
			Log.INFO("Login is not Successful. Error message is displayed as expected");
		}
		
		Assert.assertTrue(errorMessage.isDisplayed(), "Error message is not displayed as expected");
		Assert.assertFalse(actualURL.equals(expectedURL), "Login is successful");
	}
	
	/*
	 * Function to validate Header Text is displayed as expected
	 */
	public void verifyHeaderText(String headerText) {
		teachableUtils.waitForPageLoad();
		WebElement header = webDriver.getWebDriver().findElement(By.xpath(".//*[contains(text(),'" + headerText  + "')]"));
		if(header.isDisplayed()) {
			Log.INFO("Header text - " + headerText + " is displayed as expected");
		}
		
		Assert.assertTrue(header.isDisplayed(), "Header is not displayed as expected");
	}
}
