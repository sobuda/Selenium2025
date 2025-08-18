package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDropDownGetAllOptions {

	static WebDriver driver;
	public static void main(String[] args) {

		driver= new ChromeDriver();
		driver.get("https://www.orangehrm.com/en/book-a-free-demo");
		
		By country = By.id("Form_getForm_Country");
//		WebElement dropDown = driver.findElement(country);
//		
//		Select sel = new Select(dropDown);
//		
//		List<WebElement> options = sel.getOptions();
//		System.out.println(options.size());
//		
//		for(WebElement e : options) {
//			String text = e.getText();
//			System.out.println(text);
//		}
		
		//getAllOptions(country);
		selectDropDownValue(country, "India");
		
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static int getOptionsSize(List<WebElement> options) {
		return options.size();
	}
	public static void getAllOptions(By locator) {
		WebElement dropDown = getElement(locator);
		Select sel = new Select(dropDown);
		List<WebElement> options = sel.getOptions();
		System.out.println(getOptionsSize(options));
		for(WebElement e: options) {
			String text = e.getText();
			System.out.println(text);
		}
	}
	
	public static boolean selectDropDownValue(By locator,String value) {
		WebElement dropDown = getElement(locator);
		Select sel = new Select(dropDown);
		List<WebElement> options = sel.getOptions();
		boolean flag = false;
		for(WebElement e: options) {
			String text = e.getText();
			if(text.equals(value)) {
				e.click();
				System.out.println(text);
				flag = true;
				break;
			}
		}
		return flag;
	}

}
