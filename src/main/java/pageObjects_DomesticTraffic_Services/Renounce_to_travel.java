package pageObjects_DomesticTraffic_Services;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;

public class Renounce_to_travel {
	WebDriver driver; 
	
	private HashMap<String, String> expectedTitles = new HashMap<String, String>();

	public Renounce_to_travel(WebDriver driver) {
		this.driver = driver; 
		
		expectedTitles.put("RO","Renunţarea la călătorie. Restituiri de tarife pentru transportul neefectuat. Reglementări");
		expectedTitles.put("EN","CFR Călători official website - Refunds, General valid Conditions, Travel withdrawal");
	}
	
	public String getExpectedTitle(String lang) {
		return expectedTitles.get(lang); 
	}

	
}
