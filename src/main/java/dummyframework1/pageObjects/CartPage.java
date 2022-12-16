package dummyframework1.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import dummyframework1.abstractComponents.abstractComponents;

public class CartPage extends abstractComponents{
	
	WebDriver driver;
	By loader= By.cssSelector(".ng-animating");
	By toast= By.id("toast-container");
	By cartButton=By.xpath("//button[@routerlink='/dashboard/cart']");
	By cartProductList= By.xpath("//div[@class='cartSection']/h3");
	
	
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}

	public void goToCart() {
		
		  invisibilitywait(loader);
		  visibilitywait(toast);
		  driver.findElement(cartButton).click();
		
	}
	
	public String productVerification(String productname) {
		
		visibilitywait(cartProductList);
		List<WebElement> prodlist= driver.findElements(cartProductList);
	   	String finalproduct= prodlist.stream().filter(s->s.getText().contains(productname)).findFirst().orElse(null).getText();
	   	return finalproduct;
		

	}

}

