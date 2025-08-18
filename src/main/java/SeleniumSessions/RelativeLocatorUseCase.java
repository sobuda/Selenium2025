package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.with;

import java.util.List;;

public class RelativeLocatorUseCase {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		
		WebElement privacy = driver.findElement(By.cssSelector(".buttons .pull-right a"));
		
		WebElement checkBox = driver.findElement(with(By.tagName("input")).toRightOf(privacy));
		System.out.println(checkBox.isDisplayed());
		if(checkBox.isDisplayed()) {
			System.out.println("Privacy Policy CheckBox- Correct Location: PASS");
		}
		else {
			System.out.println("Privacy Policy CheckBox- InCorrect Location: FAIL");

		}
		
		WebElement terms = driver.findElement(with(By.className("pull-right")).near(privacy));
		System.out.println(terms.getText());
		
		List<WebElement> findElements = driver.findElements(with(By.tagName("input")).toRightOf(privacy));
		System.out.println(findElements.size());
		
		
		driver.navigate().to("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		WebElement email = driver.findElement(By.cssSelector("[for*='email']"));
		WebElement enterEmail = driver.findElement(with(By.tagName("input")).below(email));
		enterEmail.sendKeys("naveen@gmail.com");
		
	}
}
