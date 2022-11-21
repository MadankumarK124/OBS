package Customer;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Apply_Debit_Card {

	public static void main(String[] args) throws IOException, AWTException {
		WebDriver driver=null;
		String BROWSER = null;
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else 
		{
	System.out.println("Invalid browser");
		}
		
		// Reading from Property File
		
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\commonData1.properties");
		Properties p=new Properties();
		p.load(fis);
	   String URL = p.getProperty("url");
	   
	   //Reading from excel
	   
	   FileInputStream fi=new FileInputStream(".\\src\\test\\resources\\Excel.xlsx");
	   Workbook wb=WorkbookFactory.create(fi);
	   String accountHolderName = wb.getSheet("Sheet1").getRow(0).getCell(1).getStringCellValue();
	   //String dateOfBirth = wb.getSheet("Sheet1").getRow(1).getCell(1).getStringCellValue();
	   String panNum = wb.getSheet("Sheet1").getRow(2).getCell(1).getStringCellValue();
	   String phoneNum = wb.getSheet("Sheet1").getRow(3).getCell(1).toString();
	   String accountNum = wb.getSheet("Sheet1").getRow(4).getCell(1).getStringCellValue();
	  
	   //Opening Browser
	   
	   //WebDriver driver=new ChromeDriver();
	   driver.manage().window().maximize();
	   driver.get(URL);
	   driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	   
	   driver.findElement(By.xpath("//li[text()='Apply Debit Card']")).click();
	   driver.findElement(By.name("holder_name")).sendKeys(accountHolderName);
	   driver.findElement(By.xpath("//input[@placeholder='Date of Birth']")).click();
	    //Robot class for Date of birth
	   //Robot r=new Robot();
	   Robot r = new Robot();
	  // r.keyPress(KeyEvent.VK_2);
	   r.keyPress(KeyEvent.VK_2);
	   r.keyRelease(KeyEvent.VK_2);
	   r.keyPress(KeyEvent.VK_8);
	   r.keyRelease(KeyEvent.VK_8);
	   r.keyPress(KeyEvent.VK_0);
	   r.keyRelease(KeyEvent.VK_0);
	   r.keyPress(KeyEvent.VK_5);
	   r.keyRelease(KeyEvent.VK_5);
	   r.keyPress(KeyEvent.VK_1);
	   r.keyRelease(KeyEvent.VK_1);
	   r.keyPress(KeyEvent.VK_9);
	   r.keyRelease(KeyEvent.VK_9);
	   r.keyPress(KeyEvent.VK_9);
	   r.keyRelease(KeyEvent.VK_9);
	   r.keyPress(KeyEvent.VK_2);
	   r.keyRelease(KeyEvent.VK_2);
	   
	   driver.findElement(By.name("pan")).sendKeys(panNum);
	   driver.findElement(By.name("mob")).sendKeys(phoneNum);
	   driver.findElement(By.name("acc_no")).sendKeys(accountNum);
	   
	   
	   driver.findElement(By.name("dbt_crd_submit")).click();
	   
	
	
	

	}

}
