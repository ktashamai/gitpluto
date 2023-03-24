package plutoseleniumproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Stocktest {

	public static void main(String[] args) {
		
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
