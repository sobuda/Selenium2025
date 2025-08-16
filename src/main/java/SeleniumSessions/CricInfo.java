package SeleniumSessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CricInfo {

	static WebDriver driver;
	
	public static void main(String[] args) {

		driver = new ChromeDriver();
		driver.get("https://www.espncricinfo.com/series/the-hundred-men-s-competition-2025-1471000/northern-superchargers-men-vs-birmingham-phoenix-men-14th-match-1471015/full-scorecard");
		
		String name = "Benny Howell";
		By xpath = By.xpath("//span[contains(text(),'"+name+"')]/ancestor::tr//td");
		List<WebElement> cricInfo = driver.findElements(xpath);
		List<String> tdList = new ArrayList<String>();
		
		for(WebElement e:cricInfo) {
			String td = e.getText();
			tdList.add(td);
			System.out.print(td+"    ");
		}
		
	}

}
