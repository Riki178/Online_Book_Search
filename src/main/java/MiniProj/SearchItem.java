package MiniProj;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchItem {
	public static WebElement searchCount;
	
	// method for search the title
	public static void search(WebDriver driver) {
		String data = "";
		try {
			// getting the name from excel
			data = ExcelReadWrite.readExcel();
		} catch (Exception e) {
			System.out.println(e);
		}
		// fill the name in the search bar
		driver.findElement(By.xpath("//*[@id='inputbar']")).sendKeys(data);
		
		// click on the search button
		driver.findElement(By.xpath("//*[@id='btnTopSearch']")).click();
		
		// check the number of search results displayed are greater than 10 or not
		searchCount = driver.findElement(By.xpath("//*[@id=\"site-wrapper\"]/div[1]/div[2]/div[1]/div[1]/div/b"));
		String coun = searchCount.getText();
		int count = Integer.parseInt(coun);
		if(count > 10) {
			System.out.println("the number of search results displayed are greater than 10......");
		}
		else {
			System.out.println("nottttt");
		}
	}
}
