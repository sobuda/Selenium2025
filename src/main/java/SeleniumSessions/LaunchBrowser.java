package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class LaunchBrowser {

	public static void main(String[] args) {
		// Launch the Chrome Browser
		
		WebDriver driver = null;
		
		//ChromeDriver driver = new ChromeDriver();
		//SafariDriver driver = new SafariDriver();
		//FirefoxDriver driver = new FirefoxDriver();

		driver = new ChromeDriver();
		// enter url
		driver.get("https://www.google.com");

		// get title of page
		String title = driver.getTitle();
		System.out.println(title);

		if (title.equals("Google")) {
			System.out.println("Title is correct: PASS");
		} else
			System.out.println("Title is INCorrect: FAIL");

		// Close the browser
		driver.close();
	}

}
