package pageObjects_DomesticTraffic_Prices;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;

public class Sntfc_cfr_calatori_companys_station_and_agencies_program {
	WebDriver driver; 
	
	private HashMap<String, String> expectedTitles = new HashMap<String, String>();

	public Sntfc_cfr_calatori_companys_station_and_agencies_program(WebDriver driver) {
		this.driver = driver; 
		
		expectedTitles.put("RO","Programul staţiilor şi agenţiilor de voiaj CFR Călători %");
		expectedTitles.put("EN","SNTFC „CFR Călători” Company`s station and agencies program");
	}
	
	public String getExpectedTitle(String lang) {
		return expectedTitles.get(lang); 
	}
}
