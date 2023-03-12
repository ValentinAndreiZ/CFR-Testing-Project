package domesticJourneysSuite_BasicSearch_PositiveFlows;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BasePage;
import pageObjects.DomesticJourneysSearchPage;
import pageObjects.DomesticJourneysSearchResultsPage;

public class SearchWithReverseStationsWidgetTest extends BasePage{
	
	public SearchWithReverseStationsWidgetTest() throws IOException {
			super();
		}
	
	@BeforeClass
	public void setup() {
		setDomesticJourneysUrl();
		getDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@Test
	public void searchWithReverseStationsWidget() {
		DomesticJourneysSearchPage DomesticJourneysSearchPage = new DomesticJourneysSearchPage(driver);
		DomesticJourneysSearchPage.getDepartureStationInput().sendKeys(getProp().getProperty("departureStation"));
		DomesticJourneysSearchPage.getArrivalStationInput().sendKeys(getProp().getProperty("arrivalStation"));
		DomesticJourneysSearchPage.getReverseStationsButton().click();
		
		HashMap<String, String> journeyInfo = DomesticJourneysSearchPage.getJourneyInfo();
		
		DomesticJourneysSearchPage.getSearchButton().click();
		
		DomesticJourneysSearchResultsPage DomesticJourneysSearchResultsPage = new DomesticJourneysSearchResultsPage(driver, journeyInfo);
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='div-results']//h2")));

		boolean testPass = true; 
		
		// First condition of test 
		// Reached SearchResults page with arrival and departure stations set in Search page and also the default date
		
		if(!DomesticJourneysSearchResultsPage.getHeadingArrivalStation().equals(journeyInfo.get("arrivalStation"))) {
			testPass = false;
		}
		if(!DomesticJourneysSearchResultsPage.getHeadingDepartureStation().equals(journeyInfo.get("departureStation"))) {
			testPass = false;
		}
		if(!DomesticJourneysSearchResultsPage.getHeadingDate().equals(journeyInfo.get("departureDate"))) {
			testPass = false;
		}
		
		// Second condition of test 
		// The SearchResults page has 5 journeys displayed
		
		if(DomesticJourneysSearchResultsPage.getSearchResultsJourneysListCount() != 5) {
			testPass = false;
		}
		
		Assert.assertEquals(testPass, true);
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
		driver = null; 
	}
	
}
