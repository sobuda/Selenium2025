package SeleniumSessions;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserUtil {

	private WebDriver driver;

	/**
	 * 
	 * Initialise driver based on gjven browser : chrome, firefox, edge, safari
	 * 
	 * @param browser
	 * @return
	 */
	public WebDriver initialiseDriver(String browser) {

		System.out.println("Launch Broswer: " + browser);

		switch (browser.trim().toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();

			break;
		case "edge":
			driver = new EdgeDriver();

			break;
		case "firefox":
			driver = new FirefoxDriver();

			break;

		case "safari":
			driver = new SafariDriver();

			break;
		default:
			System.out.println("===INVALID BROWSER===");
			throw new BrowserException("Broswer Not Valid: " + browser);

		}
		return driver;

	}

	private void checkNull(String url) {
		if (url == null) {
			throw new BrowserException("===Null Value===");
		}
	}

	/**
	 * Checks for empty URL
	 * 
	 * @param url
	 */
	private void stringLenCheck(String url) {
		if (url.isEmpty()) {
			throw new BrowserException("===EMPTY URL===");
		}
	}

	/**
	 * Checks whether URL starts with http
	 * 
	 * @param url
	 */
	private void httpCheck(String url) {
		if (!url.startsWith("http")) {
			throw new BrowserException("===HTTPS/ HTTP IS NOT PRESENT===");
		}

	}

	/**
	 * launch browser using String url
	 * 
	 * @param url
	 * @param driver
	 */
	public void launchURL(String url) {

		checkNull(url);
		stringLenCheck(url);
		httpCheck(url);

		driver.get(url);
	}

	/**
	 * Launch browser using URL type url
	 * 
	 * @param url
	 * @param driver
	 */
	public void launchURL(URL url) {

		String appUrl = String.valueOf(url);

		checkNull(appUrl);

		stringLenCheck(appUrl);

		httpCheck(appUrl);

		driver.navigate().to(url);

	}

	public String getPageTitle() {
		String title = driver.getTitle();
		System.out.println("Page Title: " + title);
		return title;

	}

	public String getPageUrl() {
		String url = driver.getCurrentUrl();
		System.out.println("Current URL: " + url);
		return url;
	}

	public void browserQuit() {
		if(driver!= null) {
		driver.quit();
		System.out.println("Browser closed");
		}
		
	}

	public void browserClose() {
		if(driver != null) {
		driver.close();
		System.out.println("Browser closed");
		}
		
	}

}
