package SeleniumSessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecutorConcept {

	public static void main(String[] args) {

		
		System.setProperty("webdriver.chrome.driver","F:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://demo.guru99.com/V4/");
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		WebElement loginBtn = driver.findElement(By.name("btnLogin"));
		flash(loginBtn,driver);
		
		drawBorder(loginBtn,driver);
		
		generateAlert(driver,"There is an issue with login button in the login page");
		//driver.quit();
	}

	public static void flash(WebElement element, WebDriver driver) {
		JavascriptExecutor js =  (JavascriptExecutor) driver;
		String bgcolor = element.getCssValue("backgroundColor");
		for(int i=0 ; i<10 ; i++) {
			changeColor("rgb(0,200,0)",element,driver);
			changeColor(bgcolor,element,driver);
		}
	}
	public static void changeColor(String color, WebElement element, WebDriver driver) {
		
		JavascriptExecutor js =  (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.backgroundColor ='"+color+"'",element);
		try {
			Thread.sleep(20);
			
		}catch(InterruptedException e) {
				
		}
	}	
	public static void drawBorder(WebElement element, WebDriver driver) {
		JavascriptExecutor js =  (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border ='3px solid red'",element);
	}
	
	public static void generateAlert(WebDriver driver,String message) {
		
		JavascriptExecutor js =  (JavascriptExecutor) driver;
		js.executeScript("alert('"+message+"')");
	}
		
}
