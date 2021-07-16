package net.epiclanka.training.utill;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UtillLogger {
	
	
	public static void logInfo(Class<?> classname ,String msg ) {		
		 Logger logger = LoggerFactory.getLogger(classname);
		 logger.info(msg);
		
	}
	
	public static void logError(Class<?> classname ,String msg) {
		Logger logger = LoggerFactory.getLogger(classname);
		 logger.error(msg);
	}
	
	public static void logWarning(Class<?> classname ,String msg) {
		Logger logger = LoggerFactory.getLogger(classname);
		 logger.warn(msg);
	}
	

}
