package SeleniumSessions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import junit.framework.Assert;

public class ComparingDropDowns {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver","F:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://chercher.tech/practice/dropdowns");
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		WebElement originalDropdown = driver.findElement(By.cssSelector("select#first"));
		
		Select select = new Select(originalDropdown);
		
	    List <WebElement> originalDropdownList = select.getOptions();
	    
	   System.out.println(originalDropdownList.size());
	   
	   ArrayList <String> mainList = new ArrayList<String>();
	   ArrayList <String> tempList = new ArrayList<String>(); // sorted dropdown values will be stored in this list
	   
	   //this is advance for loop, this will also work in this program
	 /*  for(WebElement e : originalDropdownList) {
		  mainList.add(e.getText());
		  tempList.add(e.getText());
		
	   }*/
	   
	   for(int i = 0 ; i < originalDropdownList.size() ; i++) {
		   mainList.add(originalDropdownList.get(i).getText());
		   tempList.add(originalDropdownList.get(i).getText());
		   //System.out.println(""+mainList+"");
	   }
	   
	   System.out.println("original list before sorting :" + mainList);
	   Collections.sort(tempList,Collections.reverseOrder());
	   //Collections.reverseOrder(tempList);
	   System.out.println("original list after sorting templist :" +mainList );
	   System.out.println("This is temp List :" +tempList);
		
	}

}
