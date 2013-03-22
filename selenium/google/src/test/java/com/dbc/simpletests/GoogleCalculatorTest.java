package com.dbc.simpletests;

import static com.dbc.framework.SeleniumHelper.waitForXpathElement;
import static org.fest.assertions.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.dbc.framework.BaseSeleniumTest;

public class GoogleCalculatorTest extends BaseSeleniumTest{
	
	private static final String RESULT = "//span[@id='cwos']";
	private static final String SEARCH_RESULTS = "//div[@id='resultStats']";
	private static final String SEARCH_BOX = "q";
	private static final String SEARCH_BUTTON = "btnG";
	
	@Before
	public void getPage()
	{
		String page = "http://www.google.co.uk";
		driver.get(page);
	}
		
	@Test
	public void enterCalculation() throws Exception {
		
		WebElement searchBox = driver.findElement(By.name(SEARCH_BOX));
		searchBox.sendKeys("100 + 100");
		
		WebElement searchButton = driver.findElement(By.name(SEARCH_BUTTON));
		searchButton.click();		 		
				
		waitForXpathElement(driver, SEARCH_RESULTS);
		
		String calculatorField = driver.findElementByXPath(RESULT).getText();
		assertThat(calculatorField).isEqualTo("200");
	}
}
