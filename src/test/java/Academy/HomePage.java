package Academy;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.ForgotPassword;
import pageObject.landingPage;
import pageObject.loginPage;
import resources.base;

public class HomePage extends base {
	public WebDriver driver;
	@BeforeTest

	public void initialization() throws IOException {

		driver = InitializeDriver();

	}

	@Test(dataProvider = "getData")
	public void basePageNavigation(String username, String password, String text) throws IOException {
		
		driver.get(prop.getProperty("url"));
		landingPage l = new landingPage(driver);
		loginPage lp=(loginPage) l.getLogin();
		lp.getEmail().sendKeys(username);
		lp.getPassword().sendKeys(password);

		System.out.println(text);

		lp.getLogin().click();
		ForgotPassword fp=lp.forgotPassword();
		fp.getEmail().sendKeys("i am pushkar");
		fp.sendMeInstructions().click();
	}

	// driver.quit();
	// 2 set of test data one for restricted user and one for non restricted user so
	// 2 rows

	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[2][3];
		data[0][0] = "restricteduser@gmail.com";
		data[0][1] = "restricted";
		data[0][2] = "restricted user";

		data[1][0] = "nonrestricteduser@gmail.com";
		data[1][1] = "nonrestricted";
		data[1][2] = "non restricted user";

		return data;
	}

	@AfterTest
	public void teardown() {

		driver.close();
	}

}
