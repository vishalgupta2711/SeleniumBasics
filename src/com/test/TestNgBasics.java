package com.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNgBasics {
	
	// precondition annotations -- starting with @Before
	@BeforeSuite  //1
	public void setUp() {
		System.out.println("@BeforeSuite - setup system property for chrome");
	}
	
	@BeforeTest  //2
	public void launchBrowser() {
		System.out.println("@BeforeTest - launch browser");
	}
	
	@BeforeClass  //3
	public void login() {
		System.out.println("@BeforeClass - login to app");
	}
	
	/*
	 * @BeforeMethod
	 * @Test  -1
	 * @AfterMethod
	 * 
	 * @BeforeMethod
	 * @Test  -2
	 * @AfterMethod
	 * 
	 * @BeforeMethod
	 * @Test  -3
	 * @AfterMethod
	 * 	
	 */
	
	@BeforeMethod  //4
	public void enterUrl() {
		System.out.println("@BeforeMethod - enter URL");
	}

	//test cases - starting with @Test
	@Test  (priority = 1)//5
	public void googleTitleTest() {
		System.out.println("@Test - Google title test");
	}
	
	@Test (priority = 3)
	public void searchTest() {
		System.out.println("@Test - search test");
	}
	
	@Test (priority = 2)
	public void googleLogoTest() {
		System.out.println("@Test - google logo test");
	}
	//post conditions -- starting with @After
	@AfterMethod   //6
	public void logOut() {
		System.out.println("@AfterMethod - logout from app");
	}
	
	@AfterClass  //7
	public void closeBrowser() {
		System.out.println("@AfterClass - Close Browser");
	}
	
	@AfterTest  //7
	public void deleteAllCookies() {
		System.out.println("@AfterTest -  delete all cookies");
	}
}
