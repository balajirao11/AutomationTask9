package stepDefinitions;

import cucumber.api.java.en.When;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

import org.junit.Assert;
import org.openqa.selenium.By;

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
		
	@And("^user clicks on productname$")
	public void user_clicks_on_productname() throws InterruptedException {
		String prdName = null;
		//productPage.getProdName(prdName);
		String productName = productPage.getProdName(prdName);
		testContext.getScenarioContext().setContext(Context.PRODUCT_NAME,productName);
		Thread.sleep(5000);
	}
	
	
	@And("^user validate the product name$")
	public void user_validate_the_product_name() throws InterruptedException {
		String prdName= null;
		String cartName = null;
		String productName = (String)testContext.scenarioContext.getContext(Context.PRODUCT_NAME);
		//String prodName = productPage.getProdName(prdName);
		String crtName = productPage.cartProdName(cartName);
		try {
			Assert.assertEquals(productName, crtName);
			System.out.println("Selected product matched with product in cart ");
		}catch (Exception e) {
			System.out.println("Selected product not matched with product in cart ");
		}
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
