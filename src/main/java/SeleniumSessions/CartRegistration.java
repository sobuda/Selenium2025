package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartRegistration {

	public static void main(String[] args) {

		BrowserUtil bUtil = new BrowserUtil();
		WebDriver driver = bUtil.initialiseDriver("Chrome");

		bUtil.launchURL("https://naveenautomationlabs.com/opencart/index.php?route=account/login");

		bUtil.getPageTitle();

		ElementUtil eUtil = new ElementUtil(driver);

		By regLink = By.linkText("Register");

		eUtil.doClick(regLink);

		By fNameBy = By.id("input-firstname");
		eUtil.doSendKeys(fNameBy, "Kiran");
		eUtil.customGetDomProperty(fNameBy, "value");
		eUtil.customGetDomAttribute(fNameBy, "type");

		By lNameBy = By.name("lastname");
		eUtil.doSendKeys(lNameBy, "Kumar");
		eUtil.customGetDomProperty(lNameBy, "value");

		By emailBy = By.xpath("//*[@id=\"input-email\"]");
		eUtil.doSendKeys(emailBy, "kirann0400@gmail.com");
		eUtil.customGetDomProperty(emailBy, "value");

		By telBy = By.cssSelector("#input-telephone");
		eUtil.doSendKeys(telBy, "9876543234");
		eUtil.customGetDomProperty(telBy, "value");

		By pswBy = By.xpath("//*[@id=\"input-password\"]");
		eUtil.doSendKeys(pswBy, "Gandhi@123");
		eUtil.customGetDomProperty(pswBy, "value");

		By confirmPswBy = By.cssSelector("#input-confirm");
		eUtil.doSendKeys(confirmPswBy, "Gandhi@123");
		eUtil.customGetDomProperty(confirmPswBy, "value");

		By agreeBy = By.name("agree");
		eUtil.doClick(agreeBy);
		eUtil.customGetDomProperty(agreeBy, "value");

		By contBy = By.xpath("//*[@id=\"content\"]/form/div/div/input[2]");////*[@id="content"]/form/div/div/input[2]
		eUtil.customGetDomProperty(contBy, "value");
		eUtil.doClick(contBy);

		String pageTitleBy = bUtil.getPageTitle();

		if (pageTitleBy.equals("Your Account Has Been Created!")) {
			System.out.println("Title is correct: PASS");
		} else
			System.out.println("Title is INCorrect: FAIL");

		String pageURL = bUtil.getPageUrl();
		if (pageURL.endsWith("success")) {
			System.out.println("URL contains SUCCESS: PASS");
		} else
			System.out.println("URL must contain success when account is created: FAIL");

		By successMsgBy = By.tagName("h1");
		String actMsg = eUtil.doElementGetText(successMsgBy);

		if (actMsg.equals("Your Account Has Been Created!")) {
			System.out.println("Msg is correct: PASS");
		} else
			System.out.println("Msg is INCorrect: FAIL");

		By logoutBy = By.linkText("Logout");
		eUtil.doClick(logoutBy);

		By logoBy = By.className("img-responsive");
		eUtil.doClick(logoBy);

		bUtil.browserQuit();

	}

}
