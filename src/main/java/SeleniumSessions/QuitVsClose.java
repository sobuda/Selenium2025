package SeleniumSessions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class QuitVsClose {

	public static void main(String[] args) {
		
		WebDriver driver = null;
		driver = new ChromeDriver();
		//SessionID : efb87e143c7f75b1fbdcd5bf0b955d33
		driver.get("https://www.google.com");
		
		//SessionID : efb87e143c7f75b1fbdcd5bf0b955d33
		System.out.println(driver.getTitle());
		
		//SessionID : efb87e143c7f75b1fbdcd5bf0b955d33
		System.out.println(driver.getCurrentUrl());
		
		//SessionID : efb87e143c7f75b1fbdcd5bf0b955d33
		//driver.quit();
		//b2a59a6d12142822470b7b1b9197f1f7
		driver.close();
		
		//SessionID : null
		//b2a59a6d12142822470b7b1b9197f1f7 : driver.close Session ID ->INVALID
		driver.getTitle();
		
		
		
		
		
		
	}

}
