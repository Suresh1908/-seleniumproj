package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public  WebDriver ldriver;
	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		ldriver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(id = "email")
	@CacheLookup
	WebElement txtUserName;
    
	
	@FindBy(id = "pass")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(name = "login")
	@CacheLookup
	WebElement btnLogin;
	
	
	
	public void setUserName(String username) {
		txtUserName.clear();
		txtUserName.sendKeys(username);
		
	}
	
	public void setPassword(String pwd) {
		txtPassword.clear();
		txtPassword.sendKeys(pwd);
	}
	
	public void clickLogin() {
		btnLogin.click();
	}
	


}
