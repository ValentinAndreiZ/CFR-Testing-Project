package smokeTestSuite_NavBar;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BasePage;
import pageObjects.HomePage;
import pageObjects_DomesticTraffic_Facilities.Change_journey_dates;
import pageObjects_DomesticTraffic_Facilities.Discounts_apuseni_mountains_residents;
import pageObjects_DomesticTraffic_Facilities.Discounts_pupils_students;
import pageObjects_DomesticTraffic_Facilities.Facilities_beneficiaries_law_no_118_1990;
import pageObjects_DomesticTraffic_Facilities.Facilities_beneficiaries_law_no_189_2000;
import pageObjects_DomesticTraffic_Facilities.Facilities_disabled_persons;
import pageObjects_DomesticTraffic_Facilities.Facilities_for_revolutionaries;
import pageObjects_DomesticTraffic_Facilities.Facilities_war_veterans;
import pageObjects_DomesticTraffic_Facilities.Reductions_granted_retired_persons;
import helperFunctions.TitlesMatch;

public class DomesticJourneysOpenFacilitiesLinksTest extends BasePage {
	
	public DomesticJourneysOpenFacilitiesLinksTest() throws IOException {
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
	public void testDomesticJourneysOpenPriceLinks(){
		
		HomePage HomePage = new HomePage(driver);
		
		HomePage.goToLink(HomePage.getDomesticTrafficLinkNav(), HomePage.getFacilitiesLinkDiscounts_pupils_students(getLang()));
		Discounts_pupils_students Discounts_pupils_students = new Discounts_pupils_students(driver);
		Assert.assertEquals(TitlesMatch.getTitlesMatch(driver.getTitle(), Discounts_pupils_students.getExpectedTitle(getLang())), true);
		
		HomePage.goToLink(HomePage.getDomesticTrafficLinkNav(), HomePage.getFacilitiesLinkReductions_granted_retired_persons(getLang()));
		Reductions_granted_retired_persons Reductions_granted_retired_persons = new Reductions_granted_retired_persons(driver);
		Assert.assertEquals(TitlesMatch.getTitlesMatch(driver.getTitle(), Reductions_granted_retired_persons.getExpectedTitle(getLang())), true);
		driver.navigate().back();
		
		HomePage.goToLink(HomePage.getDomesticTrafficLinkNav(), HomePage.getFacilitiesLinkFacilities_for_revolutionaries(getLang()));
		Facilities_for_revolutionaries Facilities_for_revolutionaries = new Facilities_for_revolutionaries(driver);
		Assert.assertEquals(TitlesMatch.getTitlesMatch(driver.getTitle(), Facilities_for_revolutionaries.getExpectedTitle(getLang())), true);
		driver.navigate().back();
		
		HomePage.goToLink(HomePage.getDomesticTrafficLinkNav(), HomePage.getFacilitiesLinkFacilities_war_veterans(getLang()));
		Facilities_war_veterans Facilities_war_veterans = new Facilities_war_veterans(driver);
		Assert.assertEquals(TitlesMatch.getTitlesMatch(driver.getTitle(), Facilities_war_veterans.getExpectedTitle(getLang())), true);
		driver.navigate().back();
		
		HomePage.goToLink(HomePage.getDomesticTrafficLinkNav(), HomePage.getFacilitiesLinkFacilities_beneficiaries_law_no_189_2000(getLang()));
		Facilities_beneficiaries_law_no_189_2000 Facilities_beneficiaries_law_no_189_2000 = new Facilities_beneficiaries_law_no_189_2000(driver);
		Assert.assertEquals(TitlesMatch.getTitlesMatch(driver.getTitle(), Facilities_beneficiaries_law_no_189_2000.getExpectedTitle(getLang())), true);
		driver.navigate().back();
		
		HomePage.goToLink(HomePage.getDomesticTrafficLinkNav(), HomePage.getFacilitiesLinkFacilities_beneficiaries_law_no_118_1990(getLang()));
		Facilities_beneficiaries_law_no_118_1990 Facilities_beneficiaries_law_no_189_2000_2 = new Facilities_beneficiaries_law_no_118_1990(driver);
		Assert.assertEquals(TitlesMatch.getTitlesMatch(driver.getTitle(), Facilities_beneficiaries_law_no_189_2000_2.getExpectedTitle(getLang())), true);
		driver.navigate().back();
		
		HomePage.goToLink(HomePage.getDomesticTrafficLinkNav(), HomePage.getFacilitiesLinkFacilities_disabled_persons(getLang()));
		Facilities_disabled_persons Facilities_disabled_persons = new Facilities_disabled_persons(driver);
		Assert.assertEquals(TitlesMatch.getTitlesMatch(driver.getTitle(), Facilities_disabled_persons.getExpectedTitle(getLang())), true);
		driver.navigate().back();
		
		HomePage.goToLink(HomePage.getDomesticTrafficLinkNav(), HomePage.getFacilitiesLinkDiscounts_apuseni_mountains_residents(getLang()));
		Discounts_apuseni_mountains_residents Discounts_apuseni_mountains_residents = new Discounts_apuseni_mountains_residents(driver);
		Assert.assertEquals(TitlesMatch.getTitlesMatch(driver.getTitle(), Discounts_apuseni_mountains_residents.getExpectedTitle(getLang())), true);
		driver.navigate().back();
		
		HomePage.goToLink(HomePage.getDomesticTrafficLinkNav(), HomePage.getFacilitiesLinkChange_journey_date(getLang()));
		Change_journey_dates Change_journey_dates = new Change_journey_dates(driver);
		Assert.assertEquals(TitlesMatch.getTitlesMatch(driver.getTitle(), Change_journey_dates.getExpectedTitle(getLang())), true);
		driver.navigate().back();
			
	}
	@AfterClass
	public void tearDown() {
		driver.quit();
		driver = null; 
	}
}
