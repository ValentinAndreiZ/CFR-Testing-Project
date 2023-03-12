package pageObjects_DomesticTraffic_Facilities;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;

public class Facilities_beneficiaries_law_no_118_1990 {
	WebDriver driver; 
	
	private HashMap<String, String> expectedTitles = new HashMap<String, String>();

	public Facilities_beneficiaries_law_no_118_1990(WebDriver driver) {
		this.driver = driver; 
		
		expectedTitles.put("RO","Facilităţi pentru beneficiarii Decretului-lege nr. 118/1990 - CFR Calatori");
		expectedTitles.put("EN","Facilities for the beneficiaries of Law no. 118/1990 - CFR Calatori");
	}
	
	public String getExpectedTitle(String lang) {
		return expectedTitles.get(lang); 
	}
}
