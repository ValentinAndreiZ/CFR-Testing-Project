package pageObjects_DomesticTraffic_Offers;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;

public class Discounts_for_groups {
	WebDriver driver; 
	
	private HashMap<String, String> expectedTitles = new HashMap<String, String>();

	
	public Discounts_for_groups(WebDriver driver) {
		this.driver = driver; 
		
		expectedTitles.put("RO","Reduceri pentru grupuri! Alege \"Oferta Grup\" și ai până la 35% Reducere!");
		expectedTitles.put("EN","Reservations for Groups - CFR Calatori");
	}
	
		public String getExpectedTitle(String lang) {
			return expectedTitles.get(lang); 
		}
	
}
