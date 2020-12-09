package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class landingPage {

	public WebDriver driver;
	
	By signin=By.cssSelector("a[href*='sign_in']");
	By title=By.xpath("//*[@id='content']/div/div/h2");
	
	public landingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	public loginPage getLogin() {
		
		driver.findElement(signin).click();
		loginPage lp = new loginPage(driver);
		return lp;
		
		
	}
public WebElement getTitle() {
		
		return driver.findElement(title);
		
	}
	
}
