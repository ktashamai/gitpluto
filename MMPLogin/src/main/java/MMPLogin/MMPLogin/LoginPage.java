package MMPLogin.MMPLogin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	protected WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		    this.driver = driver;
		   
    }
	
	public HomePage login(String userName,String password)
	{
		driver.findElement(By.id("username")).sendKeys(userName);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.name("submit")).click();
		return new HomePage(driver);
	}

}
