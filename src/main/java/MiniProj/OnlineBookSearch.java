package MiniProj;

import java.io.File;
import java.io.IOException;
import java.lang.*;
import java.time.Duration;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class OnlineBookSearch {
	
	public static String[] arr = new String[5];
	public static WebDriver driver;
	public static String url = "https://www.bookswagon.com/";
	public static WebElement searchCount;
	
	// method for create the chrome driver instance
	public static WebDriver createDriverChrome() {
		DriverSetupChrome name = new DriverSetupChrome();
		driver = name.getWebDriver();
		return driver;
	}
	
	// method for create the edge driver instance
	public static WebDriver createDriverEdge() {
		DriverSetupEdge name = new DriverSetupEdge();
		driver = name.getWebDriver();
		return driver;
	}
	
	
	// click on Sort by “Price Low to High”
	public static void sortBy() {
		WebElement drpel = driver.findElement(By.xpath("//*[@id='ddlSort']"));
		Select drp = new Select(drpel);
		drp.selectByVisibleText("Price - Low to High");
		
	}
	
	// get the name and price of first 5 displayed results and print
    public static String[] getName() {
    	List<WebElement> titles = driver.findElements(By.xpath("//div[@class='title']/a"));
    	
    	for(int i=0;i<5;i++) {
    		arr[i] = titles.get(i).getText();
    	}    	return arr;
	}
      
    
    // code for writing the output data into the excel
    public static void write() {
    	try {
			ExcelReadWrite.writeExcel();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    // method for closing the browser
    public static void driverClose() {
    	driver.quit();
    }
    

    // the main method
	public static void main(String[] args) throws Exception {
		
		System.out.println("Enter a option: ");
		System.out.println("Press 1 for Chrome browser \nPress 2 for Edge browser \nPress 3 to exit");
		Scanner sc = new Scanner(System.in);
		int opt = sc.nextInt();
		switch(opt)
		{
		case 1:createDriverChrome();
		break;
		
		case 2: createDriverEdge();
		break;
		
		case 3: System.out.println("program ended");
		break;
		
		default: System.out.println("Not in the options!");
		}
		if(driver == null) {
			System.exit(0);
		}
		else {
		
		// invoking the search method
		SearchItem.search(driver);
		Thread.sleep(2000);
		
		// invoking the sortBy method
		sortBy();
		Thread.sleep(5000);
		
		
		TakeSS.screenshot("screenShot1.png", driver);
		ScrollPage.scroll(driver);
		TakeSS.screenshot("screenshot2.png", driver);
		
		// storing the names in a string array by invoking the getName method
		String[] ans = getName();
		for(String a:ans) {
			System.out.println(a);
		}
		
		Thread.sleep(4000);
		
		// invoking the write method
		write();
		
		
		// invoking the driverClose method for closing all the browsers
		driverClose();
		}

	}
}

