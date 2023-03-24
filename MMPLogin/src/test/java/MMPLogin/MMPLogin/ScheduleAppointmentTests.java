package MMPLogin.MMPLogin;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class ScheduleAppointmentTests {
	
	WebDriver driver;
	HashMap<String,String> expectedHMap=new HashMap<String,String>();
	HashMap<String,String> actualHMap=new HashMap<String,String>();
	

	
	@BeforeClass
	public void instantiateDriver() throws InterruptedException
	{
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
		Thread.sleep(1000);
		driver.manage().window().maximize();
	}
	
	@Test(description="TC_003 Validation of the Schedule appointment Booking",groups= {"Sanity","Regression"})
	public void validateBooking_TC001() throws InterruptedException
	{
		LoginPage loginPage = new LoginPage(driver);
		HomePage homePage = loginPage.login("ria1","Ria12345");
		homePage.navigate_module("Schedule Appointment");
		
		String expectedDoctor="Beth";
		String expectedTime="12Pm";
		String expectedSym="Fever,Cold,Cough";
	 
		ScheduleAppointmentPage sPage = new ScheduleAppointmentPage(driver);
		expectedHMap = sPage.bookAppointment(expectedDoctor,expectedTime,expectedSym,30);
		
		actualHMap = homePage.fetchPatientTabluarData();
		Assert.assertEquals(actualHMap, expectedHMap);		
	}
}
