package com.cs.Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cs.Driver.Driver;

public class JobPage {

	private static final By TXT_JOBNAME = By.xpath("//input[@class='search-global-typeahead__input']");
	private static final By BTN_JOB = By
			.xpath("//li[@class='search-reusables__primary-filter']//button[text()='Jobs']");
	private static final By TXT_JOBLOCATION = By.xpath("//input[@class='jobs-search-box__text-input']");
	private static final By BTN_EXPERIENCE = By.xpath("//button[text()='Experience level']");
	private static final By BTN_EXPERIENCESHOW = By
			.xpath("(//button[@data-control-name='filter_show_results'])[2]//span");
	private static final By RESULT_TEXT = By.xpath("//h1[@id='results-list__title']");
	private static final By BTN_COMPANY = By.xpath("//button[text()='Company']");
	private static final By TXT_COMPANYNAME = By.xpath("//input[@placeholder='Add a company']");
	private static final By SELECTCOMPANY = By.xpath("//div[@role='listbox']");
	private static final By BTNCOMPANYSHOW = By.xpath("(//button[@data-control-name='filter_show_results'])[3]//span");

	private WebElement getWebElement(By by) {
		return Driver.driver.findElement(by);
	}
	
	private void waitExplicitly(By by) {
		WebDriverWait wait = new WebDriverWait(Driver.driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(by));
	}
	
	
	private void clickElement(By by) {
		getWebElement(by).click();
	}

	private void typeText(String value, By by) {
		WebElement element = getWebElement(by);
		element.clear();
		element.sendKeys(value, Keys.ENTER);
	}

	private void typeJobName(String jobName) {
		typeText(jobName, TXT_JOBNAME);
	}

	private void typeJobLocation(String location) {
		clickElement(BTN_JOB);
		typeText(location, TXT_JOBLOCATION);
	}

	private void typeJobExperience(String experinceLevel) {
		waitExplicitly(BTN_EXPERIENCE);
		clickElement(BTN_EXPERIENCE);
		switch (experinceLevel) {
		case "Internship":
			clickElement(By.xpath("//label[@for='experience-1']"));
			break;
		case "Entry level":
			clickElement(By.xpath("//label[@for='experience-2']"));
			break;
		case "Associate":
			clickElement(By.xpath("//label[@for='experience-3']"));
			break;
		case "Mid-Senior level":
			clickElement(By.xpath("//label[@for='experience-4']"));
			break;
		case "Director":
			clickElement(By.xpath("//label[@for='experience-5']"));
			break;
		case "Executive":
			clickElement(By.xpath("//label[@for='experience-6']"));
			break;
		}
		waitExplicitly(BTN_EXPERIENCESHOW);
		clickElement(BTN_EXPERIENCESHOW);
	}
	
	private void typeCompanyName(String companyName) {
		//waitExplicitly(BTN_COMPANY);
		clickElement(BTN_COMPANY);
		//waitExplicitly(TXT_COMPANYNAME);
		getWebElement(TXT_COMPANYNAME).sendKeys(companyName);
		//waitExplicitly(SELECTCOMPANY);
		clickElement(SELECTCOMPANY);
		//waitExplicitly(BTNCOMPANYSHOW);
		clickElement(BTNCOMPANYSHOW);
	}
	
	public void verifyJobSearch(String jobName,String jobLocation,String experienceLevel,String companyName) {
		typeJobName(jobName);
		typeJobLocation(jobLocation);
		typeJobExperience(experienceLevel);
		typeCompanyName(companyName);
	}
	
	public boolean isElementDisplayed() {
		return getWebElement(RESULT_TEXT).isDisplayed();
	}

}
