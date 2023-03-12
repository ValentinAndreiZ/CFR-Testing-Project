package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationDonePage {
	
	public WebDriver driver; 
	
	public RegistrationDonePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getRegistrationDonePageUrl() {
		String registrationPageUrl = driver.getCurrentUrl();
		return registrationPageUrl; 
	}
	
	
}
