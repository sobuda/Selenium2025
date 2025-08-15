package SeleniumSessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TotalLinks {

	static WebDriver driver;
	static By locator;
	
	public static void main(String[] args) {

		driver = new ChromeDriver();
		driver.get("https://www.flipkart.com");
		
		//List<WebElement> listOfLinks = driver.findElements(By.tagName("a"));
		
		//ArrayList<String> linksText = new ArrayList<String>();
		
		//int count = listOfLinks.size();
		//System.out.println("count = "+count);

//		
//		for(WebElement e: listOfLinks) {
//			String aText = e.getText() ;
//			if(aText.isEmpty()) {
//				count--;
//				continue;
//			}
//			else {
//				linksText.add(aText);
//			}
//			
//		}
//		System.out.println("count = "+count);
//		System.out.println("===================================================");
//		
		locator = By.tagName("a");
		List<WebElement> listOfLinks = getElements();
		System.out.println(listSize(listOfLinks));
		
		ArrayList<String> linksText = getElementsText();
		
		for (String e : linksText) {
			System.out.println(e);
		}
		
	}
	
	////////Wrapper Methods///////
	
	public static ArrayList<String> getElementsText(){
		List<WebElement> elements = getElements();
		ArrayList<String> eleText = new ArrayList<String>();
		
		for(WebElement e: elements) {
			String aText = e.getText() ;
			if(aText.isEmpty()) {
				continue;
			}
			else {
				eleText.add(aText);
			}
		}
		return eleText;
	}
	
	public static int listSize(List<WebElement> l) {
		return l.size();
	}
	
	

	public static List<WebElement>  getElements() {
	return driver.findElements(locator);
	}
	
	
	
}
