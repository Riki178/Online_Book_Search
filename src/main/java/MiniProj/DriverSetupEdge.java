package MiniProj;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverSetupEdge {

	// method for set the chrome driver
	public static WebDriver webDriver;
	public static String url = "https://www.bookswagon.com/";
	public static WebElement searchCount;
	
	public static WebDriver getWebDriver() {
		
		// get the current location of the webdriver manager
		System.setProperty("webdriver.chrome.driver", "C:\\\\chromedriver-win64\\\\chromedriver.exe");
		webDriver = new EdgeDriver();
		
		// get the url
		webDriver.get(url);
		
		// maximizing the browser window
		webDriver.manage().window().maximize();
		
		// return the webDriver
		return webDriver;
	}
}
