package Teachable.TakeHomeAssignment;

import org.apache.log4j.xml.DOMConfigurator;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import Teachable.TakeHomeAssignment.TestSuite.TestSuite;
import Teachable.TakeHomeAssignments.Utils.Initialise;
import Teachable.TakeHomeAssignments.Utils.Log;

public class TestRunner {
	
	static Result result;
	
   public static void main(String[] args) {
	   
	  DOMConfigurator.configure("log4j.xml");
	  Initialise.init();
	  
	  result = JUnitCore.runClasses(TestSuite.class);
	  
      RunReport runReport = new RunReport();
      runReport.printRunReport();
      
      if(result.wasSuccessful())
    	  Log.INFO("### All Test Cases passed successfully ###");
      else {
    	  Log.ERROR("### Some Test Cases Failed ###");
    	  for(Failure failure : result.getFailures()) {
    		  Log.INFO(failure.toString());
    	  }
      }  
      
      Initialise.close();
   }

}
