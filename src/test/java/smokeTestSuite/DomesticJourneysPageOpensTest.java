package smokeTestSuite;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BasePage;
import helperFunctions.TitlesMatch;
import pageObjects.DomesticJourneysSearchPage;
import pageObjects.HomePage;

public class DomesticJourneysPageOpensTest extends BasePage{
	
	public DomesticJourneysPageOpensTest() throws IOException {
		super();
	}
	
	@BeforeClass
	public void setup() {
		getDriver();
		setHomePageUrl();
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@Test
	public void testDomesticJourneysPageOpens() {
		HomePage HomePage = new HomePage(driver);
		HomePage.getDomesticJourneysLink().click();
		
		String currentWindow = driver.getWindowHandle(); 
		Set<String> allWindows = driver.getWindowHandles();
		
		Iterator<String> iterator = allWindows.iterator(); 

		while(iterator.hasNext()) {
			String window = iterator.next();
			if(window != currentWindow) {
				driver.switchTo().window(window);
			}
		}
		
		DomesticJourneysSearchPage DomesticJourneysPage = new DomesticJourneysSearchPage(driver);
		Assert.assertEquals(TitlesMatch.getTitlesMatch(driver.getTitle(), DomesticJourneysPage.getExpectedTitle(getLang())), true);
		
	}
	@AfterClass
	public void tearDown() {
		driver.quit();
		driver = null; 
	}
	

}
