package MMPLogin.MMPLogin;

import org.openqa.selenium.WebDriver;

public class AdminHomePage {

	protected WebDriver driver;

	public AdminHomePage(WebDriver driver1) {
		//prathib
		this.driver = driver1;
		if (!driver.getTitle().equals("home")) {
			throw new IllegalStateException("This is not Home Page of logged in user," +
					" current page is: " + driver.getCurrentUrl());
	}
}
}
