package SeleniumSessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaleElementReferenceExceptionDemo {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver","F:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://classic.crmpro.com/login.cfm");
		WebElement username = driver.findElement(By.name("username"));
		username.sendKeys("1stTimeUserName");
		
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("xyz");
		
		driver.navigate().refresh();
		
		try {
			username.sendKeys("pavanoltraining");// this statement gives StaleElementReferenceException
		}
		catch(StaleElementReferenceException e) {
			username = driver.findElement(By.name("username"));
			username.sendKeys("2ndTimeUserName");
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

}
