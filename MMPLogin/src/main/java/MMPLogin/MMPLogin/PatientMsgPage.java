package MMPLogin.MMPLogin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class PatientMsgPage {
	WebDriver driver;
	
	public PatientMsgPage(WebDriver driver1) {
		this.driver = driver1;
	}

	public void PatientMsg()
	{	
	driver.findElement(By.xpath("//input[@id='subject']")).sendKeys("Having fever");
    driver.findElement(By.xpath("//textarea[@id='message']")).sendKeys("Doctor can you suggest any medicine for fever relief");
	driver.findElement(By.xpath("//input[@value='Send']")).click();
	String ExpectedMsg="Messages Successfully sent.";
	String actualmsg=driver.switchTo().alert().getText();
	driver.switchTo().alert().accept();
	driver.findElement(By.xpath("//a[@href='logout.php']")).click();
	driver.close();
	Assert.assertTrue(actualmsg.contains(ExpectedMsg));
	}
	public void navigate_module(String moduleName) {
		driver.findElement(By.xpath("//span[normalize-space()='"+moduleName+"']")).click();

	}

}
