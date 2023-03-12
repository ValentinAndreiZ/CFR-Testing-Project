package pageObjects_DomesticTraffic_Prices;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;

public class Train_tickets {
	WebDriver driver; 
	
	private HashMap<String, String> expectedTitles = new HashMap<String, String>();
	
	public Train_tickets(WebDriver driver) {
		this.driver = driver; 
		
		expectedTitles.put("RO","Site oficial CFR Călători - Taxarea în tren, tarife şi reglementări");
		expectedTitles.put("EN","CFR Călători official website - Buying tickets on the train.");
	}
	
	public String getExpectedTitle(String lang) {
		return expectedTitles.get(lang); 
	}
}
