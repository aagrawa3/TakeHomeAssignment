package Teachable.TakeHomeAssignment;

import Teachable.TakeHomeAssignments.Utils.Log;

public class RunReport {

	public void printRunReport() {
			
		int runCount = TestRunner.result.getRunCount();
	    int failCount = TestRunner.result.getFailureCount();
		int passCount = runCount - failCount;
		   
		Log.INFO("");
		Log.INFO("");
		Log.INFO(" ------- SUMMARY REPORT ------");
		Log.INFO("|           Total #    |" + "   " + runCount + "  |");
		Log.INFO("|           Passed #   |" + "   " + passCount + "  |");
		Log.INFO("|           Failed #   |" + "   " + failCount + "  |");
		Log.INFO(" -----------------------------");
		Log.INFO("");
		Log.INFO("");
	}
    
}
