package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ElementEnabledDisabledSelected {

	public static void main(String[] args) {

		BrowserUtil bUtil = new BrowserUtil();
		WebDriver driver = bUtil.initialiseDriver("Chrome");

		bUtil.launchURL("https://seleniumpractise.blogspot.com/2016/09/how-to-work-with-disable-textbox-or.html");

		bUtil.getPageTitle();


		By pswBy = By.id("pass");

		boolean pswDisplayed = driver.findElement(pswBy).isDisplayed();

		System.out.println(pswDisplayed);

		boolean pswEnabled = driver.findElement(pswBy).isEnabled();

		System.out.println(pswEnabled);

		driver.navigate().to("https://naveenautomationlabs.com/opencart/index.php?route=account/register");

		bUtil.getPageTitle();
		By privacyChkBox = By.name("agree");

		System.out.println(driver.findElement(privacyChkBox).isSelected());

		driver.findElement(privacyChkBox).click();

		System.out.println(driver.findElement(privacyChkBox).isSelected());

		driver.navigate().back();

		bUtil.browserQuit();

	}

}
