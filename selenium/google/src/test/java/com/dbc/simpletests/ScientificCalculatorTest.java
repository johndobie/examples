package com.dbc.simpletests;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.dbc.framework.BaseSeleniumTest;

public class ScientificCalculatorTest extends BaseSeleniumTest{
	
	private static String CALCULATOR_FIELD = "input";
	private static String SEARCH_BUTTON = "ButtonCalc";
	
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
		
		searchBox = driver.findElement(By.xpath("//td[@class='result']"));
		String calculation = searchBox.getText();
		assertThat(calculation).isEqualTo("200");
	}
}
