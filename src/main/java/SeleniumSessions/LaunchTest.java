package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchTest {

	public static void main(String[] args) {

		WebDriver driver = null;
		driver = new ChromeDriver();
		driver = new ChromeDriver();
		driver.get("https://www.google.com");
		System.out.println(driver.getTitle());
	
		//driver.quit();
		driver.close();
		System.out.println(driver.getTitle());

	}

}
