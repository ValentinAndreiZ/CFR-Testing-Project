package pageObjects_DomesticTraffic_Services;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;

public class Transport_services_bicycles_skis {
	WebDriver driver; 
		
	private HashMap<String, String> expectedTitles = new HashMap<String, String>();

	public Transport_services_bicycles_skis(WebDriver driver) {
		this.driver = driver; 
		
		expectedTitles.put("RO","Transportul bicicletelor si schiurilor");
		expectedTitles.put("EN","Transport services of bicycles and skis - CFR Calatori");
	}
	
	public String getExpectedTitle(String lang) {
		return expectedTitles.get(lang); 
	}
}
