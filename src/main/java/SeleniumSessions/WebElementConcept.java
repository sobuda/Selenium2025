package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementConcept {

	static WebDriver driver;

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");

		// 1.
//		driver.findElement(By.id("input-email")).sendKeys("Tom@gmail.com");
//		driver.findElement(By.id("input-password")).sendKeys("psw@123");

		// 2.WebElement

		/*
		 * WebElement email = driver.findElement(By.id(("input-email"))); WebElement psw
		 * = driver.findElement(By.id(("input-password")));
		 * 
		 * email.sendKeys("tom@gamil.com"); psw.sendKeys("tom@123");
		 */

		// 3.By Locator +WebElement

//		By emailBy = By.id("input-email");
//		By pswBy = By.id("input-password");
//		
//		WebElement email = driver.findElement(emailBy);
//		WebElement psw = driver.findElement(pswBy);
//		
//		email.sendKeys("tom@gmail.com");
//		psw.sendKeys("tom@123");

		// 4.By Locator WebElemnet Generic function
//		By emailBy = By.id("input-email");
//		By pswBy = By.id("input-password");
//
//		doSendKeys(emailBy, "tom@gmail.com");
//		doSendKeys(pswBy, "tom@123");
		
		//5. usinf the wrapper class Elementutil 
		
		By emailBy = By.id("input-email");
		By pswBy = By.id("input-password");
		
		ElementUtil eUtil = new ElementUtil(driver);

		eUtil.doSendKeys(emailBy, "tom@gmail.com");
		eUtil.doSendKeys(pswBy, "tom@123");
		
		
	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public static void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);

	}

}
