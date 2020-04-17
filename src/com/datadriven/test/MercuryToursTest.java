package com.datadriven.test;

			import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.utility.TestNGTestUtil;

public class MercuryToursTest {

	public WebDriver driver;
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver","F:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		
		driver = new ChromeDriver();
		
		driver.get("http://newtours.demoaut.com/");
		
		driver.findElement(By.linkText("REGISTER")).click();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}
	
	@DataProvider
	
	public Iterator<Object[]> getTestData(){
		
		//in the below line we are calling directly thru class name because the method getDataFromExcel is static in nature
		ArrayList<Object[]> testData = TestNGTestUtil.getDataFromExcel();
		return testData.iterator();
	}
	
	@Test(dataProvider ="getTestData" )
	
	
	// The below function will contain exact that many columns as it is there in the excel sheet
	public void mercuryToursRegTest(String firstName,String LastName,String Phone,String Email,
			String Address1,String Address2,String City,String State,
			String PostalCode,String Country)  {
		
		//enter data : 
		
		//driver.findElement(By.linkText("REGISTER")).click();	
		driver.findElement(By.xpath("//input[@name = 'firstName']")).clear();
		driver.findElement(By.xpath("//input[@name = 'firstName']")).sendKeys(firstName);
		
		driver.findElement(By.xpath("//input[@name = 'lastName']")).clear();
		driver.findElement(By.xpath("//input[@name = 'lastName']")).sendKeys(LastName);
		
		driver.findElement(By.xpath("//input[@name = 'phone']")).clear();
		driver.findElement(By.xpath("//input[@name = 'phone']")).sendKeys(Phone);
		
		driver.findElement(By.xpath("//input[@id = 'userName']")).clear();
		driver.findElement(By.xpath("//input[@id = 'userName']")).sendKeys(Email);
		
		driver.findElement(By.xpath("//input[@name = 'address1']")).clear();
		driver.findElement(By.xpath("//input[@name = 'address1']")).sendKeys(Address1);
		
		driver.findElement(By.xpath("//input[@name = 'address2']")).clear();
		driver.findElement(By.xpath("//input[@name = 'address2']")).sendKeys(Address2);
		
		driver.findElement(By.xpath("//input[@name = 'city']")).clear();
		driver.findElement(By.xpath("//input[@name = 'city']")).sendKeys(City);
		
		driver.findElement(By.xpath("//input[@name = 'state']")).clear();
		driver.findElement(By.xpath("//input[@name = 'state']")).sendKeys(State);
		
		driver.findElement(By.xpath("//input[@name = 'postalCode']")).clear();
		driver.findElement(By.xpath("//input[@name = 'postalCode']")).sendKeys(PostalCode);
		
		Select select = new Select(driver.findElement(By.xpath("//*[@name = 'country']")));
		select.selectByVisibleText(Country);

	}
	
	@AfterTest
	public void tearDown()  {
			driver.quit();
		        
	}
}
