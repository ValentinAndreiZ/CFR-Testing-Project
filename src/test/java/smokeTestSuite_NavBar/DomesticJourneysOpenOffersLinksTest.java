package smokeTestSuite_NavBar;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BasePage;
import pageObjects.HomePage;
import pageObjects_DomesticTraffic_Offers.Discounts_for_groups;
import pageObjects_DomesticTraffic_Offers.Discounts_when_buying_in_advance;
import pageObjects_DomesticTraffic_Offers.Five_discount_at_the_automatic_ticket_vending_machines_online;
import pageObjects_DomesticTraffic_Offers.How_to_buy_a_ticket;
import pageObjects_DomesticTraffic_Offers.Journey_facilities_children;
import pageObjects_DomesticTraffic_Offers.Round_trip_ticket;
import pageObjects_DomesticTraffic_Offers.Subscriptions_for_trips;
import pageObjects_DomesticTraffic_Offers.Travel_card;
import pageObjects_DomesticTraffic_Offers.Trenplus_card;
import helperFunctions.TitlesMatch;

public class DomesticJourneysOpenOffersLinksTest extends BasePage {
	
	public DomesticJourneysOpenOffersLinksTest() throws IOException {
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
	public void testDomesticJourneysOpenOfferLinks() throws InterruptedException {
		
		HomePage HomePage = new HomePage(driver);
		
		HomePage.goToLink(HomePage.getDomesticTrafficLinkNav(), HomePage.getOffersLinkTrenplus_card(getLang()));
		Trenplus_card Trenplus_card = new Trenplus_card(driver);
		Assert.assertEquals(TitlesMatch.getTitlesMatch(driver.getTitle(), Trenplus_card.getExpectedTitle(getLang())), true);
		driver.navigate().back();
		
		HomePage.goToLink(HomePage.getDomesticTrafficLinkNav(), HomePage.getOffersLinkRound_trip_ticket(getLang()));
		Round_trip_ticket Round_trip_ticket = new Round_trip_ticket(driver);
		Assert.assertEquals(TitlesMatch.getTitlesMatch(driver.getTitle(), Round_trip_ticket.getExpectedTitle(getLang())), true);
		driver.navigate().back();
		
		HomePage.goToLink(HomePage.getDomesticTrafficLinkNav(), HomePage.getOffersLinkSubscriptions_for_trips(getLang()));
		Subscriptions_for_trips Subscriptions_for_trips = new Subscriptions_for_trips(driver);
		Assert.assertEquals(TitlesMatch.getTitlesMatch(driver.getTitle(), Subscriptions_for_trips.getExpectedTitle(getLang())), true);
		driver.navigate().back();
		
		HomePage.goToLink(HomePage.getDomesticTrafficLinkNav(), HomePage.getOffersLinkDiscounts_when_buying_in_advance(getLang()));
		Discounts_when_buying_in_advance Discounts_when_buying_in_advance = new Discounts_when_buying_in_advance(driver);
		Assert.assertEquals(TitlesMatch.getTitlesMatch(driver.getTitle(), Discounts_when_buying_in_advance.getExpectedTitle(getLang())), true);
		driver.navigate().back();
		
		HomePage.goToLink(HomePage.getDomesticTrafficLinkNav(), HomePage.getOffersLinkJourney_facilities_children(getLang()));
		Journey_facilities_children Journey_facilities_children = new Journey_facilities_children(driver);
		Assert.assertEquals(TitlesMatch.getTitlesMatch(driver.getTitle(), Journey_facilities_children.getExpectedTitle(getLang())), true);
		driver.navigate().back();
		
		HomePage.goToLink(HomePage.getDomesticTrafficLinkNav(), HomePage.getOffersLinkFive_discount_at_the_automatic_ticket_vending_machines_online(getLang()));
		Five_discount_at_the_automatic_ticket_vending_machines_online Five_discount_at_the_automatic_ticket_vending_machines_online = new Five_discount_at_the_automatic_ticket_vending_machines_online(driver);
		Assert.assertEquals(TitlesMatch.getTitlesMatch(driver.getTitle(), Five_discount_at_the_automatic_ticket_vending_machines_online.getExpectedTitle(getLang())), true);
		driver.navigate().back();
		
		HomePage.goToLink(HomePage.getDomesticTrafficLinkNav(), HomePage.getOffersLinkDiscounts_for_groups(getLang()));
		Discounts_for_groups Discounts_for_groups = new Discounts_for_groups(driver);
		Assert.assertEquals(TitlesMatch.getTitlesMatch(driver.getTitle(), Discounts_for_groups.getExpectedTitle(getLang())), true);
		driver.navigate().back();
		
		HomePage.goToLink(HomePage.getDomesticTrafficLinkNav(), HomePage.getOffersLinkTravel_card(getLang()));
		Travel_card Travel_card = new Travel_card(driver);
		Assert.assertEquals(TitlesMatch.getTitlesMatch(driver.getTitle(), Travel_card.getExpectedTitle(getLang())), true);
		driver.navigate().back();
		
		HomePage.goToLink(HomePage.getDomesticTrafficLinkNav(), HomePage.getOffersLinkHow_to_buy_a_ticket(getLang()));
		How_to_buy_a_ticket How_to_buy_a_ticket = new How_to_buy_a_ticket(driver);
		Assert.assertEquals(TitlesMatch.getTitlesMatch(driver.getTitle(), How_to_buy_a_ticket.getExpectedTitle(getLang())), true);
		driver.navigate().back();
	}
	@AfterClass
	public void tearDown() {
		driver.quit();
		driver = null; 
	}
}
