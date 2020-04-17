package SeleniumSessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitConcept {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","F:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
				
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("http://www.facebook.com");
		clickON(driver,driver.findElement(By.xpath("//input[@value = 'Log In']")),20);	//login button
		System.out.println("login button clicked");
		
		Thread.sleep(2000);
		driver.navigate().back();
		
		clickON(driver,driver.findElement(By.xpath("//*[@id=\"reg_pages_msg\"]/a")),10); // create a page link
		System.out.println(" create page link clicked");
		
		driver.quit();
		// TODO Auto-generated method stub
	}
	
	public static void clickON(WebDriver driver,WebElement locator,int timeout) {
			new WebDriverWait(driver,timeout).ignoring(StaleElementReferenceException.class).
			until(ExpectedConditions.elementToBeClickable(locator));
			locator.click();
}
}
