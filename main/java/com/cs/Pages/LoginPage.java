package com.cs.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.cs.Driver.Driver;

public class LoginPage {

	private static final By TXT_USERNAME = By.xpath("//input[@id='username']");
	private static final By TXT_PASSWORD = By.xpath("//input[@id='password']");
	private static final By BTN_LOGIN = By.xpath("//button[@type='submit']");
	
	
	private WebElement getWebElement(By by) {
		return Driver.driver.findElement(by);
	}
	
	private void clickElement(By by) {
		getWebElement(by).click();
	}
	
	public String getActualUrl() {
		return Driver.driver.getCurrentUrl();
	}

	public String getActualTitle() {
		return Driver.driver.getTitle(); 
	}
	
	private void typeText(String value, By by) {
		WebElement element = getWebElement(by);
		element.clear();
		element.sendKeys(value);
	}
	
	public HomePage verifyLogin(String username, String password) {
		typeText(username, TXT_USERNAME );
		typeText(password, TXT_PASSWORD);
		clickElement(BTN_LOGIN);
		return new HomePage();
	}

}
