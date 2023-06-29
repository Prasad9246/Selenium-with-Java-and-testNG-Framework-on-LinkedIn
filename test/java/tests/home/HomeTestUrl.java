package tests.home;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.cs.DataProvider.LoginDataProvider;
import com.cs.Pages.HomePage;
import com.cs.Pages.LoginPage;

import baseTests.BaseTest;

public class HomeTestUrl extends BaseTest {

	@Test(dataProviderClass = LoginDataProvider.class, dataProvider = "loginData")
	public void verifyHomeTitle(Map<String, String> map) {
		LoginPage loginPage = new LoginPage();
		HomePage homePage = loginPage.verifyLogin(map.get("username"), map.get("password"));
		String actUrl = homePage.getActualUrl();
		String expUrl = "https://www.linkedin.com/feed/";
		Assert.assertEquals(expUrl, actUrl,
				"Actual Text : " + actUrl + " does not match the Expected Text : " + expUrl);

	}
}
