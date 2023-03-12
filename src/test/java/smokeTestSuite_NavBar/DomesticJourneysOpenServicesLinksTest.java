package smokeTestSuite_NavBar;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BasePage;
import pageObjects.HomePage;
import pageObjects_DomesticTraffic_Services.Animal_transport_services;
import pageObjects_DomesticTraffic_Services.Discount_purchase_train_tickets_line;
import pageObjects_DomesticTraffic_Services.Renounce_to_travel;
import pageObjects_DomesticTraffic_Services.Services_major_railstations;
import pageObjects_DomesticTraffic_Services.Single_tariff_rate_section_route_oravita_anina;
import pageObjects_DomesticTraffic_Services.Transport_services_bicycles_skis;
import pageObjects_DomesticTraffic_Services.Travelling_sleeping_berth_car;
import pageObjects_DomesticTraffic_Services.Tren_charter;
import helperFunctions.TitlesMatch;

public class DomesticJourneysOpenServicesLinksTest extends BasePage {
	
	public DomesticJourneysOpenServicesLinksTest() throws IOException {
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
		
		HomePage HomePage = new HomePage(driver);
		
		HomePage.goToLink(HomePage.getDomesticTrafficLinkNav(), HomePage.getServicesLinkDiscount_purchase_train_tickets_line(getLang()));
		Discount_purchase_train_tickets_line Discount_purchase_train_tickets_line = new Discount_purchase_train_tickets_line(driver);
		Assert.assertEquals(TitlesMatch.getTitlesMatch(driver.getTitle(), Discount_purchase_train_tickets_line.getExpectedTitle(getLang())), true);
		driver.navigate().back();
		
		HomePage.goToLink(HomePage.getDomesticTrafficLinkNav(), HomePage.getServicesLinkTren_charter(getLang()));
		Tren_charter Tren_charter = new Tren_charter(driver);
		Assert.assertEquals(TitlesMatch.getTitlesMatch(driver.getTitle(), Tren_charter.getExpectedTitle(getLang())), true);
		driver.navigate().back();
		
		HomePage.goToLink(HomePage.getDomesticTrafficLinkNav(), HomePage.getServicesLinkServices_major_railstations(getLang()));
		Services_major_railstations Services_major_railstations = new Services_major_railstations(driver);
		Assert.assertEquals(TitlesMatch.getTitlesMatch(driver.getTitle(), Services_major_railstations.getExpectedTitle(getLang())), true);
		driver.navigate().back();
		
		HomePage.goToLink(HomePage.getDomesticTrafficLinkNav(), HomePage.getServicesLinkTransport_services_bicycles_skis(getLang()));
		Transport_services_bicycles_skis Transport_services_bicycles_skis = new Transport_services_bicycles_skis(driver);
		Assert.assertEquals(TitlesMatch.getTitlesMatch(driver.getTitle(), Transport_services_bicycles_skis.getExpectedTitle(getLang())), true);
		driver.navigate().back();
		
		HomePage.goToLink(HomePage.getDomesticTrafficLinkNav(), HomePage.getServicesLinkAnimal_transport_services(getLang()));
		Animal_transport_services Animal_transport_services = new Animal_transport_services(driver);
		Assert.assertEquals(TitlesMatch.getTitlesMatch(driver.getTitle(), Animal_transport_services.getExpectedTitle(getLang())), true);
		driver.navigate().back();
		
		HomePage.goToLink(HomePage.getDomesticTrafficLinkNav(), HomePage.getServicesLinkSingle_tariff_rate_section_route_oravita_anina(getLang()));
		Single_tariff_rate_section_route_oravita_anina Single_tariff_rate_section_route_oravita_anina = new Single_tariff_rate_section_route_oravita_anina(driver);
		Assert.assertEquals(TitlesMatch.getTitlesMatch(driver.getTitle(), Single_tariff_rate_section_route_oravita_anina.getExpectedTitle(getLang())), true);
		driver.navigate().back();
		
		HomePage.goToLink(HomePage.getDomesticTrafficLinkNav(), HomePage.getServicesLinkTravelling_sleeping_berth_car(getLang()));
		Travelling_sleeping_berth_car Travelling_sleeping_berth_car = new Travelling_sleeping_berth_car(driver);
		Assert.assertEquals(TitlesMatch.getTitlesMatch(driver.getTitle(), Travelling_sleeping_berth_car.getExpectedTitle(getLang())), true);
		driver.navigate().back();
		
		HomePage.goToLink(HomePage.getDomesticTrafficLinkNav(), HomePage.getServicesLinkRenounce_to_travel(getLang()));
		Renounce_to_travel Renounce_to_travel = new Renounce_to_travel(driver);
		Assert.assertEquals(TitlesMatch.getTitlesMatch(driver.getTitle(), Renounce_to_travel.getExpectedTitle(getLang())), true);
		driver.navigate().back();
	}
	@AfterClass
	public void tearDown() {
		driver.quit();
		driver = null; 
	}
}
