package SeleniumSessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelectCalendarByJS {

	public static void main(String[] args) {

		
		System.setProperty("webdriver.chrome.driver","F:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://www.makemytrip.com/");
		
		WebElement date = driver.findElement(By.xpath("//div[@class = 'fsw_inputBox dates inactiveWidget ']"));
		
		date.click();
		
		String dateVal = "Sun Jun 28 2020";
		
		WebElement element = driver.findElement(By.xpath("//div[@class='DayPicker-Day' and @aria-label = '"+dateVal+"']"));
		
		//input[@id = 'departure' and @class ='fsw_inputField font20' ]
		selectDateByJS(driver,element);
		
		//driver.quit();
		
	}

	 public static void selectDateByJS(WebDriver driver,WebElement element) {

	        JavascriptExecutor js = ((JavascriptExecutor)driver);
	        js.executeScript("arguments[0].click();", element);

	    }
	/*public static void selectDateByJS(WebDriver driver , WebElement element , String dateVal) {
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].setAttribute('value','"+dateVal+"');", element);
		
	}*/
}
