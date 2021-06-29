package stepDefinitions;

import cucumber.api.java.en.Given;
import managers.FileReaderManager;

import org.openqa.selenium.WebDriver;

import cucumber.TestContext;
import pageObjects.HomePage;

//this class will take user to the sign on page.
public class LoginPageSteps {
	 TestContext testContext;
	 HomePage homePage;
	 WebDriver driver;
	 /*public HomePageSteps(TestContext context) {
		 testContext = context;
		 homePage = testContext.getPageObjectManager().getHomePage();
	}
	*/
	 
/*	@Given("^user is on login page$")
	public void  user_is_on_login_page() {
		
		driver.get(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());
		//homePage.clkOnSignInlink();
	}
	*/
	 
	@Given("^user is on login page$")
	public void user_is_on_login_page() throws Throwable {
		driver.get(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());
		System.setProperty("webdriver.chrome.driver","C:\\\\Softwares\\\\chromedriver.exe");
        driver.get("https://www.amazon.in/");    
	}
	
}
