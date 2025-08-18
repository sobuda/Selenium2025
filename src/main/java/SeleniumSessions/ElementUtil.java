package SeleniumSessions;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

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
	
	//================GET WEBELEMENTS USING BY LOCATORS===================

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
	
	//==============SELECT DROPDOWN UTILS=================
	
	
	public  boolean indexSelect(By locator, int index) {
		Select dropDown = new Select(getElement(locator));
		try {
			dropDown.selectByIndex(index);
			return true;
		} catch (NoSuchElementException e) {
			System.out.println("Index not Found: " + index);
			return false;
		}
	}

	public  boolean valueSelect(By locator, String value) {
		Select dropDown = new Select(getElement(locator));
		try {
			dropDown.selectByValue(value);
			return true;
		} catch (NoSuchElementException e) {
			System.out.println("value Not Found: " + value);
			return false;
		}
	}

	public  boolean visibleTextSelect(By locator, String visibleText) {
		Select dropDown = new Select(getElement(locator));
		try {

			dropDown.selectByVisibleText(visibleText);
			return true;
		} catch (NoSuchElementException e) {
			System.out.println("VisibleText Not Found: " + visibleText);
			return false;
		}

	}

	public  boolean partialVisibleTextSelect(By locator, String partialText) {
		Select dropDown = new Select(getElement(locator));
		try {
			dropDown.selectByContainsVisibleText(partialText);
			return true;
		} catch (NoSuchElementException e) {
			System.out.println("PartialText Not Found: " + partialText);
			return false;
		}

	}
	
	public  int getOptionsSize(List<WebElement> options) {
		return options.size();
	}
	
	public  List<String> getAllOptions(By locator) {
		WebElement dropDown = getElement(locator);
		Select sel = new Select(dropDown);
		List<WebElement> options = sel.getOptions();
		List<String> optionsTextList = new ArrayList<String>();
		System.out.println(getOptionsSize(options));
		for(WebElement e: options) {
			String text = e.getText();
			optionsTextList.add(text.trim());
		}
		return optionsTextList;
	}

	public boolean selectDropDownValue(String value, By locator) {
		 List<String> optionsText = getAllOptions(locator);
		 if(optionsText.contains(value)) {
			 for(String e: optionsText) {
				 if(e.equals(value)) {
					 getElement(locator);
					 System.out.println(e);
				 }
			 }
			 return true;
		 }
		 else {
			 return false;
		 }
		
	}
	public  boolean selectDropDownValue(By locator,String value) {
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
	
	//================GET WEBELEMENTS USING BY LOCATORS===================

	public List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}
	
	

}
