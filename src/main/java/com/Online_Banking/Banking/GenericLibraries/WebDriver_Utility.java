package com.Online_Banking.Banking.GenericLibraries;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.lang.model.element.Element;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



public class WebDriver_Utility {
	/**Synchronization methods
	 * @author kalam
	 * @param driver
	 */
	public void waitForPageLoad(WebDriver driver) {
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	public void maximiseWindow(WebDriver driver) {
		
		driver.manage().window().maximize();
		
	}
	public void waitForElementToBeVisible(WebDriver driver,WebElement ele) {
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(ele));
		
	}
	/** method for fluent wait
	 * @author kalam
	 */
	/*public void flunt_Wait(WebDriver driver,String Exception,int timeout) {
		FluentWait wait=new FluentWait(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(2,timeout.SECONDS).ignoring(Exception);
		
	}*/
	/**All Select class methods for dropdown
	 * @author kalam
	 * @param element
	 * @param Index
	 */
	public void select_Index(WebElement element,int Index) {
		Select s=new Select(element);
		s.selectByIndex(Index);
	}
	public void select_Value(WebElement element,String value) {
		Select s=new Select(element);
		s.selectByValue(value);
	}
	public void select_Visibletext(WebElement element,String value) {
		Select s=new Select(element);
		s.selectByVisibleText(value);

    }
	
	/**Action class method
	 * @author kalam
	 * @param driver
	 * @param element
	 */
	public void action_Mousehover(WebDriver driver,WebElement element) {
		Actions a=new Actions(driver);
		a.moveToElement(element).perform();
	}
	public void action_Rightclick(WebDriver driver,WebElement element) {
		Actions a=new Actions(driver);
		a.contextClick().perform();
	}
	public void action_Doubleclick(WebDriver driver,WebElement element) {
		Actions a=new Actions(driver);
		a.doubleClick(element).perform();
	}
	public void action_Draganddrop(WebDriver driver,WebElement element1,WebElement element2) {
		Actions a=new Actions(driver);
		a.dragAndDrop(element1,element2).perform();
	}
	/** method to double click on webpage
	 * @author kalam
	 */
	public void doubleClickAction(WebDriver driver) {
		Actions a=new Actions(driver);
		a.doubleClick().perform();
	}
	/*/** method for press Enter key in Action class
	 * @author kalam
	 */
	/*public void enter_Action(WebDriver driver) {
		Actions a=new Actions(driver);
		a.sendKeys(Keys.ENTER).perform();
		
	}*/
	/**Methods related to pop ups
	 * @author kalam
	 */
	public void alertPopUp_Accept(WebDriver driver) {
		Alert ale = driver.switchTo().alert();
		System.out.println(ale.getText());
		ale.accept();
		
	}
	public void alertPopUp_Dismiss(WebDriver driver) {
		Alert ale = driver.switchTo().alert();
		ale.dismiss();
		
	}
	/**Handling parent Browser
	 * @author kalam
	 */
	public void parent_Browser(WebDriver driver) {
		String parent = driver.getWindowHandle();
			driver.switchTo().window(parent);
			
		}
	/**Handling Chid Browser
	 * @author kalam
	 */
	public void child_Browser(WebDriver driver) {
		Set<String> child = driver.getWindowHandles();
		for(String b:child) {
			driver.switchTo().window(b);
		}
		}
		/**method for handling notifications in chrome
		 * @author kalam
		 */
		public void chrome_Chrome(){
			ChromeOptions options=new ChromeOptions();
			options.addArguments("--disable-notifications");
			
	}
		/**method for handling notifications in firefox
		 * @author kalam
		 */
	
	public void fireFox_Options(){
		FirefoxOptions options=new FirefoxOptions();
		options.addArguments("--disable-notifications");
		
	}
	/**method used to switch to frame using index
	 * @author kalam
	 * @param driver
	 */
	public void swithchFrames_Index(WebDriver driver,int index) {
		driver.switchTo().frame(index);
	}
	/**method used to switch to frame using id
	 * @author kalam
	 * @param driver
	 * @param id_name_attribute
	 */
	public void swithFrame_Id(WebDriver driver , String id_name_attribute) {
		driver.switchTo().frame(id_name_attribute);
	}
	/**method to come out of frame
	 * @author kalam
	 */
	public void switch_Back_From_Frame(WebDriver driver) {
		driver.switchTo().defaultContent();
		
	}
	
	
	/**method used for scrolling
	 * @author kalam
	 */
	public void scrooBar(WebDriver driver,WebElement element) {
	
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("argument[0].scroolInToVieW();",element);
	}
	/**method for scrolling using getloctions
	 * @author kalam
	 */
	public void scroolbar_Using_Location(WebDriver driver,WebElement element) {
	Point ele = element.getLocation();	
	int x=ele.getX();
	int y=ele.getY();
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("window.scrollBy("+x+","+y+")");
	
	}
	/**method to take Screenshots
	 * @author kalam
	 * @throws IOException 
	 */
	public void screenShots(WebDriver driver) throws IOException {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File des=new File(".//Online_Banking_system/photo/.png");
		FileUtils.copyFile(src, des);
	}
	
	
	
	/** methods for Robot class
	 * @author kalam
	 * @throws AWTException 
	 */
	public void robot_Press(WebDriver driver,int Enter) throws AWTException {
		Robot rb=new Robot();
		rb.keyPress(KeyEvent.VK_ENTER);
		
	}
	public void robot_Release(WebDriver driver,int Enter) throws AWTException {
		Robot rb=new Robot();
		rb.keyRelease(KeyEvent.VK_ENTER);
	}

		
	
	
		
	}
	
	
	
	

