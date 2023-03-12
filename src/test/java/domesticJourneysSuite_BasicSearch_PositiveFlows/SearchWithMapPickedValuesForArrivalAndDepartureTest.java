package domesticJourneysSuite_BasicSearch_PositiveFlows;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.DomesticJourneysSearchPage;
import pageObjects.DomesticJourneysSearchResultsPage;
import base.BasePage;

public class SearchWithMapPickedValuesForArrivalAndDepartureTest extends BasePage {
	
	public SearchWithMapPickedValuesForArrivalAndDepartureTest() throws IOException {
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
	void SearchWithMapPickedValuesForArrivalAndDeparture() throws InterruptedException {
		
		// 1. Setting the value of departureStation field by map picker
		DomesticJourneysSearchPage DomesticJourneysSearchPage = new DomesticJourneysSearchPage(driver);
		DomesticJourneysSearchPage.getDepartureStationMapButton().click();
		// Waiting for map to get interactable
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("/html//div[@id=\"div-fullscreen-map-div\"]")));
		// Setting cursor location on the location we want to get the stations list from 
		WebElement mapDiv = DomesticJourneysSearchPage.getMapDiv();
		Actions action = new Actions(driver);
		action.moveToElement(mapDiv).moveByOffset(100, 190);
		// Double clicking on the location in order to zoom in multiple times (Bucuresti) 
		for(int i=0; i<=5; i++) {
			Thread.sleep(1000);
			action.doubleClick().perform();
		}
		// Select the station from the list 
		DomesticJourneysSearchPage.getSelectLocationButton().click();
		Thread.sleep(1000);
		DomesticJourneysSearchPage.getStationButton(3).click();
		
		// 2. Setting the value of arrivalStation field by map picker
		DomesticJourneysSearchPage.getArrivalStationMapButton().click();
		// Setting cursor location on the location we want to get the stations list from 
		action.moveToElement(mapDiv).moveByOffset(-135, -140);
		// Double clicking on the location in order to zoom in multiple times (Cluj)
				for(int i=0; i<=4; i++) {
					Thread.sleep(1000);
					action.doubleClick().perform();
				}
		// Select the station from the list 
		DomesticJourneysSearchPage.getSelectLocationButton().click();	
		Thread.sleep(1000);
		DomesticJourneysSearchPage.getStationButton(2).click();		
		
		// 3. Creating test conditions 
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
