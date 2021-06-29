package stepDefinitions;
import cucumber.TestContext;
import pageObjects.MyAccountPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class MyAccountPageSteps {
	TestContext testContext;
	MyAccountPage myaccountPage;
	public MyAccountPageSteps(TestContext context) {
		 testContext = context;
		 myaccountPage = testContext.getPageObjectManager().getMyAccountPage();
	}
	
	
	@Then("^user validate fields$")
	public void user_validate_fields() {
		if(myaccountPage.validFieldname()) {
			System.out.println("Validation successful: ");
		}
		else {
			myaccountPage.logoutfromTheApplication();
			testContext.getWebDriverManager().closeDriver();
			throw new Error("Validation failed.");
		}
}

	
	@Then("^user logged in and navigate to my account page$")
	public void user_logged_in_and_navigate_to_my_account_page() {
			if(myaccountPage.comparePageTitle()) {
				//do nothing
			}
			else {
				myaccountPage.logoutfromTheApplication();
				testContext.getWebDriverManager().closeDriver();
				throw new Error("Navigation to My Account page unsucessful.");
			}
	}
	
	/*@When("^user clicks on \"([^\"]*)\" tab$")
	public void user_clicks_on_tab(String arg1) throws Throwable {
		myaccountPage.tshirtsTab();	
	}*/
	
	@When("^user clicks on \"([^\"]*)\" tab$")
	public void user_clicks_on_tab(String arg1) throws Throwable {
		myaccountPage.dressesTab();	
	}
	
	@Then ("^user clicks on dropdown tab$")
	public void user_clicks_dropdown_tab() throws Throwable {
		myaccountPage.dropDown();	
	}
	
	@Then ("^user product added to the cart$")
	public void user_product_added_to_cart() throws Throwable {
		myaccountPage.addTocart();	
	}
	
	@Then("^user clicks on proceed to checout tab$")
	public void user_clicks_on_proceed_checout_tab() throws Throwable {
		myaccountPage.prchkoutTab();	
	}
	
	@Then("^user clicks on checkout$")
	public void user_clicks_on_checkout_button() {
		myaccountPage.cartList();	
	}

	@Then("^user clicks on signout Button$")
	public void user_clicks_on_signout_button() {
		myaccountPage.logoutfromTheApplication();	
	}

	
	@Then("^user name \"([^\"]*)\" followed by \"([^\"]*)\" displayed in top right corner$")
	public void user_name_followed_by_displayed_in_top_right_corner(String arg1,String arg2) {
		if(myaccountPage.verifyloggedInUserName(arg1, arg2)) {
			//do nothing
		}
		else {
			myaccountPage.logoutfromTheApplication();
			testContext.getWebDriverManager().closeDriver();
			throw new Error("User name not displayed as expected."+arg1+" "+arg2);
		}
	}
	
 /*
	@Then("^user can see \"([^\"]*)\" link in My Account Page$")
	public void user_can_see_link_in_My_Account_Page(String arg1) {
		if(myaccountPage.verifyMywishlistlnkDisplayed(arg1)) {
			// do nothing
		}
		else {
			myaccountPage.logoutfromTheApplication();
			testContext.getWebDriverManager().closeDriver();
			throw new Error(" My Wishlists link is not displayed in My Account page.");
		}
	}
	@When("^user clicks on my wishlists link$")
	public void user_clicks_on_my_wishlists_link() {
		myaccountPage.clkMyWishlistslink();
	}
	*/
	
	//verifyMyperinfolnkDisplayed
	
	@Then("^user can see \"([^\"]*)\" link in My Account Page$")
	public void user_can_see_link_in_My_Account_Page(String arg1) {
		if(myaccountPage.verifyMyperinfolnkDisplayed(arg1)) {
			// do nothing
		}
		else {
			myaccountPage.logoutfromTheApplication();
			testContext.getWebDriverManager().closeDriver();
			throw new Error(" My Personalinfo link is not displayed in My Account page.");
		}
	}
	@When("^user clicks on My personal information link$")
	public void user_clicks_on_my_persinfo_link() {
		myaccountPage.clkMypersinfolink();
	}
	
	
	@Then("^user can confirm that item is added to the wishlist$")
	public void user_can_confirm_that_item_is_added_to_the_wishlist() {
		if(myaccountPage.VerifyTheQuantityequalsToOne()) {
			//do nothing
		}
		else {
			myaccountPage.logoutfromTheApplication();
			testContext.getWebDriverManager().closeDriver();
			throw new Error("validation failed");
		}
	}
	@Then("^logout from the application$")
	public void logout_from_the_application() {
		myaccountPage.logoutfromTheApplication();
		testContext.getWebDriverManager().closeDriver();
	}
	
	@Then("^user clicks on cart icon$")
	public void user_clicks_on_cart_icon() {
		myaccountPage.listCartItems();
			
		}
	}
