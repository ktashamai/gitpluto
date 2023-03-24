package plutoseleniumproject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class NewTestNgClass {
	@Test(groups= {"functest","checkintegr"})
	public void testcase1()
	{
	System.out.println("in test case of 1 newTestNg class");	
	}
    @Test(groups= {"checkintegr"})
	public void testcase2()
	{
	System.out.println("in test case of 2 newTestNg class");	
	}
    @Test(groups= {"functest","checkintegr"})
	public void profile() throws InterruptedException
	{
		System.setProperty("WebDriver.chrome.driver","/Users/AshaPrathib/eclipse-workspace/com.qa.actitime/atbrowser/chromedriver109");
		WebDriver driver=new ChromeDriver();
		driver.get("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");
		//driver.get("https://www.gmail.com");
		Thread.sleep(1000);
		driver.findElement(By.name("username")).sendKeys("ria1");
		driver.findElement(By.name("password")).sendKeys("Ria12345");
		driver.findElement(By.name("submit")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[@href='profile.php']")).click();
		driver.findElement(By.xpath("//input[@id='Ebtn']")).click();
		driver.findElement(By.xpath("//input[@name='age']")).clear();
		driver.findElement(By.xpath("//input[@name='age']")).sendKeys("45");
		//System.out.println("Age"+driver.findElement(By.xpath("//input[@id='age']")));
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.switchTo().alert().accept();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[normalize-space()='Logout']")).click();
		driver.close();
	}







}

