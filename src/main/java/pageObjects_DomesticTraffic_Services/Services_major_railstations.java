package pageObjects_DomesticTraffic_Services;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;

public class Services_major_railstations {
	WebDriver driver; 
	
	private HashMap<String, String> expectedTitles = new HashMap<String, String>();

	public Services_major_railstations(WebDriver driver) {
		this.driver = driver; 
		
		expectedTitles.put("RO","Servicii în stațiile mari - CFR Calatori");
		expectedTitles.put("EN","Services in major railstations - CFR Calatori");

	}
	
	public String getExpectedTitle(String lang) {
		return expectedTitles.get(lang); 
	}
}
