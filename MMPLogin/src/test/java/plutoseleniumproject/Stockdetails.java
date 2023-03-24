package plutoseleniumproject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Stockdetails {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("WebDriver.chrome.driver","/Users/AshaPrathib/eclipse-workspace/com.qa.actitime/atbrowser/chromedriver109");
		WebDriver driver=new ChromeDriver();
		driver.get("https://money.rediff.com/gainers/bse/daily/groupa?src=gain_lose");
		WebElement company=driver.findElement(By.xpath("//input[@name='srchword']"));
		company.sendKeys("CEAT LTD");
		company.sendKeys(Keys.ENTER);
		System.out.println("Going to sleep for 8 sec");
		Thread.sleep(8000);
		System.out.println("Sleep for 8 sec done");

		//WebElement volume=driver.findElement(By.xpath("//span[@id='Volume']"));
		//volume.getText();
		//System.out.println(volume);
		String volume=driver.findElement(By.xpath("//div[@id='for_BSE']//div//table[@class='company-graph-wrap']//ancestor::tr")).getText();
		System.out.println(volume);
		
		String volume1=driver.findElement(By.xpath("//div[@id='for_BSE']//div//table[@class='company-graph-wrap']/descendant::tr")).getText();
		System.out.println(volume1);
		
		String volume11=driver.findElement(By.xpath("//div[@id='for_BSE']//div//table[@class='company-graph-wrap']/child::tbody/descendant::span[1]")).getText();
		System.out.println("Volume"+volume11);
		
		String prevclose=driver.findElement(By.xpath("//div[@id='for_BSE']//div//table[@class='company-graph-wrap']/child::tbody/descendant::span[2]")).getText();
		System.out.println("Prev Close"+prevclose);
		
		String dayhl=driver.findElement(By.xpath("//div[@id='for_BSE']//div//table[@class='company-graph-wrap']/child::tbody/descendant::span[3]")).getText();
		System.out.println("DaysHl"+dayhl);
		
		String wk=driver.findElement(By.xpath("//div[@id='for_BSE']//div//table[@class='company-graph-wrap']/child::tbody/descendant::span[4]")).getText();
		System.out.println("52wk"+wk);
		
		String mkt=driver.findElement(By.xpath("//div[@id='for_BSE']//div//table[@class='company-graph-wrap']/child::tbody/descendant::span[5]")).getText();
		System.out.println("Mkt cap"+mkt);
		
		driver.close();
		

	}
}
