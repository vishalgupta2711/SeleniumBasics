package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicAuth {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","F:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		
		//just after entering the url the site asks for username and password which we cannot inspect so we use the below method
		
		//http://username:password@url
		//http://username:password@the-internet.herokuapp.com/basic_auth
		
		driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
		// TODO Auto-generated method stub

		String pageMessage = driver.findElement(By.cssSelector("p")).getText();
		System.out.println(pageMessage);
		
		driver.quit();
	}

}
