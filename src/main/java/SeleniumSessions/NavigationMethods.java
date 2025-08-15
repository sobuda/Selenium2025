package SeleniumSessions;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationMethods {

	public static void main(String[] args) throws MalformedURLException {

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.google.com");

		System.out.println(driver.getTitle());

		driver.navigate().to("https:www.Amazon.com");

		System.out.println(driver.getTitle());

		driver.navigate().back();

		System.out.println(driver.getTitle());

		driver.navigate().forward();

		System.out.println(driver.getTitle());

		driver.navigate().back();

		System.out.println(driver.getTitle());

		driver.navigate().to(new URL("https://www.github.com"));

		System.out.println(driver.getTitle());
		
		driver.navigate().refresh();

		driver.quit();

	}

}
