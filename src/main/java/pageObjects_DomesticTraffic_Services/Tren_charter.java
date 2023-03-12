package pageObjects_DomesticTraffic_Services;

import org.openqa.selenium.WebDriver;
import java.util.HashMap;
public class Tren_charter {
	WebDriver driver; 
	private HashMap<String, String> expectedTitles = new HashMap<String, String>();
	
	public Tren_charter(WebDriver driver) {
		this.driver = driver; 
		
		expectedTitles.put("RO","Tren Charter");
		expectedTitles.put("EN","Train Charter");
	}
	
	public String getExpectedTitle(String lang) {
		return expectedTitles.get(lang); 
	}
}
