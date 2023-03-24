package plutoseleniumproject;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class OrderofTestExecution {
	@Test(groups= {"checkintegr"})
	public void testcase3()
	{
	System.out.println("in test case of 3 newTestNg class");	
	}
    @Test(groups= {"functest","checkintegr"})
	public void testcase4()
	{
	System.out.println("in test case of 3 newTestNg class");	
	}
    
    @Test(groups= {"functest","checkintegr"})
    public void stockdetails()
    {

		System.setProperty("WebDriver.chrome.driver","/Users/AshaPrathib/eclipse-workspace/com.qa.actitime/atbrowser/chromedriver109");
		WebDriver driver=new ChromeDriver();
		driver.get("https://money.rediff.com/gainers/bse/daily/groupa");
		//driver.window().manage().maximize();
		String text=driver.findElement(By.xpath("//a[contains(text(),'JSW Energy Ltd')]/self::a")).getText();
		System.out.println(text);
		
		String text1=driver.findElement(By.xpath("//a[contains(text(),'JSW Energy Ltd')]/parent::td")).getText();
		System.out.println(text1);
	
		//List<WebElement> childs=driver.findElements(By.xpath("//a[contains(text(),'JSW Energy Ltd')]/ancestor::tr/child::td")).size();
		//System.out.println("no of child elements"+childs.size());
		
		String text11=driver.findElement(By.xpath("//a[contains(text(),'JSW Energy Ltd')]/ancestor::tr")).getText();
		System.out.println(text11);
		
		
		driver.close();
		

    }

}
