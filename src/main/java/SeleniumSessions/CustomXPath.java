package SeleniumSessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CustomXPath {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();
		/*
		 * driver.get("https://www.amazon.com/");
		 * 
		 * Thread.sleep(3000);
		 */

		// //input[@type="submit"] - For Login Button

		// //div[@class='form-group required' and not(contains(@style,'none'))]

		// (//input[@class='form-control'])[last()]

		// Amazon last column help in footer
		// ((//div[@class='navFooterLinkCol navAccessibility'])[last()]//a)[last()]

		/*
		 * boolean b1 = driver .findElement(By.
		 * xpath("((//div[@class='navFooterLinkCol navAccessibility'])[last()]//a)[last()]"
		 * )) .isDisplayed();
		 * 
		 * System.out.println(b1);
		 */

		// Backward Traverse child to Parent
		// //input[@class='form-control']/../../..

		// PRECEDING-SIBLING
		// ((//select[@name='Country']/option[@value='Angola'])/preceding-sibling::option)[1]

		driver.navigate().to("https://selectorshub.com/xpath-practice-page/");
		Thread.sleep(2000);
		// driver.findElement(By.xpath("//a[text()='Joe.Root']/../preceding-sibling::td/input[@type='checkbox']")).click();
		String name = "Joe.Root";
		selectUser(name);
		System.out.println(isUserSelected(name));

		name = "Jordan.Mathews";
		selectUser(name);
		System.out.println(isUserSelected(name));
		
		List<String> userInfo = userInfo("Joe.Root");
		
		if(userInfo.contains("Enabled")) {
			System.out.println("TEST IS PASSED");
		}
		

	}

	public static List<String> userInfo(String userName) {
		List<WebElement> userInfo = driver
				.findElements(By.xpath("//a[text()='" + userName + "']/../following-sibling::td"));

		List<String> userDetails = new ArrayList<String>();
		for (WebElement e : userInfo) {
			String text = e.getText();
			System.out.println(text);
			userDetails.add(text);
		}
		return userDetails;
	}

	public static void selectUser(String name) {
		driver.findElement(By.xpath("//a[text()='" + name + "']/../preceding-sibling::td/input[@type='checkbox']"))
				.click();
	}

	public static boolean isUserSelected(String name) {
		return driver
				.findElement(By.xpath("//a[text()='" + name + "']/../preceding-sibling::td/input[@type='checkbox']"))
				.isSelected();
	}
}
