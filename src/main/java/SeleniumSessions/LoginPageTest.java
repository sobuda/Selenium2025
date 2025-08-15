package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageTest {

	public static void main(String[] args) {

		BrowserUtil bUtil = new BrowserUtil();
		WebDriver driver = bUtil.initialiseDriver("Chrome");
		
		bUtil.launchURL("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		bUtil.getPageTitle();
		
		
		ElementUtil eUtil = new ElementUtil(driver);
		
		By emailBy = By.id("input-email");
		By pswBy = By.id("input-password");
		
		eUtil.doSendKeys(emailBy,"tom@gmail.com" );
		eUtil.doSendKeys(pswBy, "tom@123");
		
	}

}
