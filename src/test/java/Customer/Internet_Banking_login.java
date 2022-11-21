package Customer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Internet_Banking_login {

	public static void main(String[] args) throws IOException {
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
	  // String accountHolderName = wb.getSheet("Sheet1").getRow(0).getCell(1).getStringCellValue();
	   //String dateOfBirth = wb.getSheet("Sheet1").getRow(1).getCell(1).getStringCellValue();
	   //String panNum = wb.getSheet("Sheet1").getRow(2).getCell(1).getStringCellValue();
	   //String phoneNum = wb.getSheet("Sheet1").getRow(3).getCell(1).toString();
	   //String accountNum = wb.getSheet("Sheet1").getRow(4).getCell(1).getStringCellValue();
	   String customerId=wb.getSheet("Sheet2").getRow(9).getCell(1).getStringCellValue();
	   String customerpin=wb.getSheet("Sheet2").getRow(10).getCell(1).getStringCellValue();
	  
	   //Opening Browser
	   
	   //WebDriver driver=new ChromeDriver();
	   driver.manage().window().maximize();
	   driver.get(URL);
	   driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	   
	   WebElement intBanking = driver.findElement(By.partialLinkText("Internet Banking"));
	   
	   //Mousehover
	   Actions a=new Actions(driver);
	   a.moveToElement(intBanking).perform();
	   driver.findElement(By.xpath("//li[contains(text(),'Login')]")).click();
	   driver.findElement(By.name("customer_id")).sendKeys(customerId);
	   driver.findElement(By.xpath("//input[@name='password']")).sendKeys(customerpin);
	   driver.findElement(By.name("login-btn")).click();
	   driver.findElement(By.xpath("//li[text()='Fund Transfer']")).click();
	   
	  WebElement dropDown = driver.findElement(By.xpath("//select[@name='beneficiary']"));
	   
	   //Dropdown
	   Select s=new Select(dropDown);
	   s.selectByIndex(0);
	   driver.findElement(By.xpath("//input[@name='trnsf_amount']")).sendKeys("10");
	   driver.findElement(By.xpath("//input[@name='trnsf_remark']")).sendKeys("bill");
	   driver.findElement(By.xpath("//input[@value='Send']")).click();
	   driver.findElement(By.xpath("//li[text()='My Account']")).click();
	   
	   //Closing the application
	   
	   driver.close();
	}
}

	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	  
