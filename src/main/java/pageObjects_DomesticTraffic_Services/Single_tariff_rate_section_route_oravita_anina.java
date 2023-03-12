package pageObjects_DomesticTraffic_Services;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;

public class Single_tariff_rate_section_route_oravita_anina {
	WebDriver driver; 
	
	private HashMap<String, String> expectedTitles = new HashMap<String, String>();

	public Single_tariff_rate_section_route_oravita_anina(WebDriver driver) {
		this.driver = driver; 
		
		expectedTitles.put("RO","Tarif unic de călătorie pe secția Oravița – Anina și retur");
		expectedTitles.put("EN","CFR Călători official site - Single tariff /rate travel on the route Oraviţa- Anina and return");
	}
	
	public String getExpectedTitle(String lang) {
		return expectedTitles.get(lang); 
	}
}
