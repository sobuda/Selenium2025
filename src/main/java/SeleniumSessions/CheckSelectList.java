package SeleniumSessions;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckSelectList {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.facebook.com/r.php?entry_point=login");
		ElementUtil eUtil = new ElementUtil(driver);
		By month = By.id("month");
		List<String> actualList = eUtil.getAllOptions(month);
		
		List<String> expectedList = Arrays.asList("Jan","Feb","Nv","May");
		
		if(actualList.containsAll(expectedList)) {
			System.out.println("PASS");
		}
		else
			System.out.println("FAIL");
	}

}
