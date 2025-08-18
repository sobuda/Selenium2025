package SeleniumSessions;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RelativeLocatorConcept {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		
		driver.get("https://cosmocode.io/automation-practice-webtable/");
		
		WebElement e = driver.findElement(By.xpath("//strong[contains(text(),'Angola')]"));
		
		WebElement toLeft = driver.findElement(with(By.tagName("input")).toLeftOf(e));
		toLeft.click();	
		System.out.println(toLeft.isSelected());

		WebElement above = driver.findElement(with(By.tagName("strong")).above(e));
		System.out.println(above.getText());
		
		WebElement below = driver.findElement(with(By.tagName("strong")).below(e));
		
		System.out.println(below.getText());
		
		WebElement toRight = driver.findElement(with(By.tagName("td")).toRightOf(e));
		System.out.println(toRight.getText());
		
		System.out.println(driver.findElement(with(By.tagName("td")).near(e)).getTagName());
	}

}
