package pageObjects_DomesticTraffic_Facilities;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;

public class Discounts_apuseni_mountains_residents {
	WebDriver driver; 
	
	private HashMap<String, String> expectedTitles = new HashMap<String, String>();

	public Discounts_apuseni_mountains_residents(WebDriver driver) {
		this.driver = driver; 
		
		expectedTitles.put("RO","Reduceri pentru locuitorii Munţilor Apuseni - CFR Calatori");
		expectedTitles.put("EN","Discounts for Apuseni Mountains residents - CFR Calatori");
	}
	
	public String getExpectedTitle(String lang) {
		return expectedTitles.get(lang); 
	}

}
