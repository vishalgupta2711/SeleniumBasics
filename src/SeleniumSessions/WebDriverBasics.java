package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverBasics {

	public static void main(String[] args) {
		
		
		System.setProperty("webdriver.chrome.driver","F:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//driver.get("http://www.google.com");
		String baseurl = "http://www.google.com";
		driver.get(baseurl);
		String title = driver.getTitle();
		System.out.println(title);
		if(title.equals("Google"))
		{
			System.out.println("correct title");
		}
		else
		{
			System.out.println("incorrect title");
		}

		driver.quit();
		// TODO Auto-generated method stub

	}

}
