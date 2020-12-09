package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class base {
	public WebDriver driver;
	public Properties prop;
	

	public WebDriver InitializeDriver() throws IOException {

		 prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\Lucky\\eclipse-workspace\\E2EProject\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		String broswserName = prop.getProperty("browser");

		// if (broswserName == "chrome")
		if (broswserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chrome\\chromedriver.exe");
			driver = new ChromeDriver();
		}

		else if (broswserName == "firefox") {
			// execute in firefox browser
		}

		else if (broswserName == "IE") {

		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
		
		
	}
	public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		String destinationFile =System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		FileUtils.copyFile(source , new File(destinationFile));
		return destinationFile;
		
	}
}
