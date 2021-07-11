package stepDefinitions;

import java.util.HashMap;

import cucumber.TestContext;
import pageObjects.ProductPage;
import pageObjects.SignInPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import enums.Context;

public class SignInPageSteps {
	TestContext testContext;
	SignInPage signinPage;
	
	public SignInPageSteps(TestContext context) {
		 testContext = context;
		 signinPage = testContext.getPageObjectManager().getSignInPage();
		 }
	
	@When("^user enter \"([^\"]*)\" and click on create an account button$")
	public void user_enter_and_click_on_create_an_account_button(String arg1) throws InterruptedException {
		signinPage.enterEmailAddress(arg1);
		Thread.sleep(5000);
//		String emailId = signinPage.enterEmailAddress1(arg1);
//		testContext.getScenarioContext().setContext(Context.EMAIL_ID,emailId);
//		System.out.println("New Email-Id:" +emailId);
		signinPage.clkOnCreateAccountBtn();
		Thread.sleep(5000);
	    
	}
	
	//AutomationPractice - Signin Page
	//@When("^user enters \"([^\"]*)\"$")
	@When("^user enters \"([^\"]*)\" on signin page$")
	public void user_enters_emailId (String arg1) throws InterruptedException {
		//String emailId = (String)testContext.scenarioContext.getContext(Context.EMAIL_ID);
		//String prodName = productPage.getProdName(prdName);
		//System.out.println("Email ID: "+emailId);
		signinPage.enterEmailId(arg1);		
	    
	}
	
	//AutomationPractice - Signin Page
	@When("^user enters email Id$")
 	public void user_enters_emailId() throws InterruptedException {
			String emailId = (String)testContext.scenarioContext.getContext(Context.EMAIL_ID);
			//String prodName = productPage.getProdName(prdName);
			System.out.println("Email ID: "+emailId);
			signinPage.enterEmailId(emailId);		
		    
		}
	
	@Then("^user enters \"([^\"]*)\" and click on signin Button$")
	public void user_enters_and_click_on_signin_Button(String arg1) throws InterruptedException {
		signinPage.enterPwd(arg1);
		signinPage.clkOnSignInBtn();
	    
	}
	
	
	//CRM
	@When("^user enter \"([^\"]*)\" and \"([^\"]*)\" on login page$")
	public void user_enter_credentials_on_login_page(String userName, String pwd){
		
		 StringBuilder cred = new StringBuilder(userName);
		 
		 System.out.println("tested-1: " +cred);
		 cred.append(":");
		 cred.append(pwd);
				
		 System.out.println("tested-2: " +cred);
		 
		HashMap<String, String> userMap = new HashMap<String, String>();
		
		//for (int i=0; i<userMap.size(); i++) {		
			String creds = cred.toString();
			System.out.println("tested-3: " +creds);
			userMap.put("user", creds);			
		//}		
			
			
			
	}
	
	
	//Amazon
	@When("^user enter \"([^\"]*)\" and click on continue button$")
	public void user_enter_and_click_on_continue_button(String email) throws InterruptedException {
		signinPage.enterEmailAdd(email);
		signinPage.clkOnContinueBtn();
	    
	}	
	
	@When("^user enter \"([^\"]*)\" and click on signin button$")
	public void user_enter_and_click_on_sign_in_button(String pwd) {
		signinPage.enterpassword(pwd);
		signinPage.clkSigninBtn();
	    
	}
	
}
