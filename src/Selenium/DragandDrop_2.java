package Selenium;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class DragandDrop_2 
{
	@Test
	public void dragandDrop()
	{
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.get("https://jqueryui.com/droppable/");
		
		driver.switchTo().frame(0);
		
		WebElement dragElement = driver.findElement(By.id("draggable"));
		WebElement dropElement = driver.findElement(By.id("droppable"));
		
		dragAndDrop(driver, dragElement, dropElement);
	}
	
	public static void dragAndDrop(WebDriver driver, WebElement sourceElement, WebElement destinationElement)
	{
		Actions actions = new Actions(driver);
		actions.clickAndHold(sourceElement).pause(Duration.ofSeconds(2)).moveToElement(destinationElement).pause(Duration.ofSeconds(2)).release().build().perform();
	}
}
