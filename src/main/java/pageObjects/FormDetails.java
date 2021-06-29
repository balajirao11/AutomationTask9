package pageObjects;
//import java.awt.List;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class FormDetails {
	WebDriver driver;
	
	public FormDetails(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	//Validate bank account field
	@FindBy(how = How.XPATH, using = "//a[@class='progressive-nav__link' and contains(@onclick,'Bank accounts')]")
	private static WebElement bnkacts;
	
	
	@FindBy(how = How.XPATH, using = "//*[contains(text(),'Title')]//following::input[1]")
	private static WebElement rbGener1;
	//User account creation details page - Radio button Mrs
	@FindBy(how = How.XPATH, using = "//*[contains(text(),'Title')]//following::input[2]")
	private static WebElement rbGener2;
	//User account update - First Name field
	@FindBy(how=How.XPATH,using = "//*[@id='firstname']")
	private static WebElement updFirstName;
	//User account creation details page - First Name field
	@FindBy(how=How.XPATH,using = "//*[@id='customer_firstname']")
	private static WebElement txtFirstName;
	//User account creation details page - Last Name field
	@FindBy(how=How.XPATH,using = "//*[@id='customer_lastname']")
	private static WebElement txtLastName;
	//User account creation details page - Password field
	@FindBy(how = How.XPATH, using = "//*[@id='passwd']")
	private static WebElement txtPassword;
	
	//User account update page - old Password field
	@FindBy(how = How.XPATH, using = "//*[@id='old_passwd']")
	private static WebElement oldPassword;
	
	
	//User account creation details page - Address line1 field
	@FindBy(how = How.XPATH, using = "//*[@id='address1']")
	private static WebElement txtAddress;
	//User account creation details page - City field
	@FindBy(how = How.XPATH, using = "//*[@id='city']")
	private static WebElement txtCity;
	//User account creation details page - State drop down list field
	@FindBy(how = How.XPATH, using = "//*[@id='id_state']")
	private static WebElement listState;
	//User account creation details page - Zip/Postal code field
	@FindBy(how = How.XPATH, using = "//*[@id='postcode']")
	private static WebElement txtPostCode;
	//User account creation details page - Country drop down list field
	@FindBy(how = How.XPATH, using = "//*[@id='id_country']")
	private static WebElement listCountry;
	//User account creation details page - Mobile number field
	@FindBy(how = How.XPATH, using = "//*[@id='phone_mobile']")
	private static WebElement txtMobileNumber;
	//User account creation details page - Alias name field
	@FindBy(how = How.XPATH, using = "//*[@id='alias']")
	private static WebElement txtAlias;
	//User account creation details page - Register button to create the account
	@FindBy(how = How.XPATH, using = "//span[text()='Register']")
	private static WebElement btnRegister;
	//User click on proceed to checkout
	@FindBy(how = How.XPATH, using = "//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a")	                              
	private static WebElement btnCheckout;
	//User account personal info update page - Save button to update first name
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Save')]")
	private static WebElement btnSave;
	
	//The below method checks the input and select Mr/Mrs based on that.
	public void selectRBtnasPerInput(String arg1) {
		String title1 = "mr";
		String title2 = "mrs";
		if(title1.equalsIgnoreCase(arg1)) {
			rbGener1.click();
		}
		else if(title2.equalsIgnoreCase(arg1)) {
			rbGener2.click();
		}
		else {
			System.out.println("not a valid input"+arg1);	
		}
			
		System.out.println("Display input: "+arg1);
	}
	
	
	//The below method enter First name
	public void updateFirstName(String arg1) {
		updFirstName.sendKeys(arg1);
	}

	
	//The below method enter First name
	public void enterFirstName(String arg1) {
		txtFirstName.sendKeys(arg1);
	}
	
	//The below method enter Last name
	public void enterSurName(String arg1) {
		txtLastName.sendKeys(arg1);
	}
	
	//The below method enter Password
	public void enterPassword(String arg1) {
		txtPassword.sendKeys(arg1);
	}
	
	public void currentPassword(String arg1) {
		oldPassword.sendKeys(arg1);
	}
	//The below method enter Address line1 mandatory field
	public void enterAddressline1(String arg1) {
		txtAddress.sendKeys(arg1);
	}
	
	//The below method enter City name
	public void enterCity(String arg1) {
		txtCity.sendKeys(arg1);
	}
	
	//The below method selects the state from dropdown list
	public void selectState(String arg1) {
		listState.click();
		 Select dropdownState = new Select(listState);
		 dropdownState.selectByVisibleText(arg1);
	}
	
	public void listStateNames() {
		listState.click();
		 Select dropdownState = new Select(listState);
		
		 /* for loop
		 List<WebElement> allStates = dropdownState.getOptions();
		 
		 int cnt = allStates.size();
		 
		 System.out.println("Total no.of states: " +cnt);
		 
		 
		 for(int i=0; i < cnt; i++) {		 
		 System.out.println("State name: "+allStates.get(i).getText());
		 */
		 
		 /* Advanced for loop - start
		 List<WebElement> allStates = dropdownState.getOptions();
		 
	      for (WebElement i : allStates) { 		      
	    	  System.out.println("State name: "+i.getText());		
	      }
	      */
		 	 
		 /* While Loop for iterating List*/
		 
		 List<WebElement> allStates = dropdownState.getOptions();
		 Iterator<WebElement> itr = allStates.iterator();
		 
		 while (itr.hasNext()){
			 System.out.println("State name: "+itr.next().getText());
	      }


		 
	}

	
	
	
	//The below method enter zip/postal code
	public void enterPostalCode(String arg1) {
		txtPostCode.sendKeys(arg1);
	}
	
	//The below method selects the country from dropdown list
	public void selectCountry(String arg1) {
		listCountry.click();
		 Select dropdownCountry = new Select(listCountry);
		 dropdownCountry.selectByVisibleText(arg1);
	}
	
	//The below method enter Mobile number
	public void enterMobileNum(String arg1) {
		txtMobileNumber.sendKeys(arg1);
	}
	
	//The below method enter Alias name
	public void enterAliasName(String arg1) {
		txtAlias.clear();
		txtAlias.sendKeys(arg1);
	}
	
	//The below method clicks on Registration button to complete the new user registration
	public void clkOnRegistration() {
		btnRegister.click();
	}
	
	public void clkOnProceedCheckout() {
		
		WebElement btnCheckout = driver.findElement(By.xpath("//a[@title='Proceed to checkout']"));
		//WebElement btnCheckout = driver.findElement(By.cssSelector("#layer_cart > div.clearfix > div.layer_cart_cart.col-xs-12.col-md-6 > div.button-container > a > span"));
		
		JavascriptExecutor executor1 = (JavascriptExecutor)driver;
		executor1.executeScript("arguments[0].click();", btnCheckout);
		//btnCheckout.click();
	}
	
	public void clkOnSave() {
		btnSave.click();
	}
}
