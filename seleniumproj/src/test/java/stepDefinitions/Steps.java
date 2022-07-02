package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LoginPage;

public class Steps {

	public WebDriver driver;
	public LoginPage lp;
	
	
	@Given("^User launch Chrome browser$")
	public void user_launch_Chrome_browser() throws Throwable {
	    System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Drivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
	    driver=new ChromeDriver(options);
	    lp = new LoginPage(driver);
	}

	@When("^user opens URL \"([^\"]*)\"$")
	public void user_opens_URL(String url) throws Throwable {
		
	    driver.navigate().to(url);
	}

	@When("^user enters user name as \"([^\"]*)\" and password as \"([^\"]*)\"$")
	public void user_enters_user_name_as_and_password_as(String uname, String pwd) throws Throwable {
	    lp.setUserName(uname);
	    lp.setPassword(pwd);
	}

	@When("^click on Login$")
	public void click_on_Login() throws Throwable {
	    
		lp.clickLogin();
		Thread.sleep(4000);
		
		System.out.println(driver.getTitle()+"post log in");
	}

	@Then("^page title should be \"([^\"]*)\"$")
	public void page_title_should_be(String title) throws Throwable {
	 
		if(driver.getPageSource().contains("Login was unsuccessful"))
		{
			driver.close();
			Assert.assertTrue(false);
		}
		
		else
			Assert.assertEquals(title, driver.getTitle());
	
		driver.close();
		
	}


}
