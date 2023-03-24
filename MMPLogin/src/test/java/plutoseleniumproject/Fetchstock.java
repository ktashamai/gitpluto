package plutoseleniumproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Fetchstock {
	
WebDriver driver;
	
	
	public void instantiatedriver()
	{
		System.setProperty("WebDriver.chrome.driver","/Users/AshaPrathib/eclipse-workspace/com.qa.actitime/atbrowser/chromedriver109");
		driver=new ChromeDriver();
	}
	
	public void launchbrowser()
	{
		driver.get("https://money.rediff.com/gainers/bse/daily/groupa?src=gain_lose");
	}
  
   	public void fetchstockdetails(String stockname)
	{
		String companyname=driver.findElement(By.xpath("//a[normalize-space()='"+stockname+"']")).getText();
		String group=driver.findElement(By.xpath("//a[normalize-space()='"+stockname+"']/parent::td/following-sibling::td[1]")).getText();
		String prevclose=driver.findElement(By.xpath("//a[normalize-space()='"+stockname+"']/parent::td/following-sibling::td[2]")).getText();
		String currentprice=driver.findElement(By.xpath("//a[normalize-space()='"+stockname+"']/parent::td/following-sibling::td[3]")).getText();
		String change=driver.findElement(By.xpath("//a[normalize-space()='"+stockname+"']/parent::td/following-sibling::td[4]")).getText();
		String nextcompanyname=driver.findElement(By.xpath("//a[normalize-space()='"+stockname+"']/ancestor::tr/following-sibling::tr[1]/child::td[1]")).getText();
        System.out.println("companyname"+companyname);
        System.out.println("group"+group);
        System.out.println("prevclose"+prevclose);
        System.out.println("currentprice"+currentprice);
        System.out.println("%change"+change);
        System.out.println("next line company name"+nextcompanyname);
        
	}
	
    @Test
    public void details()
    {
    	instantiatedriver();
    	launchbrowser();
    	fetchstockdetails("TCNS Clothing");
    }
	

}
