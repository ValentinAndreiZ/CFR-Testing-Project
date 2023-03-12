package pageObjects_DomesticTraffic_Services;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;

public class Animal_transport_services {
	WebDriver driver; 
	
	private HashMap<String, String> expectedTitles = new HashMap<String, String>();
	
	public Animal_transport_services(WebDriver driver) {
		this.driver = driver; 
		
		expectedTitles.put("RO","Transportul animalelor de companie");
		expectedTitles.put("EN","CFR Călători official website - Animal transport services");
	}
	
	public String getExpectedTitle(String lang) {
		return expectedTitles.get(lang); 
	}

	
}
