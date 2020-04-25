package SeleniumSessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CalendarSelectTest {

	public static void main(String[] args) {
		
		
		System.setProperty("webdriver.chrome.driver","F:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("http://demo.guru99.com/V4/");
		
		driver.findElement(By.xpath("//input[@name = 'uid']")).sendKeys("mngr256562");
		driver.findElement(By.xpath("//input[@name = 'password']")).sendKeys("gAdurYp");
		driver.findElement(By.xpath("//input[@name = 'btnLogin']")).click();
		
		driver.findElement(By.xpath("//a[contains(text(),'New Customer')]")).click();
			
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//*[@id=\"dob\"]"))).build().perform();
		
		
		System.out.println("program reached end successfully");
		
		driver.quit();
		// TODO Auto-generated method stub

	}

}
