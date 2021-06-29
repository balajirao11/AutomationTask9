package stepDefinitions;

import cucumber.api.java.en.Given;

import org.junit.Before;

import cucumber.TestContext;
import pageObjects.HomePage;

//this class will take user to the sign on page.
public class HomePageSteps {
	 TestContext testContext;
	 HomePage homePage;
	 public HomePageSteps(TestContext context) {
		 testContext = context;
		 homePage = testContext.getPageObjectManager().getHomePage();
	}
	
	
	
	@Given("^user launched the browser successfully$")
	public void user_launched_the_browser_successfully() {
		homePage.navigateTo_HomePage();
		
	}
	
	//AutomationPractice -- sign in page 
   @Before
		@Given("^user is on Application landing page$")
		public void user_is_on_Signon_page() {
			homePage.navigateTo_HomePage();
			homePage.clkOnSignInlink();
		}
	
	
	@Given("^user search for product in search bar$")
	public void user_search_for_product_in_search_bar() {
		homePage.navigateTo_HomePage();
		homePage.searchBar();
		homePage.searchClick();
	}
	
	
	//span[contains(text(),'Skullcandy Dime True Wireless')]
	
	
}
