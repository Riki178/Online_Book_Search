package MiniProj;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TakeSS {
	
	// code for taking the screenshots of output pages
	public static void screenshot(String scName,WebDriver driver) throws IOException{
    	TakesScreenshot ts = (TakesScreenshot)driver;
    	File src = ts.getScreenshotAs(OutputType.FILE);
    	File trg = new File("C:\\Users\\2303555\\OneDrive - Cognizant\\Desktop\\Eclipse codes\\Mini\\src\\main\\resources\\Screenshots\\"+scName);
    	FileUtils.copyFile(src,trg);
    }
}
