package tests.login;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.cs.DataProvider.LoginDataProvider;
import com.cs.Pages.HomePage;
import com.cs.Pages.LoginPage;

import baseTests.BaseTest;

public class LoginTestBtn extends BaseTest {

	@Test(dataProviderClass = LoginDataProvider.class, dataProvider = "loginData")
	public void verifyLoginButton(Map<String, String> map) {
		LoginPage loginPage = new LoginPage();
		HomePage homePage = loginPage.verifyLogin(map.get("username"), map.get("password"));
		String actText = homePage.getActualText();
		String expText = "Welcome, Rohan!";
		Assert.assertEquals(expText, actText,
				"Actual Text : " + actText + " does not match the Expected Text : " + expText);

	}
}
