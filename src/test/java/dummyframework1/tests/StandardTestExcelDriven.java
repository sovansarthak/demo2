package dummyframework1.tests;


import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.AssertJUnit;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import dummyframework1.pageComponents.BaseTest;
import dummyframework1.pageObjects.CartPage;
import dummyframework1.pageObjects.ConfirmationPage;
import dummyframework1.pageObjects.HomePage;
import dummyframework1.pageObjects.LandingPage;
import dummyframework1.pageObjects.OrderPage;



public class StandardTestExcelDriven extends BaseTest{
	
	   DataFormatter formatter= new DataFormatter();

	
	
	

   @Test(dataProvider="getData")	
   
   
		public void stdtest(String username, String password, String productname) throws IOException {

	   
		
			LandingPage landingPage=new LandingPage(driver);
			landingPage.goTo();
			landingPage.loginAction(username, password);
			HomePage homePage= new HomePage(driver);
			homePage.productSelection(productname);
			CartPage cartPage= new CartPage(driver);
			cartPage.goToCart();
			String finalproduct=cartPage.productVerification(productname);
		    AssertJUnit.assertEquals(finalproduct, productname);
		    OrderPage orderPage=new OrderPage(driver);
		    orderPage.goToOrderPage();
		    orderPage.countrySelection();
		    ConfirmationPage confirmationPage= new ConfirmationPage(driver);
	    	String confirmationtext=confirmationPage.orderConfirmation();
		    AssertJUnit.assertEquals(confirmationtext, "THANKYOU FOR THE ORDER.");
		

}
   
   @DataProvider
  
    public Object [] [] getData() throws IOException {
	   
//	   Object [][] data= {{"abcd@abcd.com", "March@2021", "ADIDAS ORIGINAL"}, {"qwerty@q.com", "March@2021", "ZARA COAT 3"}};

	   
	   FileInputStream file= new FileInputStream("/users/sovansarthak/Downloads/testdata3.xlsx");
	   XSSFWorkbook workbook= new XSSFWorkbook(file);
	   XSSFSheet sheet=workbook.getSheetAt(0);
	   int rowcount=sheet.getPhysicalNumberOfRows();
	   Row firstrow=sheet.getRow(0);
	   int columncount=firstrow.getLastCellNum();
	   Object [][] data=new Object [rowcount-1][columncount];

	   
	    for(int i=0; i<rowcount-1; i++) {
	    	 
	    	 Row row=sheet.getRow(i+1);   
	    	
	    	for(int j=0; j<columncount; j++) {
	    		
	    		Cell cell=row.getCell(j);
	    		data [i][j]=formatter.formatCellValue(cell);
	    		
	    	//	data [i][j]=formatter.formatCellValue(row.getCell(j));
	    		
	    		
	    		
	    	}
	    	
	    	
	    }
	   
	     
	   
	   workbook.close();
	   return data;
	
	   
	 
  }
    
}		

