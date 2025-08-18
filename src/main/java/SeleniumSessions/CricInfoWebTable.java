package SeleniumSessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CricInfoWebTable {

	static WebDriver driver;

	public static void main(String[] args) {

		driver = new ChromeDriver();
		driver.get(
				"https://www.espncricinfo.com/series/the-hundred-men-s-competition-2025-1471000/northern-superchargers-men-vs-birmingham-phoenix-men-14th-match-1471015/full-scorecard");

		String name = "Michael Pepper";
		System.out.println("wicket Taken By:  "+wicTaker(name));
		System.out.println(name+"  "+getScore(name));
		

	}

	public static List<String> getScore(String name) {
		List<WebElement> scoreCard = driver.findElements(By.xpath("//span[contains(text(),'" + name
				+ "')]/ancestor::td/following-sibling::td[contains(@class,'ds-text-right')]"));
		List<String> scoreList = new ArrayList<String>();
		for (WebElement e : scoreCard) {
			String td = e.getText();
			scoreList.add(td);
			//System.out.print(td);
		}
		return scoreList;
	}

	public static String wicTaker(String name) {
		WebElement wicEle = driver.findElement(By.xpath("//span[contains(text(),'"+name+"')]/ancestor::td/following-sibling::td"));
		return wicEle.getText();
	}
	
	
}
