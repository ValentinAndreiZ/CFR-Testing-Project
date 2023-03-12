package pageObjects_DomesticTraffic_Offers;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;

public class How_to_buy_a_ticket {
	WebDriver driver; 
	
	private HashMap<String, String> expectedTitles = new HashMap<String, String>();
	
	public How_to_buy_a_ticket(WebDriver driver) {
		this.driver = driver; 
		
		expectedTitles.put("RO","Cum să cumperi bilet, case de bilete, online, personalul de tren, însoţitor de vagon");
		expectedTitles.put("EN","CFR Călători offcial website - How to buy a ticket");
	}
	
		public String getExpectedTitle(String lang) {
			return expectedTitles.get(lang); 
		}
	
}
