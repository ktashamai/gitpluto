package MMPLogin.MMPLogin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AdminVerifyMsg {
	WebDriver driver;

	/*@BeforeClass
public void instantiateDriver() throws InterruptedException {
		
		System.setProperty("WebDriver.chrome.driver",
				"/Users/AshaPrathib/eclipse-workspace/com.qa.actitime/atbrowser/chromedriver109");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*"); 
		driver=new ChromeDriver(options);
		launchBrowser("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");
		//launchBrowser("http://96.84.175.78/MMP-Release2-Admin-Build.2.1.000/login.php");
		
	}*/

@BeforeClass
public void instantiateDriver1() throws InterruptedException {
	
	System.setProperty("WebDriver.chrome.driver",
			"/Users/AshaPrathib/eclipse-workspace/com.qa.actitime/atbrowser/chromedriver109");
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--remote-allow-origins=*"); 
	driver=new ChromeDriver(options);
	//launchBrowser("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");
	launchBrowser("http://96.84.175.78/MMP-Release2-Admin-Build.2.1.000/login.php");
	
}
public void launchBrowser(String url) throws InterruptedException
{
	driver.get(url);
	Thread.sleep(5000);
	driver.manage().window().maximize();
	

}

	@Test(description="TC_003 Validation of the messages sent in inbox")
	
	public void VerifyMessage() throws InterruptedException {
		
	/*	AdminLoginPage adminloginPage = new AdminLoginPage(driver);
		AdminHomePage adminhomepage=adminloginPage.login("ria1","Ria12345");
		PatientMsgPage pmp=new PatientMsgPage(driver);
		pmp.navigate_module("Messages");
		pmp.PatientMsg();
	*/
		
		AdminLoginPage adminloginpage=new AdminLoginPage(driver);
		AdminHomePage adminhomepage=adminloginpage.login("Ben@123","Frank@123");
		adminloginpage.navigate_module("Messages");
		AdminMsgPage adminmsgpage=new AdminMsgPage(driver);
		adminmsgpage.AdminMsg();
		
}
	

}