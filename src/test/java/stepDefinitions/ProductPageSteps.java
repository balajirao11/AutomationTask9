package stepDefinitions;

import cucumber.api.java.en.When;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.TestContext;
import enums.Context;
import pageObjects.ProductPage;

public class ProductPageSteps {
	//this class will display the products page.	
		 TestContext testContext;
		 ProductPage productPage;
		 public ProductPageSteps(TestContext context) {
			 testContext = context;
			 productPage = testContext.getPageObjectManager().getProductPage();
		}
		
	@When("user clicks on productname$")
	public void user_clicks_on_productname() throws InterruptedException {
		productPage.prodName();
		Thread.sleep(5000);
		
	}
	
	@When("user click on Add to Basket$")
	public void user_click_on_Add_to_Basket() throws InterruptedException {
		productPage.addToCart();
		Thread.sleep(5000);
		
	}
	
	@And("user clicks on proceed to checkout button$")
	public void user_clicks_on_proceed_to_checkout_bt() throws InterruptedException {
		productPage.btnChkout();
		Thread.sleep(5000);
		
	}
	
	@Then("user clicks on without prime$")
	public void user_clicks_on_without_prime() {
		productPage.noPrimebtn();
	}
	
	
	//@Then("")

}
