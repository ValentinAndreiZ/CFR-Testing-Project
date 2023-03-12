package pageObjects_DomesticTraffic_Offers;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;

public class Five_discount_at_the_automatic_ticket_vending_machines_online {
	WebDriver driver; 
	
	private HashMap<String, String> expectedTitles = new HashMap<String, String>();

	public Five_discount_at_the_automatic_ticket_vending_machines_online(WebDriver driver) {
		this.driver = driver; 
		
		expectedTitles.put("RO","Reducere 5% la automatele de bilete & online - CFR Calatori");
		expectedTitles.put("EN","5% Discount at the Automatic Ticket Vending Machines & Online - CFR Calatori");
	}
	
	public String getExpectedTitle(String lang) {
		return expectedTitles.get(lang); 
	}
}
