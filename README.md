# TakeHomeAssignment

Project Title
--------------
Take Home Assignment


Description
-----------
Create Automation test cases for testing LOgin functionality of application. Automated test cases have been written using Selenium Wed Driver.


Language Used
------------
Java


File List
---------
TeachableLoginPage.java		This file contains methods to enter details on web page and validate results
TeachableConstants.java		This file contains xpaths of web elements
WebDriverSetup.java			  This file contains methods to initiate and setup Web Browser
TeachableUtils.java			  This file contains util methods like wait, wait for page load, etc.
Initialise.java				    This file contains methods to init() and close() web driver
Log.java						      This file contains Logger methods to print log statements
RunReport.java				    This file contains method to prepare summary report of Test Cases
TestRunner.java				    This file contains main method to run test suit
LoginTestCases.java			  This file contains all test cases related to Login functionality
localConfig.properties		This is a property file which contains file path to Chrome Driver


Prerequisites
------------
1. Install Chrome Driver based on Chrome version being used from below link 
   https://chromedriver.chromium.org/downloads
   
2. Update 'chromeDriverPath' in 'localConfig.properties' file with <pathOfChromeDriver> in local directory


Running the Tests
-----------------
Execute TestRunner.java file. This will run all test cases and prepare a summary report of executed tests.
