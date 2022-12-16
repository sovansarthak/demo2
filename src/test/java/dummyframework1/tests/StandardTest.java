package dummyframework1.tests;


import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.AssertJUnit;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import dummyframework1.pageComponents.BaseTest;
import dummyframework1.pageObjects.CartPage;
import dummyframework1.pageObjects.ConfirmationPage;
import dummyframework1.pageObjects.HomePage;
import dummyframework1.pageObjects.LandingPage;
import dummyframework1.pageObjects.OrderPage;



public class StandardTest extends BaseTest{
	
	
	

   @Test(dataProvider="getData")	
   
   
//		public void stdtest(String username, String password, String productname) throws IOException {
		public void stdtest(HashMap <String, String> input) throws IOException {

	   
		
			LandingPage landingPage=new LandingPage(driver);
			landingPage.goTo();
			landingPage.loginAction(input.get("email"), input.get("pw"));
			HomePage homePage= new HomePage(driver);
			homePage.productSelection(input.get("productname"));
			CartPage cartPage= new CartPage(driver);
			cartPage.goToCart();
			String finalproduct=cartPage.productVerification(input.get("productname"));
		    AssertJUnit.assertEquals(finalproduct, input.get("productname"));
		    OrderPage orderPage=new OrderPage(driver);
		    orderPage.goToOrderPage();
		    orderPage.countrySelection();
		    ConfirmationPage confirmationPage= new ConfirmationPage(driver);
	    	String confirmationtext=confirmationPage.orderConfirmation();
		    AssertJUnit.assertEquals(confirmationtext, "THANKYOU FOR THE ORDER.");
		

}
   
   @DataProvider
  
    public Object [] [] getData() throws IOException {
	   
	   List<HashMap<String, String>> data= dataReaderJSONtoMap(System.getProperty("user.dir")+"/src/test/java/dummyframework1/data/standardTest.json");
	   return new Object [][] {{data.get(0)}, {data.get(1)}};
	  
// 	  Object [][] data= {{"abcd@abcd.com", "March@2021", "ADIDAS ORIGINAL"}, {"qwerty@q.com", "March@2021", "ZARA COAT 3"}};
//	   return data;
	  
  }
    
}		
