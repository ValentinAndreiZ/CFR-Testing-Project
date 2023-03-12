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

public class SearchWithCalendarPickedDateLastAllowedDay extends BasePage{
	
	public SearchWithCalendarPickedDateLastAllowedDay() throws IOException {
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
	public void searchWithCalendarPickedDate() throws InterruptedException {
		DomesticJourneysSearchPage DomesticJourneysSearchPage = new DomesticJourneysSearchPage(driver);
		DomesticJourneysSearchPage.getDepartureStationInput().sendKeys(getProp().getProperty("departureStation"));
		DomesticJourneysSearchPage.getArrivalStationInput().sendKeys(getProp().getProperty("arrivalStation"));
		DomesticJourneysSearchPage.getDepartureDateButton().click();
		DomesticJourneysSearchPage.getLastDayTableCell(30).click();;
		
		HashMap<String, String> journeyInfo = DomesticJourneysSearchPage.getJourneyInfo();
		DomesticJourneysSearchPage.getSearchButton().click();
		
		boolean testPass = true; 
		
		DomesticJourneysSearchResultsPage DomesticJourneysSearchResultsPage = new DomesticJourneysSearchResultsPage(driver,journeyInfo);
		
		// First condition of test 
		// Reached SearchResults page with arrival and departure stations set in Search page and also the default date
		// Test will be performed for the h2 box information displayed at the top of the page search results page. 
		boolean headingInfoIsExpected = DomesticJourneysSearchResultsPage.validateSearchResultHeading(journeyInfo.get("departureStation"),journeyInfo.get("arrivalStation"),journeyInfo.get("departureDate"));
		
		if(headingInfoIsExpected == false) {
			testPass = false;
		}
		
		// Second condition of test 
		// For each journey card, the departure and arrival stations are the expected ones. The calendar day is also the same 
		// Test will be performed for the journey cards displayed 
		
		boolean cardInfoIsExpected = DomesticJourneysSearchResultsPage.validateSearchResultCards(journeyInfo.get("departureStation"), journeyInfo.get("arrivalStation"), journeyInfo.get("departureDate").substring(0,2));
		
		if(cardInfoIsExpected == false) {
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
