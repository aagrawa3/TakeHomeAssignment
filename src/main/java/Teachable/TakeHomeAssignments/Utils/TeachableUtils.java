package Teachable.TakeHomeAssignments.Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.openqa.selenium.JavascriptExecutor;

public class TeachableUtils {

	WebDriverSetup webDriver = new WebDriverSetup();
	
	/*
	 * Function to return key's value from properties file
	 * 
	 *  @param   propertyName   Name of key in Properties file
	 *  
	 *   @return 			value associated with key
	 */
	public static String getPropertyValue(String propertyName) throws IOException {
		Properties prop = readPropertiesFile("src/main/resources/config/localConfig.properties");
		String path = prop.getProperty(propertyName);
		
		return path;
	}
	
	public static Properties readPropertiesFile(String fileName) throws IOException {
	      FileInputStream fileInputStream = null;
	      Properties properties = null;
	      try {
	    	  fileInputStream = new FileInputStream(fileName);
	          properties = new Properties();
	          properties.load(fileInputStream);
	      } catch(FileNotFoundException e) {
	         e.printStackTrace();
	      } catch(IOException e) {
	         e.printStackTrace();
	      } finally {
	    	  fileInputStream.close();
	      }
	      return properties;
	   }
	
	/*
	 * Function to wait for visibility of web element
	 * 
	 * @param   element   This is the WebElement to wait for
	 * 
	 * @return   nothing
	 * 
	 */
	public void waitForElement(WebElement element) {
		WebDriverWait wait = new WebDriverWait(webDriver.getWebDriver(), 10);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	
	/*
	 * Function to wait for Page to completely load 
	 * in order to click on WebElements
	 */
	public void waitForPageLoad() {
        ExpectedCondition<Boolean> expectation = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
                    }
                };
        try {
            Thread.sleep(1000);
            WebDriverWait wait = new WebDriverWait(webDriver.getWebDriver(), 30);
            wait.until(expectation);
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for Page Load Request to complete.");
        }
    }
	
}
