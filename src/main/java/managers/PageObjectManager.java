package managers;
import org.openqa.selenium.WebDriver;
import pageObjects.HomePage;
import pageObjects.MyAccountPage;
import pageObjects.SignInPage;
import pageObjects.FormDetails;
import pageObjects.MyWishlistsPage;
import pageObjects.SpecificItemPage;
import pageObjects.ProductPage;

public class PageObjectManager {
	 
	private WebDriver driver;
	 
	private HomePage homePage;
	private SignInPage signinPage;
	private FormDetails formDetails;
	private MyAccountPage myaccountPage;
	private MyWishlistsPage mywishlistsPage;
	private SpecificItemPage specificitemPage;
	private ProductPage productPage;
	 

	//Constructor
	public PageObjectManager(WebDriver driver) {
		 this.driver = driver;
	 }
	 //Ternary operator ?:
	//Page object creation method, if null create new object of the page,else create a new (homePage)
	public HomePage getHomePage(){
		 return (homePage == null) ? homePage = new HomePage(driver) : homePage;
	}
	public SignInPage getSignInPage() {
		return (signinPage == null) ? signinPage = new SignInPage(driver) : signinPage;
	}
	public FormDetails getFormDetails() {
		return (formDetails == null) ? formDetails = new FormDetails(driver) : formDetails;
	}
	public MyAccountPage getMyAccountPage() {
		return (myaccountPage == null) ? myaccountPage = new MyAccountPage(driver) : myaccountPage;
	}
	
	public ProductPage getProductPage(){	 
		 return (productPage == null) ? productPage = new ProductPage(driver) : productPage;
   }
	public MyWishlistsPage getMyWishlistsPage(){	 
		 return (mywishlistsPage == null) ? mywishlistsPage = new MyWishlistsPage(driver) : mywishlistsPage;
    }	 
	public SpecificItemPage getSpecificItemPage() {	 
		 return (specificitemPage == null) ? specificitemPage = new SpecificItemPage(driver) : specificitemPage;
	}

}