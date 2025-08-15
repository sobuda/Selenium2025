package SeleniumSessions;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementUtil {

	private WebDriver driver;

	public ElementUtil(WebDriver driver) {
		this.driver = driver;
	}

	private void nullCheck(CharSequence... value) {
		if (value == null) {
			throw new BrowserException("===Null Value===");
		}
	}

	public boolean isElementDisplayed(By locator) {
		try {
			return getElement(locator).isDisplayed();
		} catch (NoSuchElementException e) {
			System.out.println("Element not Present: " + locator);
			return false;
		}
	}

	public void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);

	}

	public void doSendKeys(By locator, CharSequence... value) {
		nullCheck(value);
		getElement(locator).sendKeys(value);

	}

	public void doClick(By locator) {
		getElement(locator).click();
	}

	public String doElementGetText(By locator) {

		String eleText = getElement(locator).getText();
		System.out.println("Element Text:  " + eleText);
		return eleText;
	}

	public String customGetDomProperty(By locator, String value) {
		nullCheck(value);
		String propertyVal = getElement(locator).getDomProperty(value);
		System.out.println(propertyVal);
		return propertyVal;
	}

	public String customGetDomAttribute(By locator, String value) {
		nullCheck(value);
		String attributeVal = getElement(locator).getDomAttribute(value);
		System.out.println(attributeVal);
		return attributeVal;
	}

	public WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	//////////////// findElements Wrapper Methods ////////////////////////////

	public ArrayList<String> getElementsText(By locator) {
		List<WebElement> elements = getElements(locator);
		ArrayList<String> eleText = new ArrayList<String>();

		for (WebElement e : elements) {
			String aText = e.getText();
			if (aText.isEmpty()) {
				continue;
			} else {
				eleText.add(aText);
			}
		}
		return eleText;
	}

	public int listSize(List<WebElement> l) {
		return l.size();
	}

	public int listSize(By locator) {
		return getElements(locator).size();
	}

	public boolean checkElementDisplayed(By locator) {

		List<WebElement> eleText = getElements(locator);

		System.out.println(listSize(eleText));
		if (listSize(eleText) == 1) {
			return true;
		} else
			return false;
	}

	public boolean checkElementDisplayed(By locator, int expCount) {

		List<WebElement> eleText = getElements(locator);

		System.out.println(listSize(eleText));
		if (listSize(eleText) == expCount) {
			return true;
		} else
			return false;
	}

	public List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

}
