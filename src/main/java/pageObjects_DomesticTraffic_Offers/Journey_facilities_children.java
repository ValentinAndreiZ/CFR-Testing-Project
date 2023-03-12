package pageObjects_DomesticTraffic_Offers;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;

public class Journey_facilities_children {
	WebDriver driver; 
	
	private HashMap<String, String> expectedTitles = new HashMap<String, String>();
	
	public Journey_facilities_children(WebDriver driver) {
		this.driver = driver; 		

		expectedTitles.put("RO","Reduceri pentru copii - CFR Calatori");
		expectedTitles.put("EN","Journey facilities for children - CFR Calatori");
	}
	
	public String getExpectedTitle(String lang) {
		return expectedTitles.get(lang); 
	}
	
}
