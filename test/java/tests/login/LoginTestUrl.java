package tests.login;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.cs.Pages.LoginPage;

import baseTests.BaseTest;

public class LoginTestUrl extends BaseTest{

	@Test()
	public void verifyLoginUrl() {
		LoginPage loginPage = new LoginPage();
		String actUrl = loginPage.getActualUrl();
		String expUrl = "https://www.linkedin.com/login";
		Assert.assertEquals(expUrl, actUrl,"Actual Url : "+actUrl+" does not match the Expected Url : "+expUrl);
	}
}
