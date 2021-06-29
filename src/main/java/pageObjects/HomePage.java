package pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import managers.FileReaderManager;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
public class HomePage {
	WebDriver driver;
	
	public HomePage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	//Below method will launch the application URL
	public void navigateTo_HomePage() {
		driver.get(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());
	}
	
	//Sign in link - Home Page object
	@FindBy(how=How.XPATH,using = "//*[contains(text(),'Sign in')]")
	private static WebElement lnkSignIn;
	public void clkOnSignInlink() {
		lnkSignIn.click();
	}
		
	
	//Amazon sign in 
	//@FindBy(how=How.XPATH,using = "//span[@class=\"nav-line-1 nav-progressive-content\" and contains(text(),'Hello, Sign in')]")
	//private static WebElement lnkSignIn;
	//public void clkOnSignInlink() {
		//lnkSignIn.click();
	//}
	
	
	//Amazon search Bar
	@FindBy(how=How.XPATH,using = "//input[@id='twotabsearchtextbox']")
	private static WebElement srchBar;
	
	//Amazon search Bar click
	@FindBy(how=How.XPATH,using = "//input[@id='nav-search-submit-button']")
	private static WebElement srchClick;
	
	//Below method clicks on the Sign in link from the Home page
	
	public void searchBar() {
		srchBar.sendKeys("skull candy dime true ear buds");
	}

	public void searchClick() {
		srchClick.click();
	}
	
}
