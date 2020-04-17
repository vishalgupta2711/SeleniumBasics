package com.datadriven.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.excel.utility.Xls_Reader;

public class ParameterizeTest {

	public static void main(String[] args) {
		
		//DataDriven Approach(parameterization) -- used to create data driven framework: driving the test data from excel files	
		//get test data from excel
		
		Xls_Reader reader = new Xls_Reader("F:\\Vishal_Offc Work\\Workspace\\SeleniumBasics\\src\\com\\testdata\\NewToursRegTestData.xlsx");
		int rowCount = reader.getRowCount("RegTestData");
		
		//WebDriver code
		reader.addColumn("RegTestData", "Status");
		
		System.setProperty("webdriver.chrome.driver","F:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://newtours.demoaut.com/");
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		for(int rowNum = 2 ; rowNum<=rowCount ; rowNum++) 
		{
			String FirstName = reader.getCellData("RegTestData", "FirstName", rowNum);
			System.out.println(FirstName);
			
			String LastName = reader.getCellData("RegTestData", "LastName", rowNum);
			System.out.println(LastName);
			
			String Phone = reader.getCellData("RegTestData", "Phone", rowNum);
			System.out.println(Phone);
			
			String Email = reader.getCellData("RegTestData", "Email", rowNum);
			System.out.println(Email);
			
			String Address1 = reader.getCellData("RegTestData", "Address1", rowNum);
			System.out.println(Address1);
			
			String Address2 = reader.getCellData("RegTestData", "Address2", rowNum);
			System.out.println(Address2);
			
			String City = reader.getCellData("RegTestData", "City", rowNum);
			System.out.println(City);
			
			String State = reader.getCellData("RegTestData", "State", rowNum);
			System.out.println(State);
			
			String PostalCode = reader.getCellData("RegTestData", "PostalCode", rowNum);
			System.out.println(PostalCode);
			
			String Country = reader.getCellData("RegTestData", "Country", rowNum);
			System.out.println(Country);
			
			//enter data
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
			
			reader.setCellData("RegTestData", "Status", rowNum, "Pass");
			/*driver.findElement(By.xpath("//input[@id = 'email']")).sendKeys(FirstName);
			driver.findElement(By.xpath("//input[@type = 'password']")).sendKeys(FirstName);
			driver.findElement(By.xpath("//input[@name = 'confirmPassword']")).sendKeys(FirstName);*/

		}
	driver.quit();	
		

	}

}
