 package SeleniumSessions;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class TakeScreenShotConcept {

	public static void main(String[] args) throws IOException {
		
		System.setProperty("webdriver.chrome.driver","F:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://www.facebook.com");
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//take screenshot and store as a file format
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		//now copy the screenshot to the desired location using copyFile //method
		//FileUtils.copyFile(src,new File("F:\\Vishal_Offc Work\\Workspace\\SeleniumBasics\\src\\SeleniumSessions\\test.png"));
		
		//previous versions of eclipse used FileUtils and this eclipse version uses FileHandler.copy method
		FileHandler.copy(src,new File("F:\\Vishal_Offc Work\\Workspace\\SeleniumBasics\\src\\SeleniumSessions\\FacebookScreenShot.png"));
		
		driver.quit();
		// TODO Auto-generated method stub

	}

}
