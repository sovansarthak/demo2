package dummyframework1.abstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class abstractComponents {
	
	WebDriver driver;
	
	public abstractComponents(WebDriver driver) {
		
		this.driver=driver;
	}
	
	
	
	public void visibilitywait(By locator) {
		
		 WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(7));
		  wait.until(ExpectedConditions.elementToBeClickable(locator));

		
	}
	
	public void invisibilitywait(By locator) {
		
		 WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(7));
//		 wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
		 wait.until(ExpectedConditions.elementToBeClickable(locator));

		
	}

}

