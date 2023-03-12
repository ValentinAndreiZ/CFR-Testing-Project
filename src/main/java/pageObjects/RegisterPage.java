package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage {
	public WebDriver driver;
//	public By ByAgreePrivacy = By.xpath("/html//button[@id='button-is-privacy-policy-accepted']");
	private By ByAgreeTermsModal = By.xpath("/html//div[@id='modalTermsConditions']");
	private By ByPrivacyPolicyModal = By.xpath("/html//div[@id='modalPrivacyPolicy']");
	private By BySubmitButton = By.xpath("/html//button[@id='button-register']");
	
	
	public RegisterPage(WebDriver driver) {
		this.driver = driver; 
	}

	public By getByAgreeTermsModal() {
		return ByAgreeTermsModal;
	}
	
	public By getByPrivacyPolicyModal() {
		return ByPrivacyPolicyModal;
	}
	
	public By getBySubmitButton() {
		return BySubmitButton;
	}
	
	public WebElement getFirstNameInput() {
		WebElement input = driver.findElement(By.xpath("/html//input[@id='FirstName']"));
		return input;
	}
	
	public WebElement getLastNameInput() {
		WebElement input = driver.findElement(By.xpath("/html//input[@id='LastName']"));
		return input;
	}
	
	public WebElement getEmailInput() {
		WebElement input = driver.findElement(By.xpath("/html//input[@id='Email']"));
		return input;
	}
	
	public WebElement getPhoneInput() {
		WebElement input = driver.findElement(By.xpath("/html//input[@id='PhoneNumber']"));
		return input;
	}
	
	public WebElement getPasswordInput() {
		WebElement input = driver.findElement(By.xpath("/html//input[@id='Password']"));
		return input;
	}
	
	public WebElement getConfirmPasswordInput() {
		WebElement input = driver.findElement(By.xpath("/html//input[@id='ConfirmPassword']"));
		return input;
	}
	
	public WebElement getPrivacyPolicyCheckbox() {
		WebElement input = driver.findElement(By.xpath("/html//input[@id='input-is-privacy-policy-accepted']"));
		return input;
	}
	
	public WebElement getPrivacyPolicyModal() {
		WebElement modal = driver.findElement(ByPrivacyPolicyModal);
		return modal;
	}
	
	public WebElement getAcceptPrivacyPolicyButton() {
		WebElement modalContainer = getPrivacyPolicyModal();
		WebElement button = modalContainer.findElement(By.xpath("/html//button[@id='button-is-privacy-policy-accepted']"));
		return button;
	}
	
	public WebElement getTermsAndConditionsCheckbox() {
		WebElement input = driver.findElement(By.xpath("/html//input[@id='input-are-terms-accepted']"));
		return input;
	}
	
	public WebElement getTermsAndConditionsModal() {
		WebElement modal = driver.findElement(getByAgreeTermsModal());
		return modal;
	}
	
	public WebElement getTermsAndConditionsAgreeButton() {
		WebElement modalContainer = getTermsAndConditionsModal();
		WebElement button = modalContainer.findElement(By.cssSelector("button#button-are-terms-accepted"));			
		return button;
	}


	public WebElement getRegisterButton() {
		WebElement button = driver.findElement(By.xpath("/html//button[@id='button-register']"));
		return button;
	}
}
