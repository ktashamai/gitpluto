package MMPLogin.MMPLogin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AdminMsgPage {
	
WebDriver driver;

	
	public AdminMsgPage(WebDriver driver1) {
		this.driver = driver1;
}


	public void AdminMsg()
	{
	driver.findElement(By.xpath("//a[@href='messages.php']")).click();
	String message=driver.findElement(By.xpath("//td[contains(text(),'Doctor can you suggest any medicine for fever reli')]")).getText();
	System.out.println("message is: "+message);
	String Expectedmsg="Having fever";
	String Actualmsg=driver.findElement(By.xpath("(//b[contains(text(),'Having fever')])[1]")).getText();
	Assert.assertTrue(Actualmsg.contains(Expectedmsg));
	driver.close();}
	

}
