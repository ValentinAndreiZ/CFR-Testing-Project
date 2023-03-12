package pageObjects_DomesticTraffic_Offers;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;

public class Travel_card {
	WebDriver driver; 
	
	private HashMap<String, String> expectedTitles = new HashMap<String, String>();
	
	public Travel_card(WebDriver driver) {
		this.driver = driver; 
		
		expectedTitles.put("RO","Cartea de Călătorie, călătorii nelimitate, uiti de grija biletului!");
		expectedTitles.put("EN","Travel Card - CFR Calatori");
	}
	
		public String getExpectedTitle(String lang) {
			return expectedTitles.get(lang); 
		}
	
}
