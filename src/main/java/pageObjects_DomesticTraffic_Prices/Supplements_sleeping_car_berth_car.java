package pageObjects_DomesticTraffic_Prices;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;

public class Supplements_sleeping_car_berth_car {
	WebDriver driver; 
	
	private HashMap<String, String> expectedTitles = new HashMap<String, String>();

	public Supplements_sleeping_car_berth_car(WebDriver driver) {
		this.driver = driver; 
		
		expectedTitles.put("RO","Site oficial CFR Călători - Tarifele suplimentelor la vagon de dormit şi cuşetă");
		expectedTitles.put("EN","CFR Călători official site -The supplement prices for the sleeping car and berth car");
	}
	
	public String getExpectedTitle(String lang) {
		return expectedTitles.get(lang); 
	}
}
