package pageObjects;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import managers.FileReaderManager;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ProductPage {
	
	WebDriver driver;
	public ProductPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	//Amazon search Bar click
/*		@FindBy(how=How.XPATH,using = "//div[@data-index='5']//h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-2']//span[contains(text(),'Skullcandy Dime ')]")
		private static WebElement prdName;
		
		WebElement text = driver.findElement(By.xpath("//div[@data-index='4']//h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-2']//span[contains(text(),'Skullcandy Dime ')]"));				
		
		String txt = text.getText();
		
	*/	

				
		public void prodName() {
			WebElement text = driver.findElement(By.xpath("//div[@data-index='5']"));			
			String txt = text.getText();
			System.out.println("txt: " +txt);	
			//prdName.click();
			List<String> prd_Name = new LinkedList<String>();
			prd_Name.add(txt);
			
			Actions acs = new Actions(driver);
			acs.moveToElement(text).build().perform();
			acs.doubleClick(text).perform();

			
			
						
					
		for (int i=0;i< prd_Name.size(); i++) {
			List<String> prod_Name = prd_Name;
			System.out.println ("Product name: " +prod_Name);
			
		}
}
		
		
	//Amazon Add to cart click
	  @FindBy(how=How.XPATH,using = "//input[@id='add-to-cart-button']")
		private static WebElement addCartBtn;
	  
	//Amazon Accidental Damage
	  @FindBy(how=How.XPATH,using = "//span[@id='attachSiNoCoverage']")
		private static WebElement noThxBtn;
	  
		@FindBy(how=How.XPATH,using = "//span[@id='hlb-ptc-btn']")
		private static WebElement btnCheckOut;
		
		@FindBy(how=How.XPATH,using = "//a[@id='prime-no-thanks']")
		private static WebElement noPrimebtn;
	  
	  		public void addToCart() {
					addCartBtn.click();
					noThxBtn.click();
					
				/*	//WebElement text = driver.findElement(By.xpath("//span[@id='attachSiNoCoverage']"));
					WebElement text = driver.findElement(By.xpath("//input[@name = 'proceedToCheckout']"));
					
					String txt = text.getText();
					System.out.println("txt: " +txt);	
					//prdName.click();
					text.click();			
					*/
					
				}
	  		
	  		public void btnChkout() {
	  			btnCheckOut.click();
	  			
	  		}
	  		
	  		public void noPrimebtn() {
	  			noPrimebtn.click();
	  		}
	
}
