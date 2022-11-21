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

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Registration_Into_InternetBanking {

	public static void main(String[] args) throws IOException, AWTException, InterruptedException {
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
		
				FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\commonData.properties");
				Properties p=new Properties();
				p.load(fis);
			   String URL = p.getProperty("url");
			   
			   //Reading from excel
			   
			   FileInputStream fi=new FileInputStream(".\\src\\test\\resources\\Excel.xlsx");
			   Workbook wb=WorkbookFactory.create(fi);
			   String accountHolderName = wb.getSheet("Sheet2").getRow(0).getCell(1).getStringCellValue();
			   //String dateOfBirth = wb.getSheet("Sheet1").getRow(1).getCell(1).getStringCellValue();
			   String accountNum = wb.getSheet("Sheet2").getRow(1).getCell(1).getStringCellValue();
			   String debitNum = wb.getSheet("Sheet2").getRow(2).getCell(1).getStringCellValue();
			   String debitPinNum = wb.getSheet("Sheet2").getRow(3).getCell(1).toString();
			   String phoneNum = wb.getSheet("Sheet2").getRow(4).getCell(1).getStringCellValue();
			   String panNum = wb.getSheet("Sheet2").getRow(5).getCell(1).getStringCellValue();
			   String password = wb.getSheet("Sheet2").getRow(7).getCell(1).getStringCellValue();
			   String Transaction = wb.getSheet("Sheet2").getRow(8).getCell(1).getStringCellValue();
			   
			   //Opening Browser
			   
			  // WebDriver driver=new ChromeDriver();
			   driver.manage().window().maximize();
			   driver.get(URL);
			   driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			  // Thread.sleep(3000);
			   WebElement intBanking = driver.findElement(By.partialLinkText("Internet Banking"));
			  // JavascriptExecutor js=(JavascriptExecutor)driver;
		       //s.executeScript("argument[0].scrollIntoView();",intBanking);	   
			   
			   //Mousehover Action
	     
	     Actions a=new Actions(driver);
	   a.moveToElement(intBanking).perform();
	   driver.findElement(By.xpath("//li[text()='Register']")).click();
	   
	   
	   //Registring to internet banking
	   driver.findElement(By.name("holder_name")).sendKeys(accountHolderName);
	   driver.findElement(By.name("accnum")).sendKeys(accountNum);
	   driver.findElement(By.name("dbtcard")).sendKeys(debitNum);
	   driver.findElement(By.name("dbtpin")).sendKeys(debitPinNum);
	   driver.findElement(By.name("mobile")).sendKeys(phoneNum);
	   driver.findElement(By.name("pan_no")).sendKeys(panNum);
	   driver.findElement(By.name("password")).sendKeys(password);
	   driver.findElement(By.name("cnfrm_password")).sendKeys(password); 
	   driver.findElement(By.name("last_trans")).sendKeys(Transaction );
	 Thread.sleep(2000);
	   driver.findElement(By.xpath("//input[@placeholder='Date of Birth']")).click();
	  // JavascriptExecutor js=(JavascriptExecutor)driver;
	   //js.executeScript("argument[0].click();",ele);
	 //Robot class for Date of birth
	   Robot r=new Robot();
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
	    
	   driver.findElement(By.xpath("//input[@type='submit']")).click();   
	   
      // js.executeScript("argument[0].click();",ele1);	
	      
	}
}


