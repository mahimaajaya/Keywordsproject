package com.alg.test.framework;

import java.sql.Connection;
import java.util.Date;
import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.alg.test.utility.Log;
import com.alg.test.utility.Utils;

public abstract class BaseTest {

	public static String sMasterDirPath;
	public static Properties pParamPropFile = null;
	public static Connection connectionDb = null;
	
	@BeforeSuite
	public static void setUp(){
		//Initialize log configurator
		DOMConfigurator.configure(System.getenv("ENV_LOG4J"));
		
		//Log start of suite
		Log.startTestSuite();
		
		//Load properties file
		try{
			Log.info("Loading properties file");
			pParamPropFile = Utils.openProperties(System.getenv("ENV_OBJ_REP"));
			
		}catch(Exception e){
			Log.error("Error loading properties file | Exception Description - " + e.getMessage());
			assert false;
		}
		
		//Connect to DB
		
		//Create regression (timestamp) directory
		sMasterDirPath = Utils.createDirectory(System.getenv("ENV_PARENT_RESULT_PATH"), "Regression_" + Utils.dateInFormat(new Date(), "yyyyMMddHHmmss"));
		Log.info("Created regression directory - " + sMasterDirPath);
	}
	
	@AfterSuite
	public static void tearDown(){
		//Close DB connection
	}	
}
