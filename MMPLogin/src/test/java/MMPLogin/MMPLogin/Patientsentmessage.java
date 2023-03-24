package MMPLogin.MMPLogin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Patientsentmessage {

	WebDriver driver;

	@BeforeClass
public void instantiateDriver() throws InterruptedException {
		
		System.setProperty("WebDriver.chrome.driver",
				"/Users/AshaPrathib/eclipse-workspace/com.qa.actitime/atbrowser/chromedriver109");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*"); 
		driver=new ChromeDriver(options);
		launchBrowser("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");
		
	}
public void launchBrowser(String url) throws InterruptedException
{
	driver.get(url);
	Thread.sleep(5000);
	driver.manage().window().maximize();
	

}
@Test (description="Validation of Patient sending message")
public void VerifyMessage() throws InterruptedException {

	LoginPage loginPage = new LoginPage(driver);
	HomePage homePage = loginPage.login("ria1","Ria12345");
	homePage.navigate_module("Messages");
	PatientMsgPage pmp=new PatientMsgPage(driver);
	pmp.PatientMsg();
	
}
}