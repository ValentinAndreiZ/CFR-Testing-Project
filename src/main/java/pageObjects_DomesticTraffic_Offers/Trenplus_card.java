package pageObjects_DomesticTraffic_Offers;

import org.openqa.selenium.WebDriver;
import java.util.HashMap;


public class Trenplus_card {
	WebDriver driver; 
	
//	private String[] expectedTitles = {"Cardul TrenPlus! Cumperi bilete de tren cu 25% Reducere! CFR Calatori", "TrenPlus Card - CFR Calatori"};
	
	private HashMap<String, String> expectedTitles = new HashMap<String, String>();
	
	public Trenplus_card(WebDriver driver) {
		this.driver = driver; 
		
		expectedTitles.put("RO","Cardul TrenPlus! Cumperi bilete de tren cu 25% Reducere! CFR Calatori");
		expectedTitles.put("EN","TrenPlus Card - CFR Calatori");
	}
	
	public String getExpectedTitle(String lang) {
		return expectedTitles.get(lang); 
	}
	
}
