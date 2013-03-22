package com.dbc.framework;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

public abstract class BaseSeleniumTest {

	protected static String baseUrl = "http://google.com";	
	protected static FirefoxProfile profile;
	protected static FirefoxDriver driver;
	protected static Logger logger = Logger.getLogger(BaseSeleniumTest.class);
		
	@BeforeClass
	public static void openBrowser()
	{
		getCommandLineProperties();
		profile = new ProfilesIni().getProfile("selenium");
		driver = new FirefoxDriver(profile);
		logger.info("Base URL : " + baseUrl);		
	}
	
	private static void getCommandLineProperties() {
		String url = System.getProperty("baseUrl");
		if (url != null)
		{
			baseUrl = url;
		}
	}

	@AfterClass
	public static void closeBrowser() throws IOException {
		driver.quit();
	}
	
	
	public static String getBaseUrl() {
		return baseUrl;
	}

	public static void setBaseUrl(String baseUrl) {
		BaseSeleniumTest.baseUrl = baseUrl;	
	}	
}