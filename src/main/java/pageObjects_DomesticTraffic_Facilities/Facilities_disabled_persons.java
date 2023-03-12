package pageObjects_DomesticTraffic_Facilities;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;

public class Facilities_disabled_persons {
	WebDriver driver; 
	
	private HashMap<String, String> expectedTitles = new HashMap<String, String>();

	public Facilities_disabled_persons(WebDriver driver) {
		this.driver = driver; 
		
		expectedTitles.put("RO","Facilități pentru persoanele cu handicap - CFR Calatori");
		expectedTitles.put("EN","Facilities for disabled persons - CFR Calatori");

	}
	
	public String getExpectedTitle(String lang) {
		return expectedTitles.get(lang); 
	}
}
