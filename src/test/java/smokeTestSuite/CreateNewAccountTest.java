package smokeTestSuite;

import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.UUID;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BasePage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.RegisterPage;
import pageObjects.RegistrationDonePage;

public class CreateNewAccountTest extends BasePage {
	
	private String id = UUID.randomUUID().toString(); 
	
	
	public CreateNewAccountTest() throws IOException {
		super();
	}
	
	@BeforeClass
	public void setup() {
		driver = getDriver();
		setHomePageUrl();
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@Test
	public void testCreateNewAccount() {
		//Creating instance of home page
		HomePage HomePage = new HomePage(driver);
		HomePage.goToLoginPage();

		//Getting current window handle
		String mainWindowHandle = driver.getWindowHandle();
		
		//Switching focus to the LogInPage 
		Set<String> allWindowHandles = driver.getWindowHandles();
		
		Iterator<String> iterator = allWindowHandles.iterator(); 
		while (iterator.hasNext()) {
			String ChildWindow = iterator.next();
			
			if(!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
				driver.switchTo().window(ChildWindow);
			}
		}
		
		//Creating instance of login page 
		LoginPage LogInPage = new LoginPage(driver);
		
		//Navigating to create new account link 
		LogInPage.getCreateAccountLink().click();
		
		//Creating instance of RegisterPage
		RegisterPage RegisterPage = new RegisterPage(driver);
		//Populating account creation mandatory input fields
		RegisterPage.getFirstNameInput().sendKeys("TestFirstName1");
		RegisterPage.getLastNameInput().sendKeys("TestLastName1");
		RegisterPage.getEmailInput().sendKeys("TestEmail" + id + "@yahoo.com");
		RegisterPage.getPhoneInput().sendKeys("0775606909");
		RegisterPage.getPasswordInput().sendKeys("TestPassword1");
		RegisterPage.getConfirmPasswordInput().sendKeys("TestPassword1");
		
		//Interacting with the agree terms and conditions checkbox
		RegisterPage.getTermsAndConditionsCheckbox().click();
		// Waiting for the terms and conditions modal to appear in order to reach the agree button. 
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(RegisterPage.getByAgreeTermsModal()));
		RegisterPage.getTermsAndConditionsAgreeButton().click();
		
		//Interacting with the privacy policy checkbox
		RegisterPage.getPrivacyPolicyCheckbox().click();
		// Waiting for the privacy policy modal to appear in order to reach the agree button. 
		wait.until(ExpectedConditions.visibilityOfElementLocated(RegisterPage.getByPrivacyPolicyModal()));
		RegisterPage.getAcceptPrivacyPolicyButton().click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(RegisterPage.getBySubmitButton()));
		RegisterPage.getRegisterButton().click();
		
		//Asserting that the page reached contains the "RegistrationDone" string. 
		//This test may apply for all localizations as the string is present in the url path
		RegistrationDonePage RegistrationDonePage = new RegistrationDonePage(driver);
		Assert.assertEquals(RegistrationDonePage.getRegistrationDonePageUrl().contains("RegistrationDone"), true); 	
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
		driver = null; 
	}
	
}
