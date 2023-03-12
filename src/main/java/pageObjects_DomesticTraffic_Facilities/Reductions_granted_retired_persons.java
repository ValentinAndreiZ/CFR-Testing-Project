package pageObjects_DomesticTraffic_Facilities;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;

public class Reductions_granted_retired_persons {
	WebDriver driver; 
	
	private HashMap<String, String> expectedTitles = new HashMap<String, String>();

	public Reductions_granted_retired_persons(WebDriver driver) {
		this.driver = driver; 
		
		expectedTitles.put("RO","Reduceri pentru pensionari - CFR Calatori");
		expectedTitles.put("EN","Reductions granted by the retired persons - CFR Calatori");
	}
	
		public String getExpectedTitle(String lang) {
			return expectedTitles.get(lang); 
		}
	
}
