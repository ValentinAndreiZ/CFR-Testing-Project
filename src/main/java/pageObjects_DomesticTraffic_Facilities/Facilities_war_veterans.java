package pageObjects_DomesticTraffic_Facilities;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;

public class Facilities_war_veterans {
	WebDriver driver; 
	
	private HashMap<String, String> expectedTitles = new HashMap<String, String>();

	public Facilities_war_veterans(WebDriver driver) {
		this.driver = driver; 
		
		expectedTitles.put("RO","Facilități pentru veteranii de război - CFR Calatori");
		expectedTitles.put("EN","Facilities for war veterans - CFR Calatori");
	}
	
	public String getExpectedTitle(String lang) {
		return expectedTitles.get(lang); 
	}

}
