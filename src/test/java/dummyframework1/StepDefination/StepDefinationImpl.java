package dummyframework1.StepDefination;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.AssertJUnit;

import dummyframework1.pageComponents.BaseTest;
import dummyframework1.pageObjects.CartPage;
import dummyframework1.pageObjects.ConfirmationPage;
import dummyframework1.pageObjects.HomePage;
import dummyframework1.pageObjects.LandingPage;
import dummyframework1.pageObjects.OrderPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinationImpl extends BaseTest {
	
	
	public WebDriver driver; 
	LandingPage landingPage=new LandingPage(driver);
	HomePage homePage= new HomePage(driver);
	CartPage cartPage= new CartPage(driver);
    OrderPage orderPage=new OrderPage(driver);
	ConfirmationPage confirmationPage= new ConfirmationPage(driver);



	
	
	@Given("I have landed on the landing page")
	
	public void I_have_landed_on_the_landing_page() throws IOException {
		
		WebDriver driver=initiatedriver();
		landingPage.goTo();
		
	}
	
	@Given("^Logged in with (.+) and (.+)$")
	
	public void logged_in_with_email_and_password(String email, String password) {
		
		landingPage.loginAction(email, password);
				
	}
	
	@When("^I add (.+) to cart$")
	
	public void I_add_productname_to_cart(String productname) {
		
		homePage.productSelection(productname);
		
	}
	
	@And("^Checkout (.+) and confirm order$")
	
	public void Checkout_and_confirm_order(String productname) {
		
		cartPage.goToCart();
		String finalproduct=cartPage.productVerification(productname);
	    AssertJUnit.assertEquals(finalproduct, productname);
	    orderPage.goToOrderPage();
	    orderPage.countrySelection();
		
	}
	
	@Then("{string} is displayed on the page")
	
	 public void string_is_displayed_on_the__page(String string) {
		
    	String confirmationtext=confirmationPage.orderConfirmation();
	    AssertJUnit.assertEquals(confirmationtext, (string));
		
		
	}

}
