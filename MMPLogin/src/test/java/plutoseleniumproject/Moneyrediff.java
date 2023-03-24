package plutoseleniumproject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Moneyrediff {
	

	WebDriver driver = null;
	
	
	@BeforeMethod
	public void initialize()
	{
		System.setProperty("WebDriver.chrome.driver","/Users/AshaPrathib/eclipse-workspace/com.qa.actitime/atbrowser/chromedriver109");
		driver=new ChromeDriver();
	}

	@Test
	public void testShouldValidateTCSIsPresentInTitle() throws InterruptedException
	{
		driver.get("https://money.rediff.com/index.html");
		WebElement company=driver.findElement(By.xpath("//input[@name='srchword']"));
		company.sendKeys("Tata Consultancy Services Ltd");
		company.sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		String actualTitle=driver.getTitle();
		System.out.println("title of the page:"+" "+actualTitle);
		String expectedTitle="TATA CONSULTANCY SERVICES LTD";
		Assert.assertTrue(actualTitle.contains(expectedTitle), "Expected Title - TCS not present");
	}

	@AfterMethod
	public void close() {
		driver.close();

	}
	
}

