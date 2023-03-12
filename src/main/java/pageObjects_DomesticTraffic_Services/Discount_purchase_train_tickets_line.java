package pageObjects_DomesticTraffic_Services;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;

public class Discount_purchase_train_tickets_line {
	WebDriver driver; 
	
	private HashMap<String, String> expectedTitles = new HashMap<String, String>();

	public Discount_purchase_train_tickets_line(WebDriver driver) {
		this.driver = driver; 
		
		expectedTitles.put("RO","Bilete online în trafic intern - CFR Calatori");
		expectedTitles.put("EN","Buy online train tickets in local traffic - CFR Calatori");
	}
	
	public String getExpectedTitle(String lang) {
		return expectedTitles.get(lang); 
	}

}
