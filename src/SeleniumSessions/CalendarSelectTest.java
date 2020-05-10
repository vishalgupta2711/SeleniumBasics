package SeleniumSessions;

import java.util.NoSuchElementException;
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
		
		driver.get("https://www.makemytrip.com/");
		
		driver.findElement(By.xpath("//div[@class = 'fsw_inputBox dates inactiveWidget ']")).click();
		
		String date = "10-Jun-2020";
		String dateArr[] = date.split("-");
		String day = dateArr[0];
		String month = dateArr[1];
		String year = dateArr[2];/*
		
		String beforeXpath = "//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[3]/div[1]/div/div/div/div[2]/div/div[2]/div[2]/div[3]/div[";
		String afterXpath = "]/div["; 
		
		int totalWeekDays = 7;
		
		for(int rowNum = 1 ; rowNum <=6 ; rowNum++) {
			for(int colNum = 2 ; colNum<= totalWeekDays ; colNum++) {
				String dayVal = driver.findElement(By.xpath(beforeXpath+rowNum+afterXpath+colNum+"]/div")).getText();
				System.out.println(dayVal);
			}
		}*/
		String beforeXpath = "//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[3]/div[1]/div/div/div/div[2]/div/div[2]/div[2]/div[3]/div[";
		String afterXpath =  "]/div[";
		
		int totalWeekDays = 7;
		boolean flag = false;
		String dayVal = null;
		for(int rowNum = 1 ; rowNum <=6 ; rowNum++) {
			for(int colNum = 1 ; colNum<= totalWeekDays ; colNum++) {
				try 
				{
					dayVal = driver.findElement(By.xpath(beforeXpath+rowNum+afterXpath+colNum+"]")).getText();
				}
				catch(NoSuchElementException e) 
				{
					System.out.println("Please enter the correct date value :");
					flag = false;
					break;
				}
				System.out.println(dayVal);
				if(dayVal.contains(day)) {
					driver.findElement(By.xpath(beforeXpath+rowNum+afterXpath+colNum+"]")).click();
					flag = true;
					break;
				}
			}
			if(flag) {
				break;
			}
		}

		//driver.quit();
		// TODO Auto-generated method stub

	}
	}
	
