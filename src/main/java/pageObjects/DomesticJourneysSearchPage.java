package pageObjects;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import helperFunctions.attributeCheck;

public class DomesticJourneysSearchPage {
	
	public WebDriver driver;
	
	private HashMap<String,String> expectedTitles = new HashMap<String, String>();
	private HashMap<String, String> journeyInfo = new HashMap<String, String>();

	public DomesticJourneysSearchPage(WebDriver driver) {
		this.driver = driver;
		expectedTitles.put("RO", "Rute + cumpără - Bilete online CFR Călători");
		expectedTitles.put("EN", "Itineraries + buy - CFR Călători online tickets");
	}
	
	public String getExpectedTitle(String lang) {
		return expectedTitles.get(lang);
	}
	
	public WebElement getAccountSettingsDropdown() {
		 WebElement accountSettingsDropdown = driver.findElement(By.xpath("/html//ul[@class='navbar-nav']/li[@id='li-login']"));
		 return accountSettingsDropdown;
	}
	
	public WebElement getLogOutButton() {
		WebElement logOutButton = driver.findElement(By.xpath("//form[@id='logoutForm']/button[@type='submit']"));
		return logOutButton;
	}
	
	//BASIC SEARCH
	public WebElement getDepartureStationInput() {
		WebElement input = driver.findElement(By.xpath("/html//input[@id='input-station-departure-name']"));
		return input;
	}
	
	public WebElement getDepartureStationMapButton() {
		WebElement button = driver.findElement(By.xpath("//div[@id='div-icon-input-station-departure-name']/button[@type='button']"));
		return button;
	}
	
	public WebElement getArrivalStationInput() {
		WebElement input = driver.findElement(By.xpath("/html//input[@id='input-station-arrival-name']"));
		return input;
	}
	
	public WebElement getArrivalStationMapButton() {
		WebElement button = driver.findElement(By.xpath("//div[@id='div-icon-input-station-arrival-name']/button[@type='button']"));
		return button;
	}
	
	public WebElement getDepartureDateInput() {
		WebElement input = driver.findElement(By.xpath("/html//input[@id='input-date-departure']"));
		return input;
	}
	
	public WebElement getDepartureDateButton() {
		WebElement button = driver.findElement(By.xpath("//div[@id='div-icon-input-date-departure']/button[@type='button']"));
		return button;
	}
	
	public WebElement getDepartureDateCalendarDiv() {
		WebElement div = driver.findElement(By.xpath("/html//div[@id='ui-datepicker-div']"));
		return div; 
	}
	
	public WebElement getDepartureDateNextMonthButton() {
		WebElement button = getDepartureDateCalendarDiv().findElement(By.xpath(".//a[@title='Luna următoare »']/span[@class='ui-icon ui-icon-circle-triangle-e']"));
		return button;
	}
	
	public WebElement getDepartureDateCalendarTable() {
		WebElement calendarDiv = getDepartureDateCalendarDiv(); 
		WebElement calendarTable = calendarDiv.findElement(By.xpath("./table[@class='ui-datepicker-calendar']"));
		return calendarTable;
	}
	
	public WebElement getDepartureDateTableBody() {
		WebElement calendarTable = getDepartureDateCalendarTable();
		WebElement calendarTableBody = calendarTable.findElement(By.xpath("./tbody"));
		return calendarTableBody;
	}
	
	public WebElement getTodayTableCell() {
		// Getting today as string (day of month 1-31)
		String today = Integer.toString(LocalDate.now().getDayOfMonth());
		// tableData list will hold the values of each datepicker day displayed (Webelement = td)
		List<WebElement> tableData = new ArrayList<WebElement>(); 
		// Navigate through the date picker table to its body 
		WebElement tableBody = getDepartureDateTableBody(); 
		
		List<WebElement> tableRows = tableBody.findElements(By.tagName("tr"));
		// Iterate through all table rows and for each row create a tds list. For each tds list, add every td in the tableData List 
		for(int i = 0; i<tableRows.size(); i++) { 
			List<WebElement> tdList = tableRows.get(i).findElements(By.tagName("td"));
			for(int j = 0; j<tdList.size(); j++) {
				tableData.add(tdList.get(j));
			}	
		}
		// For each element in the tableData list, compare its value to current day. If they are the same, return the td element as 
		// it is the corresponding element of today
		for(int i = 0; i<tableData.size(); i++) {
			if(tableData.get(i).getAttribute("textContent").equals(today)) {
				return tableData.get(i);
			}
		}
		return null;
	}
	
	// Function responsible with picking the next day in the daypicker 
	public WebElement getNextDayTableCell() {
				// tableData list will hold the values of each datepicker day displayed (Webelement = td)
				List<WebElement> tableData = new ArrayList<WebElement>(); 
				// Navigate through the date picker table to its body 
				WebElement tableBody = getDepartureDateTableBody(); 
				
				List<WebElement> tableRows = tableBody.findElements(By.tagName("tr"));
				// Iterate through all table rows and create a tds list. For each tds list, add every td in the tableData List 
				for(int i = 0; i<tableRows.size(); i++) { 
					List<WebElement> tdList = tableRows.get(i).findElements(By.tagName("td"));
					for(int j = 0; j<tdList.size(); j++) {
						if(attributeCheck.attributeExists(tdList.get(j), "data-event")) {
							tableData.add(tdList.get(j));
						}
					}	
				}
				
				if(tableData.size()>1) {
					return tableData.get(1);
				}else if (tableData.size()==1) {
					getDepartureDateNextMonthButton().click();
					
					WebElement tableBody2 = getDepartureDateTableBody();
					
					List<WebElement> tableRows2 = tableBody2.findElements(By.tagName("tr"));
					for(int i = 0; i<tableRows2.size(); i++) { 
						List<WebElement> tdList = tableRows2.get(i).findElements(By.tagName("td"));
						for(int j = 0; j<tdList.size(); j++) {
							if(attributeCheck.attributeExists(tdList.get(j), "data-event")) {
								tableData.add(tdList.get(j));
							} 
						}	
					}
					return tableData.get(2);
				}
				
				return null; 		
	}
	
	// Function responsible with picking the last day in the daypicker based on interval given
	public WebElement getLastDayTableCell(int interval) {
		// tableData list will hold the values of each datepicker day displayed (Webelement = td)
		List<WebElement> tableData = new ArrayList<WebElement>(); 
		// Navigate through the date picker table to its body 
		WebElement tableBody = getDepartureDateTableBody(); 
		
		List<WebElement> tableRows = tableBody.findElements(By.tagName("tr"));
		// Iterate through all table rows and for each row create a tds list contained in each row. 
		// For each tds list, add every td in the tableData List only if it has the data-event attribute
		// present. That means the cell can be clicked on. 
		for(int i = 0; i<tableRows.size(); i++) { 
			List<WebElement> tdList = tableRows.get(i).findElements(By.tagName("td"));
			for(int j = 0; j<tdList.size(); j++) {
				if(attributeCheck.attributeExists(tdList.get(j), "data-event")) {
					tableData.add(tdList.get(j));
				} 
			}	
		}
		
		// If the cells number in tableData are less than 30 that means the last selectable day is not on current calendar page 
		if(tableData.size()<interval) {
			// Navigating to the next month in calendar in order to reach the last selectable day 
			getDepartureDateNextMonthButton().click();
			// Repeat the same process as above, iterate through rows an through table cells. Add only table cells with
			// data-event attribute present to the existing table data list. 
			WebElement tableBody2 = getDepartureDateTableBody();
			
			List<WebElement> tableRows2 = tableBody2.findElements(By.tagName("tr"));
			for(int i = 0; i<tableRows2.size(); i++) { 
				List<WebElement> tdList = tableRows2.get(i).findElements(By.tagName("td"));
				for(int j = 0; j<tdList.size(); j++) {
					if(attributeCheck.attributeExists(tdList.get(j), "data-event")) {
						tableData.add(tdList.get(j));
					} 
				}	
			}
			return tableData.get(tableData.size()-1);
		} else if(tableData.size() == interval) {
			return tableData.get(tableData.size()-1);
		}
				
		System.out.println(tableData.size());

		return null; 		
}
	
	public WebElement getReverseStationsButton() {
		WebElement button = driver.findElement(By.xpath("/html//button[@id='button-switch-stations']"));
		return button; 
	}
	
	public WebElement getPreviousDayButton() {
		WebElement button = driver.findElement(By.xpath("/html//button[@id='button-day-previously-input-date-departure']"));
		return button; 
	}
	
	public WebElement getTomorrowButton() {
		WebElement button = driver.findElement(By.xpath("/html//button[@id='button-day-next-input-date-departure']"));
		return button; 
	}
	
	public WebElement getAdvancedFieldsButton() {
		WebElement button = driver.findElement(By.xpath("/html//button[@id='button-itineraries-advanced']")); 
		return button; 
	}
	
	// ADVANCED SEARCH 
	// TIME INTERVAL 
	public Select getTimeIntervalOptionsSelect() {
		Select select = new Select(driver.findElement(By.name("TimeSelectionId")));
		return select;
	}
	
	public Select getTimeIntervalOptionsDateAndHourSelect() {
		Select select = new Select(driver.findElement(By.name("MinutesInDay")));
		return select;
	}
	
	public Select getTimeIntervalOptionsOrderTypeSelect() {
		Select select = new Select(driver.findElement(By.name("OrderingTypeId")));
		return select; 
	}
	
	// CONNECTIONS 
	public WebElement getConnectionsForm() {
		WebElement form = driver.findElement(By.xpath("//div[@id='div-itineraries-advanced']/div[3]"));
		return form; 
	}
	
	public WebElement getSelectedConnectionLabel() {
		WebElement selectedConnectionLabel = null; 
		// Creating a list of all connection labels. The labels hold the radio buttons and the text content for the connections
		List<WebElement> connectionLabels = getConnectionsForm().findElements(By.tagName("label"));
		// Iterating through the labels and if the radio input inside them is checked then we return that label from the function
		for (int i = 0; i<connectionLabels.size(); i++) {
			WebElement currentLabel = connectionLabels.get(i);
			if(currentLabel.findElement(By.tagName("input")).getAttribute("checked") != null) {
				selectedConnectionLabel = currentLabel; 
			}		
		}
		return selectedConnectionLabel; 
	}
	
	// CHANGING TRAIN OPTIONS 
	public Select getMinimumDurationWhenChanginTrainSelect() {
		Select select = new Select(driver.findElement(By.name("BetweenTrainsMinimumMinutes")));
		return select; 
	}
	
	public WebElement getIntermediateStationInput() {
		WebElement input = driver.findElement(By.xpath("/html//input[@id='input-station-change-name']"));
		return input;
	}
	
	public WebElement getIntermediateStationMapButton1() {
		WebElement button = driver.findElement(By.xpath("//div[@id='div-icon-input-station-change-name']/button[@type='button']"));
		return button;
	}
	
	public WebElement getIntermediateStationMapButton2() {
		WebElement button = driver.findElement(By.xpath("/html//button[@id='button-input-station-change-name']"));
		return button;
	}
	
	// SERVICES
	
	public WebElement getOnlyBuyOnlineCheckbox() {
		WebElement checkbox = driver.findElement(By.xpath("/html//input[@id='input-is-online-buying-required']")); 
		return checkbox; 
	}
	
	public WebElement getOnlyBuyOnlineLabel() {
			WebElement label = driver.findElement(By.xpath("/html//div[@id='div-itineraries-advanced']/div[6]/div[@class='form-check form-check-inline']/label[@class='form-check-label']")); 
			// We only want to return the label web element if its checkbox is checked. Otherwise, this function returns null and informs the 
			//user that the checkbox of this label is not currently checked. 
			if(getOnlyBuyOnlineCheckbox().getAttribute("checked")!= null) {
				return label; 
			}
//		System.out.println("The checkbox for onlyBuyOnline is not checked.");
		return null; 
	}

	public WebElement getOnlyBicicleCoachCheckbox() {
		WebElement checkbox = driver.findElement(By.xpath("/html//input[@id='input-is-bikes-service-required']")); 
		return checkbox; 
	}
	
	public WebElement getOnlyBicicleCoachLabel() {
			WebElement label = driver.findElement(By.xpath("/html//div[@id='div-itineraries-advanced']/div[7]/div[@class='form-check form-check-inline']/label[@class='form-check-label']")); 
			// We only want to return the label web element if it's checkbox is checked. Otherwise, this function returns null and informs the 
			//user that the checkbox of this label is not currently checked. 
			if(getOnlyBicicleCoachCheckbox().getAttribute("checked")!= null) {
				return label; 
			}
//		System.out.println("The checkbox for onlyBicicleCoach is not checked.");
		return null; 
	}
	
	public WebElement getBarRestaurantCoachCheckbox() {
		WebElement checkbox = driver.findElement(By.xpath("/html//input[@id='input-is-bar-restaurant-service-required']")); 
		return checkbox; 
	}
	
	public WebElement getBarRestaurantCoachLabel() {
			WebElement label = driver.findElement(By.xpath("/html//div[@id='div-itineraries-advanced']/div[8]/div[@class='form-check form-check-inline']/label[@class='form-check-label']")); 
			// We only want to return the label web element if it's checkbox is checked. Otherwise, this function returns null and informs the 
			//user that the checkbox of this label is not currently checked. 
			if(getBarRestaurantCoachCheckbox().getAttribute("checked")!= null) {
				return label; 
			}
//		System.out.println("The checkbox for onlyBarRestaurantCoach is not checked.");
		return null; 
	}
	
	public WebElement getSleeperCouchetteCoachCheckbox() {
		WebElement checkbox = driver.findElement(By.xpath("/html//input[@id='input-is-sleeper-couchette-service-required']")); 
		return checkbox; 
	}
	
	public WebElement getSleeperCouchetteCoachLabel() {
			WebElement label = driver.findElement(By.xpath("/html//div[@id='div-itineraries-advanced']/div[9]/div[@class='form-check form-check-inline']/label[@class='form-check-label']")); 
			// We only want to return the label web element if it's checkbox is checked. Otherwise, this function returns null and informs the 
			//user that the checkbox of this label is not currently checked. 
			if(getSleeperCouchetteCoachCheckbox().getAttribute("checked")!= null) {
				return label; 
			}
//		System.out.println("The checkbox for onlyBarRestaurantCoach is not checked.");
		return null; 
	}
	
	// SUBMIT 
	public WebElement getSearchButton() {
		WebElement button = driver.findElement(By.cssSelector("[action] [type='submit']")); 
		return button; 
	}
	
	// MAP PICKER 
	// Buttons 
	public WebElement getSelectLocationButton() {
		WebElement button = driver.findElement(By.xpath("/html//button[@id='button-select-location']"));
		return button; 
	}
	
	public WebElement getCloseButton() {
		WebElement button = driver.findElement(By.xpath("/html//button[@id='button-select-location']"));
		return button; 
	}
	
	public WebElement getMapDiv() {
		WebElement mapDiv = driver.findElement(By.xpath("/html//div[@id='div-fullscreen-2-map-div']"));
		return mapDiv; 
	}
	
	public WebElement getStationButton(int stationNumber) {
		WebElement button = driver.findElement(By.xpath("/html//div[@id='div-fullscreen-2-map-div']//div[@class='list-group']/button["+stationNumber+"]"));
		return button; 
	}
	
	// Function responsible with storing all inserted data at a given time (whenever it gets called) during any test
	// It behaves like a screenshot of the search page
	public HashMap<String, String> getJourneyInfo() {
		//BASIC INFO 
		journeyInfo.put("departureStation", getDepartureStationInput().getAttribute("value"));
		journeyInfo.put("arrivalStation", getArrivalStationInput().getAttribute("value"));
		journeyInfo.put("departureDate", getDepartureDateInput().getAttribute("value"));
		//ADVANCED INFO 
		journeyInfo.put("timeIntervalOptions", getTimeIntervalOptionsSelect().getFirstSelectedOption().getAttribute("textContent"));
		journeyInfo.put("timeIntervalOptionsDateAndHour", getTimeIntervalOptionsDateAndHourSelect().getFirstSelectedOption().getAttribute("textContent"));
		journeyInfo.put("timeIntervalOptionsOrderType", getTimeIntervalOptionsOrderTypeSelect().getFirstSelectedOption().getAttribute("textContent"));
		journeyInfo.put("connectionsOption", getSelectedConnectionLabel().getAttribute("textContent"));
		journeyInfo.put("minimumDurationWhenChangingTrain", getMinimumDurationWhenChanginTrainSelect().getFirstSelectedOption().getAttribute("textContent"));
		journeyInfo.put("intermediateStation", getIntermediateStationInput().getAttribute("value"));
		
		if(getOnlyBuyOnlineLabel() != null) {
			journeyInfo.put("onlyBuyOnlineOption", getOnlyBuyOnlineLabel().getAttribute("textContent"));
		}
		
		if(getOnlyBicicleCoachLabel() != null) {
			journeyInfo.put("onlyBicicleCoachOption", getOnlyBicicleCoachLabel().getAttribute("textContent"));
		}
		
		if(getBarRestaurantCoachLabel() != null) {
			journeyInfo.put("barRestaurantCoachOption", getBarRestaurantCoachLabel().getAttribute("textContent"));
		}
		
		if(getSleeperCouchetteCoachLabel() != null) {
			journeyInfo.put("sleeperCouchetteCoachOption", getSleeperCouchetteCoachLabel().getAttribute("textContent"));

		}
			
		return journeyInfo;
	}
}
