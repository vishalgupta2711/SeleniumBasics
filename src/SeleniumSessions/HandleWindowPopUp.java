package SeleniumSessions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleWindowPopUp {

	public static void main(String[] args) throws InterruptedException {
		
		
		System.setProperty("webdriver.chrome.driver","F:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://www.popuptest.com/");
		driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[2]/table/tbody/tr[2]/td[1]/font[3]/b/a")).click();
		Thread.sleep(2000);
		
		Set <String> handler = driver.getWindowHandles();
		Iterator <String> it = handler.iterator();
		
		String ParentWindowId = it.next();
		System.out.println("Parent window id is "+ParentWindowId);
		
		String ChildWindowId = it.next();
		System.out.println("Child window id is "+ChildWindowId);
		
		driver.switchTo().window(ChildWindowId);
		Thread.sleep(2000);
		
		 System.out.println("child window popup title is :"+driver.getTitle());
		 
		 driver.close();
		 
		 driver.switchTo().window(ParentWindowId);
		 Thread.sleep(2000);
		 
		 System.out.println("parent window popup title is :"+driver.getTitle());
		 
		

	}

}
