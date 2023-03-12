package pageObjects_DomesticTraffic_Services;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;

public class Travelling_sleeping_berth_car {
	WebDriver driver; 
	
	private HashMap<String, String> expectedTitles = new HashMap<String, String>();
	
	public Travelling_sleeping_berth_car(WebDriver driver) {
		this.driver = driver; 
		
		expectedTitles.put("RO","Servicii la bordul trenului - CFR Calatori");
		expectedTitles.put("EN","Services on board the train - CFR Calatori");
	}
	
	public String getExpectedTitle(String lang) {
		return expectedTitles.get(lang); 
	}	
}
