package SeleniumSessions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.excel.utility.Xls_Reader;

public class WebTableHandlePart2 {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver","F:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://wet-boew.github.io/v4.0-ci/demos/tables/tables-en.html");
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//Rendering Engine xpaths
		//*[@id="wb-auto-3"]/tbody/tr[1]/td[1]
		//*[@id="wb-auto-3"]/tbody/tr[2]/td[1]
		//*[@id="wb-auto-3"]/tbody/tr[3]/td[1]
		//*[@id="wb-auto-3"]/tbody/tr[4]/td[1]
		
		//Browser xpaths
		//*[@id="wb-auto-3"]/tbody/tr[1]/td[2]
		//*[@id="wb-auto-3"]/tbody/tr[2]/td[2]
		//*[@id="wb-auto-3"]/tbody/tr[3]/td[2]

		
		String beforeXpathRE = "//*[@id=\"wb-auto-3\"]/tbody/tr[";
		String afterXpathRE = "]/td[1]";
		
		String beforeXpathBrows = "//*[@id=\"wb-auto-3\"]/tbody/tr[";
		String afterXpathBrows = "]/td[2]";
		
		String beforeXpathPlatforms = "//*[@id=\"wb-auto-3\"]/tbody/tr[";
		String afterXpathPlatforms = "]/td[3]";
		
		String beforeXpathEV = "//*[@id=\"wb-auto-3\"]/tbody/tr[";
		String afterXpathEV = "]/td[4]";
		
		String beforeXpathCSSGrade = "//*[@id=\"wb-auto-3\"]/tbody/tr[";
		String afterXpathCSSGrade = "]/td[5]";
		
		List<WebElement> list = driver.findElements(By.cssSelector("#wb-auto-3>tbody>tr"));
		System.out.println(list.size());
		int rowCount = list.size();
		
		Xls_Reader reader = new Xls_Reader("F:\\Vishal_Offc Work\\Workspace\\SeleniumBasics\\"
				+ "src\\com\\testdata\\NewToursRegTestData.xlsx");
		
		if(!reader.isSheetExist("Table_WorkingExample")) {
			
			reader.addSheet("Table_WorkingExample");
			reader.addColumn("Table_WorkingExample", "Rendering Engine");
			reader.addColumn("Table_WorkingExample", "Browser");
			reader.addColumn("Table_WorkingExample", "Platforms");
			reader.addColumn("Table_WorkingExample", "Engine Version");
			reader.addColumn("Table_WorkingExample", "CSS Grade");
			
		}
		for(int i = 1 ; i <= rowCount ; i++) {
			
			String RenderingEngineCol = beforeXpathRE+i+afterXpathRE;
			String RenderingEngineColData = driver.findElement(By.xpath(RenderingEngineCol)).getText();
			System.out.println(RenderingEngineColData);
			reader.setCellData("Table_WorkingExample", "Rendering Engine", i, RenderingEngineColData);
			
			String BrowserCol = beforeXpathBrows+i+afterXpathBrows;
			String BrowserData = driver.findElement(By.xpath(BrowserCol)).getText();
			System.out.println(BrowserData);
			reader.setCellData("Table_WorkingExample", "Browser", i, BrowserData);
			
			String PlatformsCol = beforeXpathPlatforms+i+afterXpathPlatforms;
			String PlatformsColData = driver.findElement(By.xpath(PlatformsCol)).getText();
			System.out.println(PlatformsColData);
			reader.setCellData("Table_WorkingExample", "Platforms", i, PlatformsColData);
			
			String EngineVersionCol = beforeXpathEV+i+afterXpathEV;
			String EngineVersionColData = driver.findElement(By.xpath(EngineVersionCol)).getText();
			System.out.println(EngineVersionColData);
			reader.setCellData("Table_WorkingExample", "Engine Version", i, EngineVersionColData);
			
			String CSSGradeCol = beforeXpathCSSGrade+i+afterXpathCSSGrade;
			String CSSGradeColData = driver.findElement(By.xpath(CSSGradeCol)).getText();
			System.out.println(CSSGradeColData);
			reader.setCellData("Table_WorkingExample", "CSS Grade", i, CSSGradeColData);
			
		//	System.out.println(RenderingEngineColData+"  "+BrowserData+"  "+PlatformsColData+"  "+EngineVersionColData+"  "+CSSGradeColData);
		//	System.out.println("---------------------------");
			
		}
		
		
	}

}
