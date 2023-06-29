package com.cs.Driver;

import static com.cs.Properties.ReadPropertiesFile.prop;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {

	public static WebDriver driver;
	
	public static void getDriver() {
		driver = new ChromeDriver();
		driver.get(prop.getProperty("url"));
		if(prop.getProperty("maxwindow").equalsIgnoreCase("true"))
			driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(prop.getProperty("timeout"))));
	}
	
	public static void quitBrowser() {
		driver.quit();
	}
}
