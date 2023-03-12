package pageObjects_DomesticTraffic_Facilities;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;

public class Change_journey_dates {
	WebDriver driver; 
	
	private HashMap<String, String> expectedTitles = new HashMap<String, String>();
	
	public Change_journey_dates(WebDriver driver) {
		this.driver = driver; 
		
		expectedTitles.put("RO","Site oficial CFR Călători - Modificarea datelor de călătorie în trafic local. AMÂNAREA, ANTICIPAREA, ÎNTRERUPEREA CĂLĂTORIEI");
		expectedTitles.put("EN","CHANGE OF JOURNEY DATA IN DOMESTIC TRAFFIC");

	}
	
	public String getExpectedTitle(String lang) {
		return expectedTitles.get(lang); 
	}
}
