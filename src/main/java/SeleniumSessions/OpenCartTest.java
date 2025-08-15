package SeleniumSessions;

import java.net.MalformedURLException;
import java.net.URL;

public class OpenCartTest {

	public static void main(String[] args) {

		BrowserUtil util = new BrowserUtil();
		//System.out.println(util.toString());

		util.initialiseDriver("chrome");

		/// util.launchURL("https://naveenautomationlabs.com/opencart/index.php?route=account/login");

		try {
			util.launchURL(new URL("https://naveenautomationlabs.com/opencart/index.php?route=account/login"));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		String pageTitle = util.getPageTitle();
		String pageURL = util.getPageUrl();

		if (pageTitle.equals("Account Login")) {
			System.out.println("Title is Correct: PASS");
		} else
			System.out.println("Title is INCorrect: FAIL");

		if (pageURL.equals("https://naveenautomationlabs.com/opencart/index.php?route=account/login")) {
			System.out.println("Current URL is Correct: PASS");
		}

		else
			System.out.println("Current URL is INCorrect: FAIL");

		util.browserQuit();
		//util.browserClose();
	}

}
