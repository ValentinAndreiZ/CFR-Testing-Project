package pageObjects_DomesticTraffic_Offers;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;

public class Round_trip_ticket {
	WebDriver driver; 
	
	
	private HashMap<String, String> expectedTitles = new HashMap<String, String>();

	public Round_trip_ticket(WebDriver driver) {
		this.driver = driver; 

		expectedTitles.put("RO","Biletul dus - întors! Alege să călătrești cu noi și te bucuri de reduceri!");
		expectedTitles.put("EN","Round-trip ticket");
	
	}
	
	public String getExpectedTitle(String lang) {
		return expectedTitles.get(lang); 
	}
	
}
