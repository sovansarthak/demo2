package dummyframework1.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import dummyframework1.abstractComponents.abstractComponents;

public class HomePage extends abstractComponents {
	
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		super(driver);
		this.driver=driver;		
	    }
	
	By productList=By.xpath("//div[@class='col-lg-4 col-md-6 col-sm-10 offset-md-0 offset-sm-1 mb-3 ng-star-inserted']");
    
	public void productSelection(String productname) {
		
		visibilitywait(productList);
		List<WebElement> first=driver.findElements(productList);
		WebElement prod=first.stream().filter(s->s.getText().contains(productname)).findFirst().orElse(null);
		prod.findElement(By.cssSelector(".btn.w-10.rounded")).click();
		
		
	}
	

}
