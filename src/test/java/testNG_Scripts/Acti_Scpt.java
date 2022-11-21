package testNG_Scripts;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.Online_Banking.Banking.GenericLibraries.Base_Class;
import com.Online_Banking.Banking.GenericLibraries.Excel_Utility;
import com.Online_Banking.Banking.GenericLibraries.File_Utility;

import pages.Acti_Loging;
import org.testng.annotations.Test;

public class Acti_Scpt extends Base_Class{
	

	@Test()
	public  void Actlgn() throws Throwable, Throwable {

	
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
