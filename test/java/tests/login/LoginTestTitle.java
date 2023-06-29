package tests.login;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.cs.Pages.LoginPage;

import baseTests.BaseTest;

public class LoginTestTitle extends BaseTest {

	@Test()
	public void verifyLoginTitle() {
		LoginPage loginPage = new LoginPage();
		String actTitle = loginPage.getActualTitle();
		String expTitle = "LinkedIn Login, Sign in | LinkedIn";
		Assert.assertEquals(expTitle, actTitle,"Actual Title : "+actTitle+" does not match the Expected Title : "+expTitle);
	}
}
