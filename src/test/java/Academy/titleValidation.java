package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObject.landingPage;
import resources.base;

public class titleValidation extends base {
	public static Logger log=LogManager.getLogger(base.class.getName());
	public WebDriver driver;
	@BeforeTest

	public void initialization() throws IOException {

		driver = InitializeDriver();
		//log.info("driver is initialized");
		driver.get(prop.getProperty("url"));
		//log.info("Home PAge is launched");

	}

	@Test

	public void basePageNavigation() throws IOException {
		landingPage l = new landingPage(driver);
		Assert.assertEquals(l.getTitle().getText(), "FEATURED COURSES");
		//log.info("title is matching");
		System.out.println(l.getTitle().getText());
	}
	
	@AfterTest
	public void teardown() {

		driver.close();
	}

}
