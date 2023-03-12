package pageObjects;

import java.util.HashMap;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomePage {

	public WebDriver driver; 
	
	private HashMap<String, String> expectedTitles = new HashMap<String, String>();
	
	public HomePage(WebDriver driver) {
		this.driver = driver; 
		
		expectedTitles.put("RO","CFR Călători pagina oficială. Mersul trenurilor. Bilete online. Oferte. Servicii");
		expectedTitles.put("EN","Buy online train tickets in local traffic - CFR Calatori");
	}
	
	public String getExpectedTitle(String lang) {
		return expectedTitles.get(lang); 
	}

	// NAVBAR ELEMENTS
	
	public WebElement getHomePageLink() {
		WebElement HomePageLink = driver.findElement(By.cssSelector("a[role='link'] > img[alt='CFR Calatori']"));
		return HomePageLink;
	}
	
	public WebElement getMyAccountLink() {
		WebElement MyAccountLink = driver.findElement(By.xpath("//ul[@id='menu-menu-1']/li[7]/a[@role='link']"));
		return MyAccountLink;
		
	}
	
	// Domestic traffic link displayed on hover on my account link 
	public WebElement getDomesticTrafficLink() {
		WebElement domesticTrafficLink = driver.findElement(By.xpath("//ul[@id='menu-menu-1']/li[7]/ul/li[1]/a[@role='link']"));
		return domesticTrafficLink; 
	}
	
	// Domestic traffic link displayed in the navigation bar 
	public WebElement getDomesticTrafficLinkNav() {
		WebElement domesticTrafficLink = driver.findElement(By.xpath("//ul[@id='menu-menu-1']/li[2]/a[@role='link']"));
		return domesticTrafficLink; 
	}
	
	//TARRIFS LINKS
	
	//Pretul integral al legitimatiilor de calatorie
	public WebElement getTariffsLinkFull_price_of_the_ticket_travel_card(String lang) {
		HashMap<String, String> linkTexts = new HashMap <String, String>();
		
		linkTexts.put("RO", "Preţul integral al legitimaţiilor de călătorie"); 
		linkTexts.put("EN", "Placeholder missing localization");
		
		WebElement link = driver.findElement(By.xpath("//a[text()='"+linkTexts.get(lang)+"']"));
		return link;
	}
	//Suplimente la vagon de dormit si cuseta 
	public WebElement getTariffsLinksupplements_sleeping_car_berth_car(String lang) {
		HashMap<String, String> linkTexts = new HashMap <String, String>();
		
		linkTexts.put("RO", "Suplimente la vagon de dormit şi cuşetă"); 
		linkTexts.put("EN", "Placeholder missing localization");
		
		WebElement link = driver.findElement(By.xpath("//a[text()='"+linkTexts.get(lang)+"']"));
		return link;
	}
	//Taxarea in tren 
	public WebElement getTariffsLinkTrain_tickets(String lang) {
		HashMap<String, String> linkTexts = new HashMap <String, String>();
		
		linkTexts.put("RO", "Taxarea în tren"); 
		linkTexts.put("EN", "Placeholder missing localization");
		
		WebElement link = driver.findElement(By.xpath("//a[text()='"+linkTexts.get(lang)+"']"));
		return link;
	}
	//Tarif unic pe ruta BucrestiNord-Aeroportul international Henri Coanda 
	public WebElement getTariffsLinkBucuresti_nord_railway_station_henri_coanda_airport(String lang) {
		HashMap<String, String> linkTexts = new HashMap <String, String>();
		
		linkTexts.put("RO", "Tarif unic pe ruta București Nord – Aeroportul Internațional Henri Coandă"); 
		linkTexts.put("EN", "Placeholder missing localization");
		
		WebElement link = driver.findElement(By.xpath("//a[text()='"+linkTexts.get(lang)+"']"));
		return link;
	
	}
	//Tarif unic pe sectia Oravita - Anina
	public WebElement getTariffsLinkSingle_tariff_rate_section_route_oravita_anina(String lang) {
		HashMap<String, String> linkTexts = new HashMap <String, String>();
		
		linkTexts.put("RO", "Tarif unic pe secția Oravita – Anina"); 
		linkTexts.put("EN", "Placeholder missing localization");
		
		WebElement link = driver.findElement(By.xpath("//a[text()='"+linkTexts.get(lang)+"']"));
		return link;
	}
	
	public WebElement getTariffsLinkSntfc_cfr_calatori_companys_station_and_agencies_program(String lang) {
		HashMap<String, String> linkTexts = new HashMap <String, String>();
		
		linkTexts.put("RO", "Puncte de vânzare"); 
		linkTexts.put("EN", "Placeholder missing localization");
		
		WebElement link = driver.findElement(By.xpath("//a[text()='"+linkTexts.get(lang)+"']"));
		return link;
		
	}
	
	//OFFERS LINKS
	
	public WebElement getOffersLinkTrenplus_card(String lang) {
		HashMap<String, String> linkTexts = new HashMap <String, String>();
		
		linkTexts.put("RO", "Cardul TrenPlus"); 
		linkTexts.put("EN", "Placeholder missing localization");
		
		WebElement link = driver.findElement(By.xpath("//a[text()='"+linkTexts.get(lang)+"']"));
		return link;
	}
	
	public WebElement getOffersLinkRound_trip_ticket(String lang) {
		HashMap<String, String> linkTexts = new HashMap <String, String>();
		
		linkTexts.put("RO", "Biletul dus – întors"); 
		linkTexts.put("EN", "Placeholder missing localization");
		
		WebElement link = driver.findElement(By.xpath("//a[text()='"+linkTexts.get(lang)+"']"));
		return link;
	}
	
	public WebElement getOffersLinkSubscriptions_for_trips(String lang) {
		HashMap<String, String> linkTexts = new HashMap <String, String>();
		
		linkTexts.put("RO", "Abonamente"); 
		linkTexts.put("EN", "Placeholder missing localization");
		
		WebElement link = driver.findElement(By.xpath("//a[text()='"+linkTexts.get(lang)+"']"));
		return link;
	}
	
	public WebElement getOffersLinkDiscounts_when_buying_in_advance(String lang) {
		HashMap<String, String> linkTexts = new HashMap <String, String>();
		
		linkTexts.put("RO", "Reduceri la cumpărarea cu anticipație"); 
		linkTexts.put("EN", "Placeholder missing localization");
		
		WebElement link = driver.findElement(By.xpath("//a[text()='"+linkTexts.get(lang)+"']"));
		return link;
	}
	
	public WebElement getOffersLinkJourney_facilities_children(String lang) {
		HashMap<String, String> linkTexts = new HashMap <String, String>();
		
		linkTexts.put("RO", "Reduceri pentru copii"); 
		linkTexts.put("EN", "Placeholder missing localization");
		
		WebElement link = driver.findElement(By.xpath("//a[text()='"+linkTexts.get(lang)+"']"));
		return link;
	}
	
	public WebElement getOffersLinkFive_discount_at_the_automatic_ticket_vending_machines_online(String lang) {
		HashMap<String, String> linkTexts = new HashMap <String, String>();
		
		linkTexts.put("RO", "Reducere 5% la automatele de bilete & online"); 
		linkTexts.put("EN", "Placeholder missing localization");
		
		WebElement link = driver.findElement(By.xpath("//a[text()='"+linkTexts.get(lang)+"']"));
		return link;
	}
	
	public WebElement getOffersLinkDiscounts_for_groups(String lang) {
		HashMap<String, String> linkTexts = new HashMap <String, String>();
		
		linkTexts.put("RO", "Rezervări pentru grupuri"); 
		linkTexts.put("EN", "Placeholder missing localization");
		
		WebElement link = driver.findElement(By.xpath("//a[text()='"+linkTexts.get(lang)+"']"));
		return link;
	}
	
	public WebElement getOffersLinkTravel_card(String lang) {
		HashMap<String, String> linkTexts = new HashMap <String, String>();
		
		linkTexts.put("RO", "Cartea de călătorie"); 
		linkTexts.put("EN", "Placeholder missing localization");
		
		WebElement link = driver.findElement(By.xpath("//a[text()='"+linkTexts.get(lang)+"']"));
		return link;
	}
	
	public WebElement getOffersLinkHow_to_buy_a_ticket(String lang) {
		HashMap<String, String> linkTexts = new HashMap <String, String>();
		
		linkTexts.put("RO", "Cum să cumperi bilet"); 
		linkTexts.put("EN", "Placeholder missing localization");
		
		WebElement link = driver.findElement(By.xpath("//a[text()='"+linkTexts.get(lang)+"']"));
		return link;
	}
	
	// FACILITIES LINKS 
	
	public WebElement getFacilitiesLinkDiscounts_pupils_students(String lang) {
		HashMap<String, String> linkTexts = new HashMap <String, String>();
		
		linkTexts.put("RO", "Reduceri pentru elevi și studenți"); 
		linkTexts.put("EN", "Placeholder missing localization");
		
		WebElement link = driver.findElement(By.xpath("//a[text()='"+linkTexts.get(lang)+"']"));
		return link;
	}
	
	public WebElement getFacilitiesLinkReductions_granted_retired_persons(String lang) {
		HashMap<String, String> linkTexts = new HashMap <String, String>();
		
		linkTexts.put("RO", "Reduceri pentru pensionari"); 
		linkTexts.put("EN", "Placeholder missing localization");
		
		WebElement link = driver.findElement(By.xpath("//a[text()='"+linkTexts.get(lang)+"']"));
		return link;
	}
	
	public WebElement getFacilitiesLinkFacilities_for_revolutionaries(String lang) {
		HashMap<String, String> linkTexts = new HashMap <String, String>();
		
		linkTexts.put("RO", "Facilități pentru revoluționari"); 
		linkTexts.put("EN", "Placeholder missing localization");
		
		WebElement link = driver.findElement(By.xpath("//a[text()='"+linkTexts.get(lang)+"']"));
		return link;
	}
	
	public WebElement getFacilitiesLinkFacilities_war_veterans(String lang) {
		HashMap<String, String> linkTexts = new HashMap <String, String>();
		
		linkTexts.put("RO", "Facilități pentru veteranii de război"); 
		linkTexts.put("EN", "Placeholder missing localization");
		
		WebElement link = driver.findElement(By.xpath("//a[text()='"+linkTexts.get(lang)+"']"));
		return link;
	}
	
	public WebElement getFacilitiesLinkFacilities_beneficiaries_law_no_189_2000(String lang) {
		HashMap<String, String> linkTexts = new HashMap <String, String>();
		
		linkTexts.put("RO", "Facilităţi pentru beneficiarii Legii nr. 189/2000"); 
		linkTexts.put("EN", "Placeholder missing localization");
		
		WebElement link = driver.findElement(By.xpath("//a[text()='"+linkTexts.get(lang)+"']"));
		return link;
	}
	
	public WebElement getFacilitiesLinkFacilities_beneficiaries_law_no_118_1990(String lang) {
		HashMap<String, String> linkTexts = new HashMap <String, String>();
		
		linkTexts.put("RO", "Facilităţi pentru beneficiarii Decretului-lege nr. 118/1990"); 
		linkTexts.put("EN", "Placeholder missing localization");
		
		WebElement link = driver.findElement(By.xpath("//a[text()='"+linkTexts.get(lang)+"']"));
		return link;
	}
	public WebElement getFacilitiesLinkFacilities_disabled_persons(String lang) {
		HashMap<String, String> linkTexts = new HashMap <String, String>();
		
		linkTexts.put("RO", "Facilități pentru persoanele cu handicap"); 
		linkTexts.put("EN", "Placeholder missing localization");
		
		WebElement link = driver.findElement(By.xpath("//a[text()='"+linkTexts.get(lang)+"']"));
		return link;
	}
	public WebElement getFacilitiesLinkDiscounts_apuseni_mountains_residents(String lang) {
		HashMap<String, String> linkTexts = new HashMap <String, String>();
		
		linkTexts.put("RO", "Reduceri pentru locuitorii Munţilor Apuseni"); 
		linkTexts.put("EN", "Placeholder missing localization");
		
		WebElement link = driver.findElement(By.xpath("//a[text()='"+linkTexts.get(lang)+"']"));
		return link;
	}
	
	public WebElement getFacilitiesLinkChange_journey_date(String lang) {
		HashMap<String, String> linkTexts = new HashMap <String, String>();
		
		linkTexts.put("RO", "Modificare date de călătorie"); 
		linkTexts.put("EN", "Placeholder missing localization");
		
		WebElement link = driver.findElement(By.xpath("//a[text()='"+linkTexts.get(lang)+"']"));
		return link;
	}
	
	// SERVICES LINKS
	
	public WebElement getServicesLinkDiscount_purchase_train_tickets_line(String lang) {
		HashMap<String, String> linkTexts = new HashMap <String, String>();
		
		linkTexts.put("RO", "Bilete online în trafic intern"); 
		linkTexts.put("EN", "Placeholder missing localization");
		
		WebElement link = driver.findElement(By.xpath("//a[text()='"+linkTexts.get(lang)+"']"));
		return link;
	}
	
	public WebElement getServicesLinkTren_charter(String lang) {
		HashMap<String, String> linkTexts = new HashMap <String, String>();
		
		linkTexts.put("RO", "Tren Charter / Vagon Charter"); 
		linkTexts.put("EN", "Placeholder missing localization");
		
		WebElement link = driver.findElement(By.xpath("//a[text()='"+linkTexts.get(lang)+"']"));
		return link;
	}
	
	public WebElement getServicesLinkServices_major_railstations(String lang) {
		HashMap<String, String> linkTexts = new HashMap <String, String>();
		
		linkTexts.put("RO", "Servicii în stațiile mari"); 
		linkTexts.put("EN", "Placeholder missing localization");
		
		WebElement link = driver.findElement(By.xpath("//a[text()='"+linkTexts.get(lang)+"']"));
		return link;
	}
	
	public WebElement getServicesLinkTransport_services_bicycles_skis(String lang) {
		HashMap<String, String> linkTexts = new HashMap <String, String>();
		
		linkTexts.put("RO", "Transportul bicicletelor și schiurilor"); 
		linkTexts.put("EN", "Placeholder missing localization");
		
		WebElement link = driver.findElement(By.xpath("//a[text()='"+linkTexts.get(lang)+"']"));
		return link;
	}
	
	public WebElement getServicesLinkAnimal_transport_services(String lang) {
		HashMap<String, String> linkTexts = new HashMap <String, String>();
		
		linkTexts.put("RO", "Transportul animalelor de companie"); 
		linkTexts.put("EN", "Placeholder missing localization");
		
		WebElement link = driver.findElement(By.xpath("//a[text()='"+linkTexts.get(lang)+"']"));
		return link;
	}
	
	public WebElement getServicesLinkSingle_tariff_rate_section_route_oravita_anina(String lang) {
		HashMap<String, String> linkTexts = new HashMap <String, String>();
		
		linkTexts.put("RO", "Călătoria pe ruta Oravita – Anina"); 
		linkTexts.put("EN", "Placeholder missing localization");
		
		WebElement link = driver.findElement(By.xpath("//a[text()='"+linkTexts.get(lang)+"']"));
		return link;
	}
	
	public WebElement getServicesLinkTravelling_sleeping_berth_car(String lang) {
		HashMap<String, String> linkTexts = new HashMap <String, String>();
		
		linkTexts.put("RO", "Servicii la bordul trenului"); 
		linkTexts.put("EN", "Placeholder missing localization");
		
		WebElement link = driver.findElement(By.xpath("//a[text()='"+linkTexts.get(lang)+"']"));
		return link;
	}
	
	public WebElement getServicesLinkRenounce_to_travel(String lang) {
		HashMap<String, String> linkTexts = new HashMap <String, String>();
		
		linkTexts.put("RO", "Renunţarea la călătorie"); 
		linkTexts.put("EN", "Placeholder missing localization");
		
		WebElement link = driver.findElement(By.xpath("//a[text()='"+linkTexts.get(lang)+"']"));
		return link;
	}
	
	//HEADER ELEMENTS
	
	public WebElement getDomesticJourneysLink() {
		WebElement link = driver.findElement(By.xpath("/html//div[@id='page']/div[@class='header']//span/a[1]"));
		return link; 
	}
	
	// Actions 
	
	public void goToLoginPage() {
		Actions Actions = new Actions(driver);
		Actions.moveToElement(getMyAccountLink()).moveToElement(getDomesticTrafficLink()).click().perform();
	}
	
//	 Function created in order to easily navigate on page links opened on hover on another links 
//	 Hover over link1 in order to display the tooltip containing link2 and click link 2 
	public void goToLink(WebElement link1, WebElement link2) {
		Actions Actions = new Actions(driver);
		Actions.moveToElement(link1).click().perform();
		Actions.moveToElement(link2).click().perform();
	}
	
}
