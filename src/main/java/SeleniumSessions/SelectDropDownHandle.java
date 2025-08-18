package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDropDownHandle {

	static WebDriver driver;

	public static void main(String[] args) {

		System.out.println("Welcome!!");
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/r.php?entry_point=login");
		By dayBy = By.id("day");
		By monthBy = By.id("month");
		By yearBy = By.id("year");

//		WebElement eDay = driver.findElement(dayBy);
//		Select day = new Select(eDay);
//		day.selectByIndex(0);
//		
//		WebElement eMonth = driver.findElement(monthBy);
//		Select month = new Select(eMonth);
//		month.selectByValue("5");
//		
//		WebElement eYear = driver.findElement(yearBy);
//		Select year = new Select(eYear);
//		year.selectByVisibleText("2023");

		boolean flag;
		flag = indexSelect(dayBy, 9);
		System.out.println("Option Selected using index: "+flag);
		
		flag = visibleTextSelect(monthBy, "Dec");
		System.out.println("Option Selected using visibleTextSelect: "+flag);

		flag = valueSelect(yearBy, "2005");
		System.out.println("Option Selected using valueSelect: "+flag);


		flag = partialVisibleTextSelect(monthBy, "No");
		System.out.println("Option Selected using partialVisibleTextSelect: "+flag);

		flag = indexSelect(monthBy, 13);
		System.out.println("Option Selected using indexSelect: "+flag);

	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public static boolean indexSelect(By locator, int index) {
		Select dropDown = new Select(getElement(locator));
		try {
			dropDown.selectByIndex(index);
			return true;
		} catch (NoSuchElementException e) {
			System.out.println("Index not Found: " + index);
			return false;
		}
	}

	public static boolean valueSelect(By locator, String value) {
		Select dropDown = new Select(getElement(locator));
		try {
			dropDown.selectByValue(value);
			return true;
		} catch (NoSuchElementException e) {
			System.out.println("value Not Found: " + value);
			return false;
		}
	}

	public static boolean visibleTextSelect(By locator, String visibleText) {
		Select dropDown = new Select(getElement(locator));
		try {

			dropDown.selectByVisibleText(visibleText);
			return true;
		} catch (NoSuchElementException e) {
			System.out.println("VisibleText Not Found: " + visibleText);
			return false;
		}

	}

	public static boolean partialVisibleTextSelect(By locator, String partialText) {
		Select dropDown = new Select(getElement(locator));
		try {
			dropDown.selectByContainsVisibleText(partialText);
			return true;
		} catch (NoSuchElementException e) {
			System.out.println("PartialText Not Found: " + partialText);
			return false;
		}

	}

}
