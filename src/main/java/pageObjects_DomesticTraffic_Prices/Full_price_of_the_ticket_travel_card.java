package pageObjects_DomesticTraffic_Prices;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;

public class Full_price_of_the_ticket_travel_card {
	WebDriver driver; 
	
	private HashMap<String, String> expectedTitles = new HashMap<String, String>();

	public Full_price_of_the_ticket_travel_card(WebDriver driver) {
		this.driver = driver; 
		
		expectedTitles.put("RO","Site oficial CFR Călători - Preţul integral al legitimaţiilor de călătorie");
		expectedTitles.put("EN","CFR Călători official website - The full price of the ticket /travel card");
	}
	
	public String getExpectedTitle(String lang) {
		return expectedTitles.get(lang); 
	}
	
}
