package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchDropDown {

	static WebDriver driver ;
	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();
		driver.get("https://www.amazon.ie");
		//driver.findElement(By.xpath("//button[@id=\"W0wltc\"]")).click();

		WebElement searchWord = driver.findElement(By.xpath("//input[@id=\"twotabsearchtextbox\"]"));
		searchWord.sendKeys("laptop");

		Thread.sleep(2000);
		

		//By suggLoc = By.xpath("//div[@class=\"wM6W7d\"]/span[text()]");
		By suggLoc = By.xpath("//div[@role=\"button\"]");

		String searchFor = "bag";
		searchUtil(suggLoc, searchFor);
//		List<WebElement> autoSuggestions = driver.findElements(By.xpath("//div[@class=\"wM6W7d\"]/span[text()]"));
//
//		System.out.println(autoSuggestions.size());
//
//		for (WebElement e : autoSuggestions) {
//			String text = e.getText();
//			System.out.println(text);
//			if (text.contains("framework")) {
//				e.click();
//				break;
//			}
//		}

		//driver.quit();

	}

	public static void searchUtil(By locator, String val) {
		List<WebElement> autoSuggestions = getElements(locator);

		System.out.println(autoSuggestions.size());

		for (WebElement e : autoSuggestions) {
			String text = e.getText();
			System.out.println(text);
//			if (text.contains(val)) {
//				e.click();
//				break;
//			}
		}
	}
	
	
	public  static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}
	
	
}
