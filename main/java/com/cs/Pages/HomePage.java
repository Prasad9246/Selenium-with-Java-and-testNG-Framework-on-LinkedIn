package com.cs.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.cs.Driver.Driver;

public class HomePage {
	
	private static final By TXT_WELCOME = By.xpath("//div[@class='t-16 t-black t-bold']");

	private WebElement getWebElement(By by) {
		return Driver.driver.findElement(by);
	}
	
	public String getActualText() {
		return getWebElement(TXT_WELCOME).getText();
	}
	
	public String getActualUrl() {
		return Driver.driver.getCurrentUrl();
	}

	public String getActualTitle() {
		return Driver.driver.getTitle(); 
	}
	
	
}
