package tests.jobs;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.cs.DataProvider.LoginDataProvider;
import com.cs.Pages.JobPage;
import com.cs.Pages.LoginPage;

import baseTests.BaseTest;

public class JobTest extends BaseTest{

	@Test(dataProviderClass = LoginDataProvider.class, dataProvider = "jobData")
	public void verifyJobFunctionality(Map<String, String> map) {
		LoginPage loginPage = new LoginPage();
		JobPage jobPage = new JobPage();
		loginPage.verifyLogin(map.get("username"), map.get("password"));
		jobPage.verifyJobSearch(map.get("jobName"), map.get("jobLocation"), map.get("experienceLevel"), map.get("companyName"));
		Assert.assertTrue(jobPage.isElementDisplayed(), "Result title is not displayed.");
	}
}
