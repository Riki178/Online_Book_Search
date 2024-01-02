package MiniProj;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ScrollPage {
	
	// code for scrolling the page
	public static void scroll(WebDriver driver) {
    	JavascriptExecutor js = (JavascriptExecutor)driver;   	
    	WebElement end = driver.findElement(By.xpath("//*[@id=\"listSearchResult\"]/div[2]/div[3]/div[4]/div[3]/table/tbody/tr[1]/td[1]/div"));
    	js.executeScript("arguments[0].scrollIntoView();",end);
    	
    }
}
