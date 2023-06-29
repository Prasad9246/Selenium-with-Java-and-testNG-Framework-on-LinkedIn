package tests.home;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.cs.DataProvider.LoginDataProvider;
import com.cs.Pages.HomePage;
import com.cs.Pages.LoginPage;

import baseTests.BaseTest;

public class HomeTestTitle extends BaseTest {

	@Test(dataProviderClass = LoginDataProvider.class, dataProvider = "loginData")
	public void verifyHomeTitle(Map<String, String> map) {
		LoginPage loginPage = new LoginPage();
		HomePage homePage = loginPage.verifyLogin(map.get("username"), map.get("password"));
		String actTitle = homePage.getActualTitle();
		String expTitle = "(4) Feed | LinkedIn";
		Assert.assertEquals(expTitle, actTitle,
				"Actual Text : " + actTitle + " does not match the Expected Text : " + expTitle);

	}
}
