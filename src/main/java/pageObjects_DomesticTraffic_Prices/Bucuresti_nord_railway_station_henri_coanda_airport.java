package pageObjects_DomesticTraffic_Prices;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;

public class Bucuresti_nord_railway_station_henri_coanda_airport {
	WebDriver driver; 
	
	private HashMap<String, String> expectedTitles = new HashMap<String, String>();

	public Bucuresti_nord_railway_station_henri_coanda_airport(WebDriver driver) {
		this.driver = driver; 
		
		expectedTitles.put("RO","Tarif unic pe ruta București Nord – Aeroportul Internațional Henri Coandă - CFR Calatori");
		expectedTitles.put("EN","Single tariff /rate travel on the route Oraviţa- Anina");
	}
	
	public String getExpectedTitle(String lang) {
		return expectedTitles.get(lang); 
	}

}
