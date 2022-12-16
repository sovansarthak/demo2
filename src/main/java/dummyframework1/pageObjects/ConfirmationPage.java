package dummyframework1.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import dummyframework1.abstractComponents.abstractComponents;

public class ConfirmationPage extends abstractComponents {
	
	WebDriver driver;
	
	public ConfirmationPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}

	By acknowledgementText= By.cssSelector(".hero-primary");
	
	public String orderConfirmation() {
		
		visibilitywait(acknowledgementText);
		String confirmationtext=driver.findElement(acknowledgementText).getText();
		return confirmationtext;
	}

}

