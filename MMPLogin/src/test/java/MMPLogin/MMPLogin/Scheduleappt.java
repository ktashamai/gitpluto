package MMPLogin.MMPLogin;

import java.util.Date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

public class Scheduleappt {
	
	WebDriver driver;
	String actualmsg;
	HashMap<String,String> expectedHMap=new HashMap<String,String>();
	HashMap<String,String> actualHMap=new HashMap<String,String>();
	

	public void launchBrowser(String url) throws InterruptedException
	{
		driver.get(url);
		Thread.sleep(1000);
		driver.manage().window().maximize();
	}
	
	
	public void instantiateDriver()
	{
		System.setProperty("WebDriver.chrome.driver",
				"/Users/AshaPrathib/eclipse-workspace/com.qa.actitime/atbrowser/chromedriver109");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*"); 
		driver=new ChromeDriver(options);
	}

	
	public void login(String uname,String pword)
	{
		driver.findElement(By.name("username")).sendKeys(uname);
		driver.findElement(By.name("password")).sendKeys(pword);
		driver.findElement(By.name("submit")).click();
	}
	
	
	public void navigate_module(String modulename)
	{
		driver.findElement(By.xpath("//span[normalize-space()='"+modulename+"']")).click();

	}
	
	
	 public String bookAppointment(String doctorName,String time,String sym,int noofDays) throws InterruptedException
	 {
		driver.findElement(By.xpath("//input[@value='Create new appointment']")).click();
		driver.findElement(By.xpath("//h4[normalize-space()='Dr."+doctorName+"']/ancestor::ul/following-sibling::button")).click();
		driver.switchTo().frame("myframe");
		driver.findElement(By.xpath("//input[@id='datepicker']")).click();	
		
		
		String expectedDate =   getFutureDate(noofDays,"MMMM/d/yyyy");
		expectedHMap.put("d",expectedDate);
		System.out.println("Expected Date: "+expectedDate);
		String dateArr[]=expectedDate.split("/");
		String expectedMonth = dateArr[0];//March
		String expectedDay = dateArr[1];//24
		String expectedYear = dateArr[2];//2023
		System.out.println("ExpectedMonth : "+expectedMonth);
		System.out.println("ExpectedDay : "+expectedDay);
		System.out.println("ExpectedYear : "+expectedYear);
		expectedDate=getFutureDate(noofDays,"MM/dd/yyyy");

		
		String actualMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();//March
        System.out.println("Actual month : "+actualMonth);
		String actualYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();//2023
		 System.out.println("Actual year : "+actualYear);
		Thread.sleep(5000);

		driver.findElement(By.xpath("//a[normalize-space()='13']")).click();
		//driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).click();
		//driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).click();
		System.out.println("Expected day : "+expectedDay);	
		
	
	     while(!(actualYear.equals(expectedYear)))
		{
			
			driver.findElement(By.cssSelector(".ui-icon.ui-icon-circle-triangle-e")).click();
		   actualYear = driver.findElement(By.className("ui-datepicker-year")).getText();
		}
		
		
		while(!(actualMonth.equals(expectedMonth)))
		{
			driver.findElement(By.cssSelector(".ui-icon.ui-icon-circle-triangle-e")).click();
			actualMonth = driver.findElement(By.className("ui-datepicker-month")).getText();
		}
	
		
	//	expectedDate=getFutureDate(noofDays,"MM/dd/yyyy");
		Select timeSelect = new Select(driver.findElement(By.id("time")));
		timeSelect.selectByVisibleText(time);
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//button[@id='ChangeHeatName']")).click();
		driver.findElement(By.id("sym")).sendKeys(sym);
		driver.findElement(By.xpath("//*[@value='Submit']")).click();
		//Fetchin
	    
		return expectedYear;
		
	 }

		private String getFutureDate(int noofDays1, String pattern) 
		{
			
			Calendar cal = 	Calendar.getInstance();
			cal.add(Calendar.DAY_OF_MONTH, noofDays1);
			
			Date d = (Date) cal.getTime();
			System.out.println("Current Date :" + d);
					
			SimpleDateFormat sdf = new SimpleDateFormat();
			String defaultformat = sdf.format(d);
			System.out.println(defaultformat);
			
			sdf = new SimpleDateFormat(pattern);
			String formatDate = sdf.format(d);
			System.out.println(formatDate);
			return formatDate;
		}
		
		 public HashMap<String, String> fetchPatientTabluarData()
			{
				HashMap<String,String> actualHMap = new HashMap<String,String>();
				String actualDate = driver.findElement(By.xpath("//table[@class='table']/tbody/tr[1]/td[1]")).getText();
				String actualTime = driver.findElement(By.xpath("//table[@class='table']/tbody/tr[1]/td[2]")).getText();
				String actualSym= driver.findElement(By.xpath("//table[@class='table']/tbody/tr[1]/td[3]")).getText();
				String actualDoctor= driver.findElement(By.xpath("//table[@class='table']/tbody/tr[1]/td[4]")).getText();
				System.out.println(actualDate);
				System.out.println(actualTime);
				System.out.println(actualSym);
				System.out.println(actualDoctor);
				actualHMap.put("doctor",actualDoctor);
				actualHMap.put("time",actualTime);
				actualHMap.put("sym",actualSym);
				actualHMap.put("date",actualDate);
				return actualHMap;
			}
	

	

	@Test
	 public void validateBooking_TC001() throws InterruptedException
		{
			instantiateDriver();
			launchBrowser("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");
			login("ria1","Ria12345");
			navigate_module("Schedule Appointment");
			bookAppointment("Beth","12Pm","Fever,Cold,Cough",0);
			String expectedDoctor="Beth";
			String expectedTime="12Pm";
			String expectedSym="Fever,Cold,Cough";
			expectedHMap.put("doctor",expectedDoctor);
			expectedHMap.put("time",expectedTime);
			expectedHMap.put("sym",expectedSym);
			actualHMap = fetchPatientTabluarData();
			AssertJUnit.assertEquals(actualHMap, expectedHMap);
			driver.close();
			
		}
		
	 

}
