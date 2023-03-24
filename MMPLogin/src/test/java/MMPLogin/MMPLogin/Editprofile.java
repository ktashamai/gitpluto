package MMPLogin.MMPLogin;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
public class Editprofile {
	
	WebDriver driver;
	String actualmsg;
	HashMap<String,String> expectedHMap=new HashMap<String,String>();
	HashMap<String,String> actualHMap=new HashMap<String,String>();
	
	public void instantiateDriver()
	{
		System.setProperty("WebDriver.chrome.driver",
				"/Users/AshaPrathib/eclipse-workspace/com.qa.actitime/atbrowser/chromedriver109");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*"); 
		driver=new ChromeDriver(options);

	}

	public void launchBrowser(String url) throws InterruptedException
	{
		driver.get(url);
		Thread.sleep(1000);
		driver.manage().window().maximize();
	}
	
	public void login(String usname,String pword) throws InterruptedException
	{
		driver.findElement(By.name("username")).sendKeys(usname);
		driver.findElement(By.name("password")).sendKeys(pword);
		driver.findElement(By.name("submit")).click();
		Thread.sleep(5000);
	}
	
	public void updateprofile() throws InterruptedException
	{
		driver.findElement(By.xpath("//a[@href='profile.php']")).click();
		driver.findElement(By.xpath("//input[@id='Ebtn']")).click();
		driver.findElement(By.xpath("//input[@id='age']")).clear();
		driver.findElement(By.xpath("//input[@id='age']")).sendKeys("56");
		System.out.println("Age"+driver.findElement(By.xpath("//input[@id='age']")));
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		actualmsg=driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[normalize-space()='Logout']")).click();
		driver.close();
	
	}
	@Test
	public void editprofile() throws InterruptedException
	{
		instantiateDriver();
		launchBrowser("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");
		//launchBrowser("https://www.gmail.com");
		login("ria1","Ria12345");
		updateprofile();
		String expectedmsg="Your Profile has been updated.";
		AssertJUnit.assertTrue(actualmsg.contains(expectedmsg));
	
	}
}

	
	
	
	
	
	
	
	
	
	


