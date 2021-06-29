package pageObjects;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MyAccountPage {
	WebDriver driver;
	public MyAccountPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH, using = "//a[@class='progressive-nav__link' and contains(@onclick,'Bank accounts')]")
	private static WebElement bnkacts;
	
	//My Account page object - Capture the logged in user name
	@FindBy(how = How.XPATH, using = "//*[@class='header_user_info'][1]")
	private static WebElement loggedInUserName;
	//My Account page object - My Wishlists link
	@FindBy(how = How.XPATH, using = "//span[text()='My wishlists']")
	private static WebElement lnkmyWishlists;
	
	//My Account page object - My Personal info link
	@FindBy(how = How.XPATH, using = "//span[text()='My personal information']")
	private static WebElement lnkmyPerinfo;
	
	
	//My Account page object - Quantity field in wishlists table
	@FindBy(how = How.XPATH, using = "//table[@class='table table-bordered']/tbody/tr[1]/td[2]")
	private static WebElement qntyInWishlistsTable;
	//My T-shirt page - T-shirt link object
	@FindBy(how = How.XPATH, using = "//*[@id='block_top_menu']//li[2]//a[@title='T-shirts']")
	public static WebElement tshirts;
	
	@FindBy(how = How.XPATH, using = "//div[@id='block_top_menu']//following-sibling::li[2]//a[@title='Dresses']")
	public static WebElement dresses;
		
	
	//My Account page object - Sign out button
	@FindBy(how = How.XPATH, using = "//*[@title='Log me out']")
	private static WebElement signoutbtn;
	
	//The below method compares the page title and returns true/false
	public boolean comparePageTitle() {
		String pgTitleDisplayed = driver.getTitle();
		if(pgTitleDisplayed.contains("My account - My Store")) {
			System.out.println("user logged in successfully and the title of the page is: "+pgTitleDisplayed);
			return true;
		}
		else {
			System.out.println("user not logged in successfully and the title of the page is: "+pgTitleDisplayed);
			return false;
		}
	}
	
	public boolean validFieldname() {
		String valfidname = bnkacts.getText();
		if(valfidname.contains("Bank accounts")) {
			System.out.println("Bankaccount validated: "+valfidname);
			return true;
		}
		else {
			System.out.println("Bankaccount validated: "+valfidname);
			return false;
		}
	}
	
	
	//The below method Verify the registered user logged in or not and returns true/false
	public boolean verifyloggedInUserName(String arg1, String arg2) {
		String dispUserName = loggedInUserName.getText();
		String inputUserName = arg1+" "+arg2;
		System.out.println(inputUserName);
		System.out.println(dispUserName);
		if(inputUserName.equalsIgnoreCase(dispUserName)) {
			System.out.println("user name displayed after logged in: "+dispUserName);
			return true;
		}
		else {
			System.out.println("user name not displayed as expected after logged in: "+dispUserName);
			return false;
		}
	}
	
	//The below method checks My Wishlists link displayed in the page and returns true/false
	public boolean verifyMywishlistlnkDisplayed(String arg1) {
		String linkTextDisplayed = lnkmyWishlists.getText();
		if(linkTextDisplayed.equalsIgnoreCase(arg1)) {
			System.out.println("my wishlists link displayed.");
			return true;
		}
		else {
			System.out.println("my wishlists didn't displayed.");
			return false;
		}
	}
	
	//The below method clicks on My Wishlists link
	public void clkMyWishlistslink() {
		lnkmyWishlists.click();
	}
	
	//The below method checks My personal information link displayed in the page and returns true/false
		public boolean verifyMyperinfolnkDisplayed(String arg1) {
			String linkTextDisplayed = lnkmyPerinfo.getText();
			if(linkTextDisplayed.equalsIgnoreCase(arg1)) {
				System.out.println("my personal info link displayed.");
				return true;
			}
			else {
				System.out.println("my personalinfo didn't displayed.");
				return false;
			}
		}
		
		//The below method clicks on My Personal info link
		public void clkMypersinfolink() {
			lnkmyPerinfo.click();
		}
	
	
	
	//The below method Verifies my wishlists quantity is 1 for the newly registered user and returns true/false
	public boolean VerifyTheQuantityequalsToOne() {
		String quantitydisplayed = qntyInWishlistsTable.getText();
		int quntydisp = Integer.parseInt(quantitydisplayed);
		if(quntydisp == 1) {
			System.out.println("Item added successfully to the wishlist");
			return true;
		}
		else {
			System.out.println("Item is not added successfully to the wishlist");
			//driver.close();
			//throw new Error("validation failed");
			return false;
		}
	}

	public void dressesTab() {
		dresses.click();
	}
	
	
	public void dropDown() throws InterruptedException {
		
		
//		Select dropDown = new Select(driver.findElement(By.xpath("//select[@id='selectProductSort']")));
//		List <WebElement> priceList = dropDown.getOptions();
//		System.out.println("Dropdown list: "+priceList.size());
//		//dropDown.selectByValue("Price: Highest first");
		
		WebElement dropDwn = driver.findElement(By.xpath("//select[@id='selectProductSort']"));
		Actions acs = new Actions(driver);
		acs.moveToElement(dropDwn).build().perform();
		WebElement priceHigh = driver.findElement(By.xpath("//select[@id='selectProductSort']//child::option[3]"));
		priceHigh.click();		
		Thread.sleep(5000);
		
	}
	
	public void addTocart() {
		
		WebElement addCart = driver.findElement(By.xpath("//div[@class='button-container']//child::a[@data-id-product='4']"));
		JavascriptExecutor executor1 = (JavascriptExecutor)driver;
		executor1.executeScript("arguments[0].click();", addCart);
		System.out.println("addCart: " +addCart);
		//addCart.click();
		//System.out.println("addCart: " +addCart);
	
		
	}
	
	
	public void tshirtsTab() {
		//String tshrt = driver.findElement(By.xpath("//ul[@class=\"sf-menu clearfix menu-content sf-js-enabled sf-arrows\"]//li[1]//a[@title='T-shirts']")).getText();
		WebElement tShirt = driver.findElement(By.xpath("//li[3]//a[@title='T-shirts']"));
		System.out.println("Tshirt" +tShirt);
		//JavascriptExecutor executor = (JavascriptExecutor)driver;
		//executor.executeScript("arguments[0].click();", tShirt);
		tShirt.click();
				
		WebElement addCart = driver.findElement(By.xpath("//div[@class=\"button-container\"]//span[contains(text(),'Add to cart')]"));
		JavascriptExecutor executor1 = (JavascriptExecutor)driver;
		executor1.executeScript("arguments[0].click();", addCart);
		System.out.println("addCart: " +addCart);
		//addCart.click();
		//System.out.println("addCart: " +addCart);
		
	}
	
	public void prchkoutTab() {
		
	/*		
		System.out.println("Closewindow ");
		WebElement clsWindow = driver.findElement(By.xpath("//span[@title='Close window']"));	
		System.out.println("Closewindow: " +clsWindow.getText());
		clsWindow.click();
*/
		System.out.println("Proceed to checkout ");		
		WebElement checkOut = driver.findElement(By.xpath("//a[@title='Proceed to checkout']"));		
		System.out.println("Proceed to checkout: " +checkOut.getText());
		checkOut.click();
		
						
	}
	

	public void cartList() {
		
/*		WebElement cart = driver.findElement(By.xpath("//a[@title='View my shopping cart']"));
		System.out.println("cartlist: " +cart);		
		Actions acs = new Actions(driver);
		acs.moveToElement(cart).build().perform();
		System.out.println("CartList: " +acs);
		*/	
		
		System.out.println("Proceed to checkout2 ");		
		WebElement checkOut = driver.findElement(By.xpath("//p[@class='cart_navigation clearfix']//a[@title='Proceed to checkout']"));		
		System.out.println("Proceed to checkout2: " +checkOut.getText());
		checkOut.click();

		
	}
	
	
	//The below method clicks on sign out button
	public void logoutfromTheApplication() {
		signoutbtn.click();
	}
	
	public void listCartItems() {
		
		try {
		WebElement cartItems = driver.findElement(By.xpath("//a[@title='View my shopping cart']"));
		Actions acs = new Actions(driver);
		acs.moveToElement(cartItems).build().perform();
		acs.clickAndHold().wait(5000);
		//click().perform();
		boolean isPresent = driver.findElement(By.xpath("//a[@class='cart_block_product_name' and contains(text(),'Printed Dress')]")).isDisplayed();
		 //WebElement itemCnt = driver.findElement(By.xpath("//a[@title='View my shopping cart']//span[contains(text(),'empty')"));
		 
	
		 if (isPresent == true) {
			 System.out.println("Item still available in Cart ");
		 	}
		} catch (Exception e){
			System.out.println("Item not available in Cart ");	
		}
		
		
	}
	
}
