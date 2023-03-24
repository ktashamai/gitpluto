package MMPLogin.MMPLogin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminLoginPage {
protected WebDriver driver;
	
	public AdminLoginPage(WebDriver driver1) {
		this.driver = driver1;
	}

	public AdminHomePage login(String userName,String password)
	{
		driver.findElement(By.id("username")).sendKeys(userName);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.xpath("//input[@name='admin']")).click();
		return new AdminHomePage(driver);
	
	}
	public void navigate_module(String moduleName) {
		
		driver.findElement(By.xpath("//span[normalize-space()='"+moduleName+"']")).click();
		
	}
}