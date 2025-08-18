package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DropDownHandlingWithoutSelect {

	static WebDriver driver;
	
	public static void main(String[] args) {

		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/en/book-a-free-demo");

		String countryValue = "Namibia";
		
//		By countrySelect = By.cssSelector("select[id=Form_getForm_Country] option[value="+countryValue+"]");
//		WebElement e = driver.findElement(countrySelect);
//		e.click();
//		System.out.println(e.getText());
		
		if(dropDownWithoutSelectClass(countryValue)) {
			System.out.println("Country Selected: "+countryValue);
		}
		else {
			System.out.println("Country Not Present on the list: "+countryValue);
		}
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	public static boolean dropDownWithoutSelectClass(String value){
		By locator = By.cssSelector("select[id=Form_getForm_Country] option[value="+value+"]");

		try {
		WebElement ele = getElement(locator);
		ele.click();
		return true;
		}catch(NoSuchElementException e) {
			System.out.println("No such Element with value: "+value);
			return false;
		}
		
	}

}
