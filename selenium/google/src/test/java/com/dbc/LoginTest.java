package com.dbc;

import static com.dbc.framework.SeleniumHelper.waitToAppear;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.dbc.framework.IconSeleniumTest;

public class LoginTest extends IconSeleniumTest{
	
	@Before
	public void getPage()
	{
		String page = "http://www.google.co.uk";
		driver.get(page);
	}
		
	@Test
	public void sealSearch() throws Exception {
		
		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.sendKeys("John Dobie");
		
		WebElement searchButton = driver.findElement(By.name("btnG"));
		searchButton.click();		 		
		
		WebElement results = driver.findElement(By. xpath("//div[@id='resultStats']"));
				
	}
}
