package pageObjects;
import java.util.regex.Pattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
//import dataProvider.ConfigFileReader;
//import managers.FileReaderManager;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
public class SignInPage {
	WebDriver driver;
	
	public SignInPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	//Sign in page - Email address field when creating new account
	@FindBy(how = How.XPATH, using = "//*[@id='email_create']")
	private static WebElement txtEmailAddress;
	//Sign in page - create account button field when creating new account
	@FindBy(how=How.XPATH,using = "//*[@name='SubmitCreate' and @id='SubmitCreate']")
	private static WebElement btnCreateAccount;
	
	//Automation Practice - sign in - Start
	@FindBy(how = How.XPATH, using = "//input[@id='email']")
	private static WebElement txtEmailId;
	
	//Automation Practice - Email Id to sign in
	@FindBy(how = How.XPATH, using = "//input[@id='passwd']")
	private static WebElement txtEmailPass;
	
	
	//Sign in page - create account button field when creating new account
	@FindBy(how=How.XPATH,using = "//button[@id='SubmitLogin']")
	private static WebElement btnSignIn;
		
	//Automation Practice - sign in - End
	
	//Sign in page - if error displays after entering the same Email address field
	@FindBy(how = How.XPATH, using = "//ol[1]//li[1]")
	private static WebElement errDescription;
	
	
	// Amazon
	//Sign in page - Email address entered
	@FindBy(how = How.XPATH, using = "//input[@type='email']")
	private static WebElement txtEmailAdd;
	
	//Sign in page - click on continue button field
	@FindBy(how=How.XPATH,using = "//input[@id='continue']")
	private static WebElement btnContinue;
	
	
	//Password Page -- Password entered
	@FindBy(how = How.XPATH, using = "//input[@type='password']")
	private static WebElement txtEmailPwd;
		
	//Password Page - Click on sign in button
	@FindBy(how=How.XPATH,using = "//input[@id='signInSubmit']")
	private static WebElement btnSignin;
	
	
	
	//The below method enters four unique characters as prefix to email address sent from feature file
	public void enterEmailAddress(String arg1) throws InterruptedException {
		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"+"0123456789";
		StringBuilder sb = new StringBuilder(4);
		for (int i = 0; i < 4; i++) { 
            int index = (int)(AlphaNumericString.length()* Math.random()); 
            sb.append(AlphaNumericString.charAt(index)); 
        } 
		String prefixAdd = sb.toString();
		Thread.sleep(5000);
		txtEmailAddress.click();
		txtEmailAddress.clear();
		txtEmailAddress.sendKeys(arg1);
		//txtEmailAddress.sendKeys(prefixAdd+arg1);

	}
	
	//The below method clicks on Create Account button after entering email address
	public void clkOnCreateAccountBtn() throws InterruptedException {
		Thread.sleep(5000);
		btnCreateAccount.click();
	}
  
 //Sign in AutomationPractice - Starts
	public void enterEmailId(String arg1) throws InterruptedException {
		
		txtEmailId.click();
		txtEmailId.clear();
		emailIdValidation(arg1);
		txtEmailId.sendKeys(arg1);
		Thread.sleep(5000);

	}

   public void enterPwd(String arg1) throws InterruptedException {
		
	   txtEmailPass.click();
	   txtEmailPass.clear();
	   txtEmailPass.sendKeys(arg1);
		Thread.sleep(5000);

	}

   public void clkOnSignInBtn() throws InterruptedException {
		btnSignIn.click();
	}
 
 //Sign in AutomationPractice - Ends
	
	public void enterEmailAdd(String email)  {
		
		String emailId = email;
		System.out.println("email-id: " +emailId);		
		emailIdValidation(email);
		txtEmailAdd.sendKeys(emailId);	
	}
	
	
	public void emailIdValidation(String emailId) {
		
		if (emailId.equals("")) {			
			System.out.println("email id  should not be empty");			
		};
		
		
		String regex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                			"[a-zA-Z0-9_+&*-]+)*@" +
                			"(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                			"A-Z]{2,7}$";
                  
		Pattern pat = Pattern.compile(regex);
		Boolean validate = pat.matcher(emailId).matches();
		
		if (validate == true) {
			System.out.println("Valid email id passed");
					
		} else {
			if (validate == false) {
				System.out.println("Valid email id failed");
				}
			};
			
	
		
	}
	
	//The below method clicks on continue button after entering email address	
	public void clkOnContinueBtn() throws InterruptedException {
		Thread.sleep(5000);
		btnContinue.click();
	}
	
	public void enterpassword(String pass) {
		txtEmailPwd.sendKeys(pass);
		
	}
	//The below method clicks on continue button after entering email address	
	public void clkSigninBtn() {
		btnSignin.click();
	}
	
}
