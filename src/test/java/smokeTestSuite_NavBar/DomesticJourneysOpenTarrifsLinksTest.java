package smokeTestSuite_NavBar;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BasePage;
import pageObjects.HomePage;
import pageObjects_DomesticTraffic_Prices.Bucuresti_nord_railway_station_henri_coanda_airport;
import pageObjects_DomesticTraffic_Prices.Full_price_of_the_ticket_travel_card;
import pageObjects_DomesticTraffic_Prices.Single_tariff_rate_section_route_oravita_anina;
import pageObjects_DomesticTraffic_Prices.Sntfc_cfr_calatori_companys_station_and_agencies_program;
import pageObjects_DomesticTraffic_Prices.Supplements_sleeping_car_berth_car;
import pageObjects_DomesticTraffic_Prices.Train_tickets;
import helperFunctions.TitlesMatch;

public class DomesticJourneysOpenTarrifsLinksTest extends BasePage {
	
	public DomesticJourneysOpenTarrifsLinksTest() throws IOException {
		super();
	}
	@BeforeClass
	public void setup() {
		getDriver();
		setHomePageUrl();
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@Test
	public void testDomesticJourneysOpenPriceLinks() {
		// Creating an instance of the HomePage 
		HomePage HomePage = new HomePage(driver);
		// Using the "goToLink" function responsible with navigating to each link opened from the dropdown list.
		// "goToLink" takes in the first arg (the dropdown list) and the second arg (the item to select from the list) 
		// The methods passed as the second arg of goToLink will take in the project language - The locating strategy used was 
		// by xpath. The second arg function will look for the link name according to project localization set from the config file.  
		HomePage.goToLink(HomePage.getDomesticTrafficLinkNav(), HomePage.getTariffsLinkFull_price_of_the_ticket_travel_card(getLang()));
		// Creating an instance of the page that the function above will redirect to
		Full_price_of_the_ticket_travel_card Full_price_of_the_ticket_travel_card = new Full_price_of_the_ticket_travel_card(driver);
		// Asserting that the title of the page the driver reached is the same with the expected title for the project's localization. 
		// Making use of the getTitlesmatch function which returns a boolean (true) if the page title matches the expected title of the 
		// reached page or false otherwise. The test will fail if, for example the project localization is set to RO but the reached page's 
		// title is of the EN version. 
		Assert.assertEquals(TitlesMatch.getTitlesMatch(driver.getTitle(), Full_price_of_the_ticket_travel_card.getExpectedTitle(getLang())), true);
		// Returning to the HomePage in order to perform the same test for all of the other links. 
		driver.navigate().back();
		
		HomePage.goToLink(HomePage.getDomesticTrafficLinkNav(), HomePage.getTariffsLinksupplements_sleeping_car_berth_car(getLang()));
		Supplements_sleeping_car_berth_car Supplements_sleeping_car_berth_car = new Supplements_sleeping_car_berth_car(driver);
		Assert.assertEquals(TitlesMatch.getTitlesMatch(driver.getTitle(), Supplements_sleeping_car_berth_car.getExpectedTitle(getLang())), true);
		driver.navigate().back();
		
		HomePage.goToLink(HomePage.getDomesticTrafficLinkNav(), HomePage.getTariffsLinkTrain_tickets(getLang()));
		Train_tickets Train_tickets = new Train_tickets(driver);
		Assert.assertEquals(TitlesMatch.getTitlesMatch(driver.getTitle(), Train_tickets.getExpectedTitle(getLang())), true);
		driver.navigate().back();
		
		HomePage.goToLink(HomePage.getDomesticTrafficLinkNav(), HomePage.getTariffsLinkBucuresti_nord_railway_station_henri_coanda_airport(getLang()));
		Bucuresti_nord_railway_station_henri_coanda_airport Bucuresti_nord_railway_station_henri_coanda_airport = new Bucuresti_nord_railway_station_henri_coanda_airport(driver);
		Assert.assertEquals(TitlesMatch.getTitlesMatch(driver.getTitle(), Bucuresti_nord_railway_station_henri_coanda_airport.getExpectedTitle(getLang())), true);
		driver.navigate().back();
		
		HomePage.goToLink(HomePage.getDomesticTrafficLinkNav(), HomePage.getTariffsLinkSingle_tariff_rate_section_route_oravita_anina(getLang()));
		Single_tariff_rate_section_route_oravita_anina Single_tariff_rate_section_route_oravita_anina = new Single_tariff_rate_section_route_oravita_anina(driver);
		Assert.assertEquals(TitlesMatch.getTitlesMatch(driver.getTitle(), Single_tariff_rate_section_route_oravita_anina.getExpectedTitle(getLang())), true);
		driver.navigate().back();
		
		HomePage.goToLink(HomePage.getDomesticTrafficLinkNav(), HomePage.getTariffsLinkSntfc_cfr_calatori_companys_station_and_agencies_program(getLang()));
		Sntfc_cfr_calatori_companys_station_and_agencies_program Sntfc_cfr_calatori_companys_station_and_agencies_program = new Sntfc_cfr_calatori_companys_station_and_agencies_program(driver);
		Assert.assertEquals(TitlesMatch.getTitlesMatch(driver.getTitle(), Sntfc_cfr_calatori_companys_station_and_agencies_program.getExpectedTitle(getLang())), true);
		driver.navigate().back();
			
	}
	@AfterClass
	public void tearDown() {
		driver.quit();
		driver = null; 
	}
}
