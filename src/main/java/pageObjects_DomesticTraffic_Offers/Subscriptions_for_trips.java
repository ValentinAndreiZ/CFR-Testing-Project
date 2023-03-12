package pageObjects_DomesticTraffic_Offers;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;

public class Subscriptions_for_trips {
	WebDriver driver; 
	
	private HashMap<String, String> expectedTitles = new HashMap<String, String>();

	public Subscriptions_for_trips(WebDriver driver) {
		this.driver = driver;
		
		expectedTitles.put("RO","Abonamentul de călătorie! Lunar sau Săptămânal? Nelimitat sau Flexi?");
		expectedTitles.put("EN","Subscriptions - CFR Calatori");
	}
	
	public String getExpectedTitle(String lang) {
		return expectedTitles.get(lang); 
	}
	




		
	
}
