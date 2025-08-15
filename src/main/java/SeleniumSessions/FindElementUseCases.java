package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementUseCases {

	static WebDriver driver;
	public static void main(String[] args) {

		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
//		List<WebElement> lText = driver.findElements(By.linkText("About Us"));
//		System.out.println(lText.size());
//		if(lText.size()==1) {
//			System.out.println(lText.get(0).getText());
//		}
//		else {
//			for(WebElement e : lText) {
//				System.out.println(e.getText()); 
//			}
//		}
		By linkText = By.linkText("About Us");
		System.out.println(checkElementDisplayed(linkText));
		linkText = By.linkText("Forgotten Password");
		System.out.println(checkElementDisplayed(linkText,2));
		
		driver.quit();

	}
	
	public static boolean checkElementDisplayed(By locator) {
	
		List<WebElement> eleText = getElements(locator);
		
		System.out.println(listSize(eleText));
		if(listSize(eleText)==1) {
			return true;
		}
		else
			return false;
	}
	
	public static boolean checkElementDisplayed(By locator,int expCount) {
		
		List<WebElement> eleText = getElements(locator);
		
		System.out.println(listSize(eleText));
		if(listSize(eleText)==expCount) {
			return true;
		}
		else
			return false;
	}
	
	public static int listSize(List<WebElement> l) {
		return l.size();
	}
	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

}
