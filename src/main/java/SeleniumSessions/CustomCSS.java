package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CustomCSS {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		
		//Get all the links under Information h5 in footer
		// footer .col-sm-3:first-of-type li
		//footer .col-sm-3:nth-child(1) li
		List<WebElement> infoLinks = driver.findElements(By.cssSelector("footer .col-sm-3:nth-child(1) li"));

		for(WebElement e: infoLinks) {
			String linkText = e.getText();
			System.out.println(linkText);
		}
	}

}
