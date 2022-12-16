package dummyframework1.tests;

	import org.testng.annotations.Test;
import org.testng.AssertJUnit;
	import org.testng.annotations.Test;
import org.testng.AssertJUnit;
	import org.testng.annotations.Test;
import org.testng.AssertJUnit;
	import org.testng.annotations.Test;
import org.testng.AssertJUnit;
	import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import dummyframework1.pageComponents.BaseTest;
import dummyframework1.pageObjects.CartPage;
import dummyframework1.pageObjects.LandingPage;



	public class ErrorValidationTest extends BaseTest {
		
		String productname="ZARA COAT 3";
		By productlist= By.xpath("//div[@class='col-lg-4 col-md-6 col-sm-10 offset-md-0 offset-sm-1 mb-3 ng-star-inserted']");

		
		
		@Test
		
		 public void loginError() throws IOException {
			 
			LandingPage landingPage=new LandingPage(driver);
			landingPage.goTo();
			landingPage.loginAction("a@a.com", "wrongpw");
	        driver.findElement(productlist);
	        
		 }
		
		
		
		@Test
		
		  public void emptyCartValidation() {
			
			LandingPage landingPage=new LandingPage(driver);
			landingPage.goTo();
			landingPage.loginAction("abcd@abcd.com", "March@2021");
			CartPage cartPage= new CartPage(driver);
			cartPage.productVerification(productname);
			String product=cartPage.productVerification(productname);
		    AssertJUnit.assertEquals(product, productname);
			
		}
		


	}



