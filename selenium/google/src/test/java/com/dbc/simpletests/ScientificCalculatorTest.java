package com.dbc.simpletests;

import static com.dbc.framework.SeleniumHelper.waitForXpathElement;
import static org.fest.assertions.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.dbc.framework.BaseSeleniumTest;

public class ScientificCalculatorTest extends BaseSeleniumTest{
	
	private static String CALCULATOR_FIELD = "input";
	private static String SEARCH_BUTTON = "ButtonCalc";
	private static String RESULT_FIELD = "//td[@class='result']";
	
	@Before
	public void getPage()
	{
		String page = "http://web2.0calc.com/";
		driver.get(page);
	}
		
	@Test
	public void enterCalculation() throws Exception {
		
		WebElement searchBox = driver.findElement(By.id(CALCULATOR_FIELD));
		searchBox.sendKeys("100 + 100");
		
		WebElement searchButton = driver.findElement(By.id(SEARCH_BUTTON));
		searchButton.click();		 
			
		waitForXpathElement(driver, RESULT_FIELD);
		
		String result = driver.findElement(By.xpath(RESULT_FIELD)).getText();
		assertThat(result).isEqualTo("200");
	}
}
