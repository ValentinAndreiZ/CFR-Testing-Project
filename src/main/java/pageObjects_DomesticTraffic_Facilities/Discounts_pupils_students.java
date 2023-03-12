package pageObjects_DomesticTraffic_Facilities;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;

public class Discounts_pupils_students {
	WebDriver driver; 
	
	private HashMap<String, String> expectedTitles = new HashMap<String, String>();
	
	public Discounts_pupils_students(WebDriver driver) {
		this.driver = driver; 
		
		expectedTitles.put("RO","Reduceri pentru elevi și studenți - CFR Calatori");
		expectedTitles.put("EN","Discounts for pupils and students - CFR Calatori");
	}

		public String getExpectedTitle(String lang) {
			return expectedTitles.get(lang); 
		}
}
