package TestNGListenerConcept;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
	
	public static WebDriver driver;
	
	@SuppressWarnings("deprecation")
	public static void initialization() {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Prakash\\eclipse-workspace\\FailedTestNGTestcasesScreenshots\\chromedriver.exe"); 
		 driver = new ChromeDriver();
		 driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		 driver.get("http://www.google.com");
		 
	}
	
	
	public void failed(String testMethodName) {
		 
		File srcfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcfile, new File("C:\\Users\\Prakash\\eclipse-workspace"
					+ "\\FailedTestNGTestcasesScreenshots\\Screenshots\\"+testMethodName+"_"+".jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	

}
