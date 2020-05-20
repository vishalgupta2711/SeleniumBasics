	package SeleniumSessions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchTest {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver","F:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("http://www.google.com");
		
		driver.findElement(By.xpath("//input[@class = 'gLFyf gsfi']")).sendKeys("testing");
		List <WebElement> list = driver.findElements(By.xpath("//ul[@role = 'listbox']//li/descendant::div[@class = 'sbl1']"));
		System.out.println("total no of suggestions in search box : "+ list.size());
		
		for(int i = 0 ; i<list.size() ; i++) {
			System.out.println(list.get(i).getText());
			if(list.get(i).getText().contains("testing kit for coronavirus")) {
				list.get(i).click();
				break;
			}
		}
		System.out.println("program reached end successfully");
		
	//	driver.quit();
	}

}
