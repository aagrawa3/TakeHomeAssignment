package Teachable.TakeHomeAssignments.Utils;

import org.apache.log4j.Logger;

public class Log {
 
 private static Logger Log = Logger.getLogger(Log.class.getName());

	 public static void INFO(String message) { 
		 Log.info(message);
	 }
	 
	 public static void WARN(String message) {
	    Log.warn(message);
	 }
	 
	 public static void ERROR(String message) {
	    Log.error(message);
	 }
	 
	 public static void DEBUG(String message) {
	    Log.debug(message);
	 }
 
}
