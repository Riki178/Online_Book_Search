package MiniProj;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverSetupChrome {
	
	public static WebDriver webDriver;
	public static String url = "https://www.bookswagon.com/";
	public static WebElement searchCount;
	
	// method for set the Edge driver
	public static WebDriver getWebDriver() {
		
		// get the current location of the webdriver manager
		System.setProperty("webdriver.chrome.driver", "C:\\\\chromedriver-win64\\\\chromedriver.exe");
		webDriver = new ChromeDriver();
		
		// get the url
		webDriver.get(url);
		 
		// maximizing the browser window
		webDriver.manage().window().maximize();
		
		// return the webDriver
		return webDriver;
	}

}
