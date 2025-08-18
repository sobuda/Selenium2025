package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDropDOwnMiddleValue {

	static WebDriver driver;
	
	public static void main(String[] args) {

		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/en/book-a-free-demo");
		
		WebElement dropdown = driver.findElement(By.id("Form_getForm_Country"));
		Select sel = new Select(dropdown);
		
		List<WebElement> options = sel.getOptions();
		/// Select MiddleElement
		int size = options.size();
		int midIndex = size/2;
		System.out.println(options.get(midIndex).getText());
		
		//Select Last Element
		int lastIndex = size-1;
		System.out.println(options.get(lastIndex).getText());
		
		//Select first Element
		System.out.println(options.get(1).getText());
		

	}

}
