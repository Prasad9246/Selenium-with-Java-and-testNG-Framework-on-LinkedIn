package baseTests;

import java.util.Properties;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.cs.DataProvider.LoginDataProvider;
import com.cs.Driver.Driver;
import com.cs.Properties.ReadPropertiesFile;

public class BaseTest {
static Properties prop = null;
static Object[] obj = null;
	
	@BeforeSuite
	public static void loadPropertyFile() {
		prop = ReadPropertiesFile.readPropertyFile();
		obj = LoginDataProvider.getLoginData();
	}
	

	
	@BeforeMethod
	public static void tearUp() {
		Driver.getDriver();
	}
	
	@AfterMethod
	public void tearDown() {
		Driver.quitBrowser();
	}
}
