package smokeTestSuite;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BasePage;
import pageObjects.HomePage;
import pageObjects.DomesticJourneysSearchPage;
import pageObjects.LoginPage;

public class LoginWithExistingAccountTest extends BasePage {
	
	public LoginWithExistingAccountTest() throws IOException {
		super();
	}
	
	@BeforeClass
	public void setup(){
		getDriver();
		setHomePageUrl();
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@Test
	public void testLoginWithExistingAccount() {
		HomePage HomePage = new HomePage(driver);
		HomePage.goToLoginPage();
		
		LoginPage LoginPage = new LoginPage(driver);
		
		String window1 = driver.getWindowHandle();
		Set <String> allWindows = driver.getWindowHandles();
		
		Iterator<String> iterator = allWindows.iterator();

		while(iterator.hasNext()) {
			String window  =  (String) iterator.next();
			if(window != window1) {
				driver.switchTo().window(window);
			}
		}
		
		LoginPage.getUserInput().sendKeys(LoginPage.getUser());
		LoginPage.getPasswordInput().sendKeys(LoginPage.getPassword());
		LoginPage.getLoginButton().click();
		
		DomesticJourneysSearchPage DomesticJourneysSearchPage = new DomesticJourneysSearchPage(driver);
		Assert.assertEquals(driver.getTitle(), DomesticJourneysSearchPage.getExpectedTitle(getLang()));
	
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
		driver = null; 
	}
	
}
