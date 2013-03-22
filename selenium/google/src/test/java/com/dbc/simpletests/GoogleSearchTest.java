package com.dbc.simpletests;

import static com.dbc.framework.SeleniumHelper.waitForXpathElement;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.dbc.framework.BaseSeleniumTest;

public class GoogleSearchTest extends BaseSeleniumTest{
	
	private static String SEARCH_RESULTS = "//div[@id='resultStats']";
	
	@Before
	public void getPage()
	{
		String page = "http://www.google.co.uk";
		driver.get(page);
	}
		
	@Test
	public void googleSearch() throws Exception {
		
		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.sendKeys("John Dobie");
		
		WebElement searchButton = driver.findElement(By.name("btnG"));
		searchButton.click();		 		
				
		waitForXpathElement(driver, SEARCH_RESULTS);
				
	}
}
