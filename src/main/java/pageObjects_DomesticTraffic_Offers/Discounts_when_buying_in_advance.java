package pageObjects_DomesticTraffic_Offers;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;

public class Discounts_when_buying_in_advance {
	WebDriver driver; 
	
	private HashMap<String, String> expectedTitles = new HashMap<String, String>();

	public Discounts_when_buying_in_advance(WebDriver driver) {
		this.driver = driver; 
		
		expectedTitles.put("RO","Reduceri la cumpărarea cu anticipatie a biletelor de tren in trafic intern!");
		expectedTitles.put("EN","Discounts when buying in advance - CFR Calatori");
	}
	public String getExpectedTitle(String lang) {
		return expectedTitles.get(lang); 
	}
	
}
