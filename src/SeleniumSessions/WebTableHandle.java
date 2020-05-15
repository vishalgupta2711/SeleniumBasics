package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.excel.utility.Xls_Reader;

public class WebTableHandle {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","F:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		
		//*[@id="customers"]/tbody/tr[2]/td[1]
		//*[@id="customers"]/tbody/tr[3]/td[1]
		//*[@id="customers"]/tbody/tr[4]/td[1]
		
		//*[@id="customers"]/tbody/tr[7]/td[1]
		
		String beforeXpath_Company = "//*[@id=\"customers\"]/tbody/tr[";
		String afterXpath_Company = "]/td[1]";
		
		String beforeXpath_Contact = "//*[@id=\"customers\"]/tbody/tr[";
		String afterXpath_Contact = "]/td[2]";
		
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id = 'customers']//tr"));
		System.out.println("total no of rows :" +rows.size());
		int rowCount = rows.size();
		
		Xls_Reader reader = new Xls_Reader("F:\\Vishal_Offc Work\\Workspace\\SeleniumBasics\\src"
				+ "\\com\\testdata\\NewToursRegTestData.xlsx");
		
		
		if(!reader.isSheetExist("TableData")) {
			
			reader.addSheet("TableData");
			reader.addColumn("TableData", "Company Name");
			reader.addColumn("TableData", "Contact Name");
		}
		
		for(int i = 2 ; i<=rowCount ; i++) {
			
			//xpath for Company Name column
			String actualXpath_Company = beforeXpath_Company+i+afterXpath_Company;
			System.out.println(actualXpath_Company);
			String companyName = driver.findElement(By.xpath(actualXpath_Company)).getText();
			System.out.println(companyName);
			
			reader.setCellData("TableData", "Company Name", i, companyName);
			
			//xpath for Contact Name column
			String actualXpath_Contact = beforeXpath_Contact+i+afterXpath_Contact;
			System.out.println(actualXpath_Contact);
			String contactName = driver.findElement(By.xpath(actualXpath_Contact)).getText();
			System.out.println(contactName);
			
			reader.setCellData("TableData", "Contact Name", i, contactName);
		}
		driver.quit();
	}

}
