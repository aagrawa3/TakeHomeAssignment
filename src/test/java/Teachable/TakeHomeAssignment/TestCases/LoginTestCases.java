package Teachable.TakeHomeAssignment.TestCases;

import org.junit.Test;

import Teachable.TakeHomeAssignments.Utils.Initialise;
import Teachable.TakeHomeAssignments.Utils.Log;

public class LoginTestCases {

	@Test
	public void testLoginEndToEnd() {
		Log.INFO("Test Case - Login Functionality End to end");
		Initialise.getTeachableLogin().navigateToApplicationURL();
		Initialise.getTeachableLogin().clickLink("Login");
		Initialise.getTeachableLogin().enterUserName("takehome@test.com");
		Initialise.getTeachableLogin().enterPassword("Teachable");
		Initialise.getTeachableLogin().clickLoginBtn();
		Initialise.getTeachableLogin().verifyLoginSuccessful();
		Initialise.getTeachableLogin().clickLoginOutBtn();
		Initialise.getTeachableLogin().verifyHeaderText("Welcome to takehome");
		Log.INFO("------------------------------------------");
	}
	
	@Test
	public void testInvalidUserID() {
		Log.INFO("Test Case - Entering invalid User ID");
		Initialise.getTeachableLogin().navigateToApplicationURL();
		Initialise.getTeachableLogin().clickLink("Login");
		Initialise.getTeachableLogin().enterUserName("takehomeTest2@test.com");
		Initialise.getTeachableLogin().enterPassword("Teachable");
		Initialise.getTeachableLogin().clickLoginBtn();
		Initialise.getTeachableLogin().verifyLoginNotSuccessful();
		Log.INFO("------------------------------------------");
	}
	
	@Test
	public void testInvalidPassword() {
		Log.INFO("Test Case - Entering invalid Password");
		Initialise.getTeachableLogin().navigateToApplicationURL();
		Initialise.getTeachableLogin().clickLink("Login");
		Initialise.getTeachableLogin().enterUserName("takehome@test.com");
		Initialise.getTeachableLogin().enterPassword("Teachable123");
		Initialise.getTeachableLogin().clickLoginBtn();
		Initialise.getTeachableLogin().verifyLoginNotSuccessful();
		Log.INFO("------------------------------------------");
	}
	
	@Test
	public void testInvalidUserIDPassword() {
		Log.INFO("Test Case - Entering invalid User ID and Password");
		Initialise.getTeachableLogin().navigateToApplicationURL();
		Initialise.getTeachableLogin().clickLink("Login");
		Initialise.getTeachableLogin().enterUserName("takehomeTest4@test.com");
		Initialise.getTeachableLogin().enterPassword("Teachable123");
		Initialise.getTeachableLogin().clickLoginBtn();
		Initialise.getTeachableLogin().verifyLoginNotSuccessful();
		Log.INFO("------------------------------------------");
	}
	
	@Test
	public void testForgtoPasswordLink() {
		Log.INFO("Test Case - Validating Forgot Password link");
		Initialise.getTeachableLogin().navigateToApplicationURL();
		Initialise.getTeachableLogin().clickLink("Login");
		Initialise.getTeachableLogin().clickLink("Forgot Password?");
		Initialise.getTeachableLogin().verifyHeaderText("Reset Password");
		Log.INFO("------------------------------------------");
	}
	
	@Test
	public void testCreateAccountLink() {
		Log.INFO("Test Case - Validating Create an Account link");
		Initialise.getTeachableLogin().navigateToApplicationURL();
		Initialise.getTeachableLogin().clickLink("Login");
		Initialise.getTeachableLogin().clickLink("Create an Account");
		Initialise.getTeachableLogin().verifyHeaderText("Sign Up to takehome");
		Log.INFO("------------------------------------------");
	}

}
