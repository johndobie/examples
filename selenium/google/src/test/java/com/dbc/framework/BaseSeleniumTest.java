package com.dbc.framework;

import static com.dbc.framework.SeleniumHelper.getWebDriver;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.remote.RemoteWebDriver;

public abstract class BaseSeleniumTest {

	protected static String driverType = "chrome";
	protected static String baseUrl = "http://google.com";	
	protected static RemoteWebDriver driver;
	protected static Logger logger = Logger.getLogger(BaseSeleniumTest.class);
		
	@BeforeClass
	public static void openBrowser()
	{
		getCommandLineProperties();
		logger.info("Base URL : " + baseUrl);		
		driver = getWebDriver(driverType);
	}	

	@AfterClass
	public static void closeBrowser() throws IOException {
		driver.quit();
	}
	
	private static void getCommandLineProperties() {
		String url = System.getProperty("baseUrl");
		if (url != null)
		{
			baseUrl = url;
		}
		String driver = System.getProperty("driverType");
		if (driver != null)
		{
			driverType = driver;
		}
	}
	
}