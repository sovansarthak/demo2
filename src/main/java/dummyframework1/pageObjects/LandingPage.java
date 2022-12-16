package dummyframework1.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import dummyframework1.abstractComponents.abstractComponents;

public class LandingPage extends abstractComponents {
	
	WebDriver driver;
	
	
	public LandingPage(WebDriver driver) {
		
		super(driver);
		this.driver=driver;
		
	}
	
	public void goTo() {
		
		driver.get("https://rahulshettyacademy.com/client/");
		driver.manage().window().maximize();
		
	}
	
	public void loginAction(String useremail, String userpw) {
		
		driver.findElement(By.id("userEmail")).sendKeys(useremail);
		driver.findElement(By.id("userPassword")).sendKeys(userpw);
		driver.findElement(By.id("login")).click();
		
	}
	
	
	

}

