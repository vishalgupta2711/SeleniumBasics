package SeleniumSessions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DropDownHelperClass {

	static WebDriver driver;
	
	public static void main(String[] args) {


		System.setProperty("webdriver.chrome.driver","F:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.get("https://www.makemytrip.com/");
			
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.findElement(By.id("fromCity")).click();
		
		/*List <WebElement> listFrom = driver.findElements(By.xpath("//ul[@role = 'listbox']//li"));
		System.out.println(listFrom.size());
		
		for(int i = 0 ; i<listFrom.size() ; i++) {
			
			System.out.println(listFrom.get(i).getText());
			
			if(listFrom.get(i).getText().contains("Bangkok, Thailand")) {
				driver.findElement(By.xpath("//ul[@role = 'listbox']//li/descendant::div[@class = 'calc60']//p[contains(text(),'Bangkok, Thailand')]")).click();
				System.out.println("Bangkok selected");
				break;
			}
			else {
				System.out.println("Select proper dropdown");
			}
		}*/
		//************selecting toCity***************
		
		//driver.findElement(By.id("fromCity")).click();
		
		String dropdownList = "//ul[@role = 'listbox']//li";
		String dropdownValue = "Bangkok, Thailand";
		String dropdownLocator = "//ul[@role = 'listbox']//li/descendant::div[@class = 'calc60']//p[contains(text(),'Bangkok, Thailand')]";
		
		dropdownHelperMethod(dropdownList ,dropdownValue  ,dropdownLocator );
		dropdownHelperMethod("//ul[@role = 'listbox']//li" , "Dubai, United Arab Emirates" , "//ul[@role = 'listbox']//li/descendant::div[@class = 'calc60']//p[contains(text(),'Dubai, United Arab Emirates')]" );
				
	}
	
	public static void dropdownHelperMethod(String dropdownList , String dropdownValue , String dropdownLocator) {
		
		List <WebElement> listTo = driver.findElements(By.xpath(dropdownList));
		System.out.println(listTo.size());
		
		for(int i = 0 ; i<listTo.size() ; i++) {
			
			System.out.println(listTo.get(i).getText());
			
			if(listTo.get(i).getText().contains(dropdownValue)) {
				driver.findElement(By.xpath(dropdownLocator)).click();
				System.out.println("Dropdown value :"+dropdownValue+": selected");
				break;
			}
			else {
				System.out.println("Select proper dropdown");
			}
		}
	}

}
