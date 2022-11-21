package POM_Scripts;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.Online_Banking.Banking.GenericLibraries.Excel_Utility;
import com.Online_Banking.Banking.GenericLibraries.File_Utility;
import com.Online_Banking.Banking.GenericLibraries.WebDriver_Utility;

import pages.Acti_Loging;

public class Acti_login_Script {
	public static void main(String[] args) throws Throwable {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		// creating object for file utility

		File_Utility flib = new File_Utility();
		String BROWSER = flib.readDataFromPropertyFile("browser");

		String URL = flib.readDataFromPropertyFile("url");

		driver.get(URL);
		driver.manage().window().maximize();

		// creating object for excel utility

		Excel_Utility elib = new Excel_Utility();
		String usrnm = elib.readDataFromExcel("Sheet6", 0, 1);
		String pswrd = elib.readDataFromExcel("Sheet6", 1, 1);
     
		
		//creating object for Acti_Loging page
		
		Acti_Loging login = new Acti_Loging(driver);
		login.username(usrnm);
		login.Password(pswrd);
		login.LOgin();
		Thread.sleep(4000);
		driver.close();

	}

}
