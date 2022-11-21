package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Online_Banking.Banking.GenericLibraries.WebDriver_Utility;

public class Acti_Loging extends WebDriver_Utility{
	//declaration
	@FindBy(xpath = "//input[@name=\"username\"]")
	private WebElement username;
	
	@FindBy(xpath = "//input[@name=\"pwd\"]")
	private WebElement passwrd;
	
	@FindBy(xpath = "//a[@id=\"loginButton\"]")
	private WebElement logbtn;
	
	
	//initialisation
	public Acti_Loging(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

  //utilisation
	public WebElement getUsername() {
		return username;
	}


	public WebElement getPasswrd() {
		return passwrd;
	}


	public WebElement getLogbtn() {
		return logbtn;
	}
	
	//business libraries
	
	public void username(String data) {
		username.sendKeys(data);
	}
	public void Password(String data1) {
		passwrd.sendKeys(data1);;
	}
	
	public void LOgin() {
		logbtn.click();
	}

}
