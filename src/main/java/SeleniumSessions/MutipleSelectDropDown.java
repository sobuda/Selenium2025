package SeleniumSessions;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MutipleSelectDropDown {

	static WebDriver driver;

	public static void main(String[] args) {
		driver = new ChromeDriver();
		driver.get("https://html.com/attributes/select-multiple/");

		By locator = By.cssSelector("select[multiple]");
		WebElement multiSel = driver.findElement(locator);

		Select sel = new Select(multiSel);
		if (sel.isMultiple()) {
			sel.selectByVisibleText("American flamingo");
			sel.selectByVisibleText("Greater flamingo");
			sel.selectByVisibleText("James's flamingo");
			sel.selectByVisibleText("Lesser flamingo");
		}

		getTextOfSelectedOptions(locator, sel);
		
		System.out.println(sel.getAllSelectedOptions().size());
		sel.deselectByVisibleText("James's flamingo");

		System.out.println(sel.getAllSelectedOptions().size());
		getTextOfSelectedOptions(locator, sel);
		
		sel.deselectAll();
		System.out.println(sel.getAllSelectedOptions().size());

		
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static List<String> getTextOfSelectedOptions(By locator,Select sel) {
		List<String> optionsText = new ArrayList<String>();
		for(WebElement e: sel.getAllSelectedOptions()) {
			String text = e.getText();
			optionsText.add(text);
			System.out.println(text);
		}
		return optionsText;
	}

}
