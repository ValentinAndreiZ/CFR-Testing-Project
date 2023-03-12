package pageObjects_DomesticTraffic_Facilities;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;

public class Facilities_for_revolutionaries {
	WebDriver driver; 
	
	private HashMap<String, String> expectedTitles = new HashMap<String, String>();

	public Facilities_for_revolutionaries(WebDriver driver) {
		this.driver = driver; 
		
		expectedTitles.put("RO","Facilități pentru revoluționari - CFR Calatori");
		expectedTitles.put("EN","Facilities for revolutionaries - CFR Calatori");
	}
	
	public String getExpectedTitle(String lang) {
		return expectedTitles.get(lang); 
	}

}
