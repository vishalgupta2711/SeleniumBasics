package com.datadriven.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.excel.utility.Xls_Reader;

public class DataDrivenTest {

	public static void main(String[] args) {
		
	//Get cell data from excel
		
	Xls_Reader reader = new Xls_Reader("F:\\Vishal_Offc Work\\Workspace\\SeleniumBasics\\src\\com\\testdata\\NewToursRegTestData.xlsx");
	
	String FirstName = reader.getCellData("RegTestData", "FirstName", 2);
	System.out.println(FirstName);
	
	String LastName = reader.getCellData("RegTestData", "LastName", 2);
	System.out.println(LastName);
	
	String Phone = reader.getCellData("RegTestData", "Phone", 2);
	System.out.println(Phone);
	
	String Email = reader.getCellData("RegTestData", "Email", 2);
	System.out.println(Email);
	
	String Address1 = reader.getCellData("RegTestData", "Address1", 2);
	System.out.println(Address1);
	
	String Address2 = reader.getCellData("RegTestData", "Address2", 2);
	System.out.println(Address2);
	
	String City = reader.getCellData("RegTestData", "City", 2);
	System.out.println(City);
	
	String State = reader.getCellData("RegTestData", "State", 2);
	System.out.println(State);
	
	String PostalCode = reader.getCellData("RegTestData", "PostalCode", 2);
	System.out.println(PostalCode);
	
	String Country = reader.getCellData("RegTestData", "Country", 2);
	System.out.println(Country);
	
	//WebDriver code
	System.setProperty("webdriver.chrome.driver","F:\\Drivers\\chromedriver_win32\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	
	driver.get("http://newtours.demoaut.com/");
	
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	
	driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
	driver.findElement(By.linkText("REGISTER")).click();	
	driver.findElement(By.xpath("//input[@name = 'firstName']")).sendKeys(FirstName);
	driver.findElement(By.xpath("//input[@name = 'lastName']")).sendKeys(LastName);
	driver.findElement(By.xpath("//input[@name = 'phone']")).sendKeys(Phone);
	driver.findElement(By.xpath("//input[@id = 'userName']")).sendKeys(Email);
	driver.findElement(By.xpath("//input[@name = 'address1']")).sendKeys(Address1);
	driver.findElement(By.xpath("//input[@name = 'address2']")).sendKeys(Address2);
	driver.findElement(By.xpath("//input[@name = 'city']")).sendKeys(City);
	driver.findElement(By.xpath("//input[@name = 'state']")).sendKeys(State);
	driver.findElement(By.xpath("//input[@name = 'postalCode']")).sendKeys(PostalCode);
	
	Select select = new Select(driver.findElement(By.xpath("//*[@name = 'country']")));
	select.selectByVisibleText(Country);
	
	/*driver.findElement(By.xpath("//input[@id = 'email']")).sendKeys(FirstName);
	driver.findElement(By.xpath("//input[@type = 'password']")).sendKeys(FirstName);
	driver.findElement(By.xpath("//input[@name = 'confirmPassword']")).sendKeys(FirstName);*/
	
	
		

	}

}
