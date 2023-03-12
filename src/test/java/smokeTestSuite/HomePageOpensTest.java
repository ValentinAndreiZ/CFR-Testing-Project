package smokeTestSuite;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BasePage;
import helperFunctions.TitlesMatch;
import pageObjects.HomePage;

public class HomePageOpensTest extends BasePage {
	
	public HomePageOpensTest() throws IOException {
		super();
	}

	@BeforeClass
	public void setup() throws IOException {
		getDriver();
		setHomePageUrl();
		driver.get(url);
		driver.manage().window().maximize();
	}

	@Test
	public void testHomePageOpens() throws IOException {
		//Creating a HomePage instance
		HomePage HomePage = new HomePage(driver);
		//Checking if the page title is the expected one according to project localization
		String HomePageTitle = driver.getTitle();
		Assert.assertEquals(TitlesMatch.getTitlesMatch(HomePageTitle, HomePage.getExpectedTitle(getLang())), true);
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
		driver = null; 
	}
	
}
