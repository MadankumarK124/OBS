package com.Online_Banking.Banking.GenericLibraries;

import java.io.IOException;
import java.sql.SQLException;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;


public class Base_Class {
	
	public File_Utility flib=new File_Utility();
	public DataBase_Utility dlib=new DataBase_Utility();
	public Excel_Utility elib=new Excel_Utility();
	public Java_Utility jlib=new Java_Utility();
	public WebDriver_Utility wdUtil=new WebDriver_Utility();
	public WebDriver driver=null;
	public static WebDriver sdriver;
	
	
	
	@BeforeSuite
	public void connect_To_DB() throws Throwable {
		dlib.connctToDB();
		System.out.println("connect to database ");
	}
	
	//@Parameters("BROWSER")
	@BeforeClass
	public void launchbrowser() throws Throwable {
		String BROWSER = flib.readDataFromPropertyFile("browser");
		
		if(BROWSER.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}
		else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
	}
	else {
		System.out.println("Invalid browser ");
	}
		sdriver=driver;
		wdUtil.waitForPageLoad(driver);
		wdUtil.maximiseWindow(driver);
		
		

}
	@BeforeMethod
	public void loginTOApp() throws Throwable {
		
		String URL = flib.readDataFromPropertyFile("url");
		driver.get(URL);
		
		
		/*String UN = flib.readDataFromPropertyFile("username");
		String PW = flib.readDataFromPropertyFile("password");
		
		StaffLoginPage SLP=new StaffLoginPage(driver);
		SLP.staffLoginPage(UN, PW);
		System.out.println("--Login to App--");*/
	}
	
	@AfterMethod
	public void signout() {
		//StaffLoginHomePage SL=new StaffLoginHomePage(driver);
		//SL.staffhomebtn();
		System.out.println("--After method--");
	}
	@AfterClass
	public void closeBrowser()
	{
		driver.quit();
		System.out.println("--Close Browser--");
	}
	
	@AfterSuite
	public void closeDBase() throws Throwable {
		dlib.closeDatabase();
		System.out.println("--Closes DB--");
		
	}
	}