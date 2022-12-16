package dummyframework1.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import dummyframework1.abstractComponents.abstractComponents;

public class OrderPage extends abstractComponents{
	
	WebDriver driver;
	By countryList=By.cssSelector(".ta-item.list-group-item.ng-star-inserted");
	By countrySelection= By.xpath("//input[@placeholder='Select Country']");
	By placeOrderButton= By.cssSelector(".btnn.action__submit.ng-star-inserted");
	
	
	public OrderPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}

	public void goToOrderPage() {
		
		driver.findElement(By.xpath("//div/ul/li/button")).click();
		
	}
	
	public void countrySelection() {
		
		driver.findElement(countrySelection).sendKeys("ind");
		visibilitywait(countryList);
		List<WebElement> countries=driver.findElements(countryList);
		WebElement choice=countries.stream().filter(s->s.getText().equals("India")).findFirst().orElse(null);
		choice.click();
		driver.findElement(placeOrderButton).click();

		

		
	}

}
