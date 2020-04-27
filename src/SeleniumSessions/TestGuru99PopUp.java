package SeleniumSessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestGuru99PopUp {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","F:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
				//alert.dismiss();// this is used to cancel the alert
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("http://demo.guru99.com/V4/");
		
		driver.findElement(By.xpath("//input[@name = 'uid']")).sendKeys("mngr256562");
		driver.findElement(By.xpath("//input[@name = 'password']")).sendKeys("gAdurYp");
		driver.findElement(By.xpath("//input[@name = 'btnLogin']")).click();
		Thread.sleep(5000);
		
		/*JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,250)");*/
		
		//driver.switchTo().frame("flow_close_btn_iframe");
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[title='Flow Close Button']")));
		Boolean frameClose = driver.findElement(By.xpath("//div[@id = 'closeBtn']")).isDisplayed();
		System.out.println(frameClose);
		
		//In the below line of code I am waiting for the close btn in the add to appear before clicking on it.
		
		new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id = 'closeBtn']"))).click();
	
		// Switching back from the frame to the original web page.
		
		driver.switchTo().defaultContent();
		
		
		WebElement depositElement = driver.findElement(By.xpath("//a[contains(text(),'Deposit')]"));
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", depositElement);
		
		System.out.println("program reached end successfully");
		
		driver.quit();
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub

	}

}
