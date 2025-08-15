package SeleniumSessions;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigateURL {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		
		URL baseURL = null;
		try {
			baseURL = new URL("https://www.flipkart.com");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.navigate().to(baseURL);
		
		System.out.println(driver.getTitle());
		
		driver.quit();
		
		new ChromeDriver().get("https://www.flipkart.com");
		
		
	}

}
