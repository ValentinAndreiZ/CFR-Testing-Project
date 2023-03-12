package pageObjects;



import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DomesticJourneysSearchResultsPage {
	
	public WebDriver driver; 
	//All options set before searching for a journey are stored in the below hashmap. 
	//Those options will be compared to the ones that are found on the results page. 
	private HashMap<String,String> searchPageJourneyInfo = new HashMap<String, String>();
	
	HashMap<String, String> expectedTitles = new HashMap<String,String>();
	
	public DomesticJourneysSearchResultsPage(WebDriver driver, HashMap<String, String> journeyInfo){
		this.driver = driver; 
		
		expectedTitles.put("RO", "Rute + cumpără - Bilete online CFR Călători");
		expectedTitles.put("EN", "Itineraries + buy - CFR Călători online tickets");
		
		this.searchPageJourneyInfo = journeyInfo;
	}
	
	public HashMap<String, String> getSearchPageJourneyInfo() {
		return searchPageJourneyInfo;
	}
	
	public String getExpectedTitle(String lang) {
		return expectedTitles.get(lang);
	}
	
	// Responsible with getting the heading displayed above search result card list 
	public WebElement getHeadingJourneyInfo() {
		WebElement heading = driver.findElement(By.xpath("//div[@id='div-results']//h2"));
		return heading; 
	}
	
	public String getHeadingDepartureStation() {
		String departureStation = getHeadingJourneyInfo().findElement(By.xpath("./span[1]")).getText();
		return departureStation;
	}
	
	public String getHeadingArrivalStation() {
		String arrivalStation = getHeadingJourneyInfo().findElement(By.xpath("./span[2]")).getText();
		return arrivalStation;
	}
	
	public String getHeadingDate() {
		String input = getHeadingJourneyInfo().findElement(By.xpath("./span[3]")).getText();
	    Pattern pattern = Pattern.compile("\\d{2}.\\d{2}.\\d{4}");
	    Matcher matcher = pattern.matcher(input);
	    boolean matchFound = matcher.find();
	    if(matchFound) {
	    	input = matcher.group();
	    } else {
	    	input = null;
	    }
		return input;
	}
	
	public WebElement getAdvancedJourneyInfo() {
		WebElement heading = driver.findElement(By.xpath("//div[@id='div-results']/div[@class='jumbotron p-3']/p"));
		return heading; 
	}
	
	public WebElement getSearchResultsJourneysList() {
		WebElement unorderedList = driver.findElement(By.xpath("//div[@id='div-results']/ul[@class='list-group']"));
		return unorderedList; 
	}
	
	public int getSearchResultsJourneysListCount(){
		int journeysCount = getSearchResultsJourneysList().findElements(By.xpath("./li")).size();
		return journeysCount;
	}
	
	// Function responsible with validating that the fields found in h2 displayed in the top of search results page contains the values set in the 
	// search page
	public boolean validateSearchResultHeading(String expectedDepartureStation, String expectedArrivalStation, String expectedDepartureDate) {
		boolean h2infoIsValid = true; 
		
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='div-results']//h2")));
		
		if(!getHeadingDepartureStation().toLowerCase().equals(expectedDepartureStation.toLowerCase())) {
			h2infoIsValid = false;
		}
		
		if(!getHeadingArrivalStation().toLowerCase().equals(expectedArrivalStation.toLowerCase())) {
			h2infoIsValid = false;
		}
		
		if(!getHeadingDate().equals(expectedDepartureDate)) {
			h2infoIsValid = false;
			System.out.println("Heading info does not match!");
		}
		return h2infoIsValid;
	}
	
	// Function responsible with validating that the fields found in each journey card displayed are the same with the ones set in the 
	// search page
	public boolean validateSearchResultCards(String expectedDepartureStation, String expectedArrivalStation, String expectedDepartureDay){
		
		boolean cardInfoIsValid = true; 
		
		// All fields to be validated with expected values
		String cardDepartureStation = new String(); 
		String cardArrivalStation = new String(); 
		
		String cardDetailsDepartureStation = new String(); 
		String cardDetailsArrivalStation = new String(); 
		String cardDetailsDepartureDateDay = new String(); 
		String cardDetailsArrivalDateDay = new String(); 
		
		// Create a list of all journeys displayed on the page 
		List<WebElement> journeyCards = getSearchResultsJourneysList().findElements(By.xpath("./li"));
		// Iterate through the list 
		for (int i = 0; i<journeyCards.size(); i++) {
			WebElement journeyCard = journeyCards.get(i); 
			// Wait for journeyCard to get clickable
			new WebDriverWait(driver, Duration.ofSeconds(10))
			.until(ExpectedConditions.elementToBeClickable(journeyCard));
			
			// For each journey card firstly find the information displayed on the card itself and store the departure and arrival stations
			 cardDepartureStation = journeyCard.findElement(By.xpath("./div[@class='div-itinerary-station line-height-1-5']/div/div/div/div/div/div[3]/span[1]")).getAttribute("textContent").trim();
			 cardArrivalStation = journeyCard.findElement(By.xpath("./div[@class='div-itinerary-station line-height-1-5']/div/div/div[4]/div/div/div[3]")).getAttribute("textContent").trim();
			
			// For each journey card find the button displaying the journey details and click it
			journeyCard.findElement(By.xpath("./div[1]//button[1]")).click();
			// For each card display the joruney card details box 
			WebElement journeyCardDetailsContainer = journeyCard.findElement(By.xpath("./div[@class='container']"));
			// Wait for journeyCardContainer to get clickable
			new WebDriverWait(driver, Duration.ofSeconds(10))
	        .until(ExpectedConditions.elementToBeClickable(journeyCardDetailsContainer));
			
			// Getting all the information needed from each joruney details card in order to assert that it corresponds with the information set in the searchPage
			 cardDetailsDepartureStation = journeyCardDetailsContainer.findElement(By.xpath("./div[1]//ul[@class='list-group list-group-itinerary-part w-100']/li[1]/div/div/div[@class='row']/div[@class='col-9 color-blue text-1-1rem']")).getAttribute("textContent").trim();
			 cardDetailsArrivalStation = journeyCardDetailsContainer.findElement(By.xpath("./div[1]//ul[@class='list-group list-group-itinerary-part w-100']/li[3]/div/div/div[@class='row']/div[@class='col-9 color-blue text-1-1rem']")).getAttribute("textContent").trim();		
			 cardDetailsDepartureDateDay = journeyCard.findElement(By.xpath("./div[@class='container']/div[1]//ul[@class='list-group list-group-itinerary-part w-100']/li[2]/div/div[1]/div[1]/div[@class='col-9']/div")).getAttribute("textContent").trim().substring(4,6);
			 cardDetailsArrivalDateDay = journeyCard.findElement(By.xpath("./div[@class='container']/div[1]//ul[@class='list-group list-group-itinerary-part w-100']/li[2]/div/div[1]/div[4]/div[@class='col-9']/div")).getAttribute("textContent").trim().substring(4,6);
			
			
			// Validate all fields are the expected ones 
			if(!cardDepartureStation.toLowerCase().equals(expectedDepartureStation.toLowerCase()) || 
			   !cardArrivalStation.toLowerCase().equals(expectedArrivalStation.toLowerCase()) || 
			   !cardDetailsDepartureStation.toLowerCase().equals(expectedDepartureStation.toLowerCase()) || 
			   !cardDetailsArrivalStation.toLowerCase().equals(expectedArrivalStation.toLowerCase()) || 
			   !cardDetailsDepartureDateDay.equals(expectedDepartureDay)) 
			{
				cardInfoIsValid = false;
				System.out.println("Card info does not match!");
				System.out.println("Expected departure station was " + expectedDepartureStation + " Found " + cardDepartureStation + " in card itself");
				System.out.println("Expected arrival station was " + expectedArrivalStation + " Found " + cardArrivalStation + " in card itself");
				System.out.println("Expected departure station was " + expectedDepartureStation + " Found " + cardDetailsDepartureStation + " in card details");
				System.out.println("Expected arrival station was " + expectedArrivalStation + " Found " + cardDetailsArrivalStation + " in card details");
				System.out.println("Expected departure day was " + expectedDepartureDay + " Found " + cardDetailsDepartureDateDay);
			}
		}
		
		return cardInfoIsValid; 
	}
	
}
