package Customer;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Open_AccountTest {

	public static void main(String[] args) throws IOException, InterruptedException, AWTException {
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
	   
		//excel
		FileInputStream fi = new FileInputStream(".\\src\\test\\resources\\Excel.xlsx");
		Workbook wb = WorkbookFactory.create(fi);
		 Sheet sh = wb.getSheet("Sheet3");
		 

	   //Opening Browser
	   
	   //WebDriver driver=new ChromeDriver();
	   driver.manage().window().maximize();
	   driver.get(URL);
	   driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	   driver.findElement(By.xpath("//li[text()='Open Account']")).click();
	   
	   //Open Account
		
		ArrayList<String> l = new ArrayList<String>();
		l.add("name");
		l.add("mobile");
		l.add("email");
		l.add("landline");
		l.add("pan_no");
		l.add("citizenship");
		l.add("homeaddrs");
		l.add("officeaddrs");
		l.add("pin");
		l.add("arealoc");
		l.add("nominee_name");
		l.add("nominee_ac_no");
		
		String val;
		for (int i=0; i<=sh.getLastRowNum(); i++)
		{
			Row r = sh.getRow(i);
			 Cell cl = r.getCell(1);
			 val = cl.toString();
			driver.findElement(By.name(l.get(i))).sendKeys(val); 
		}
		WebElement dropele = driver.findElement(By.name("gender"));
		Thread.sleep(2000);
		Select s = new Select(dropele);
		Thread.sleep(2000);
		s.selectByValue("Female");
		
		WebElement dropele1 = driver.findElement(By.name("state"));
		Thread.sleep(2000);
		Select s1 = new Select(dropele1);
		Thread.sleep(2000);
		s1.selectByValue("Florida");
		
		WebElement dropele2 = driver.findElement(By.name("city"));
		Thread.sleep(2000);
		Select s2 = new Select(dropele2);
		Thread.sleep(2000);
		s2.selectByValue("Houston");
		
		WebElement dropele3 = driver.findElement(By.name("acctype"));
		Thread.sleep(2000);
		Select s3 = new Select(dropele3);
		Thread.sleep(2000);
		s3.selectByValue("Saving");
		
		driver.findElement(By.name("dob")).click();
		
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
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		Thread.sleep(2000);
		Alert a = driver.switchTo().alert();
		String t = a.getText();
		System.out.println(t);
		
		wb.getSheet("Sheet1").createRow(5).createCell(1).setCellValue("931136041");
		FileOutputStream f=new FileOutputStream(".\\src\\test\\resources\\Excel.xlsx");
		wb.write(f);
		a.accept();
		Thread.sleep(2000);
		
		//driver.close();
	   

	}

}
