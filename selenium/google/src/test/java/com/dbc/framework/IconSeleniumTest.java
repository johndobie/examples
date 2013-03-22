package com.dbc.framework;

import java.io.IOException;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

public abstract class IconSeleniumTest {

	private static final String APPLICATION_PROPERTIES = "application.properties";
	protected static String baseUrl = "http://localhost:8080/icon/pages";	
	protected static FirefoxDriver driver;
	protected static Logger logger = Logger.getLogger(IconSeleniumTest.class);
		
	@BeforeClass
	public static void openBrowser()
	{
		getCommandLineProperties();
		logger.info("Base URL : " + baseUrl);
		
		FirefoxProfile profile = new ProfilesIni().getProfile("selenium");
		driver = new FirefoxDriver(profile);
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
		IconSeleniumTest.baseUrl = baseUrl;	
	}
	
	public static void getPropertiesFromFile()
	{
		try
		{
			Configuration config = new PropertiesConfiguration("application.properties");
			String url = config.getString("baseUrl"); 
			
			if (!url.equals(null)){
				baseUrl = url;
			}
		}
		catch(Exception e)
		{
			logger.error("Unable to read properties file.  Using defaults. " + APPLICATION_PROPERTIES , e);
		}
	}
}