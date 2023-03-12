/**
 * 
 */
package helperFunctions;

/**
 * @author Valentin
 *
 */
public class dateConvert {
	
	static String monthAbbreviationToMonthNumber(String abbreviation) {
		
		String monthNumber = new String(); 
		
		if(abbreviation.toLowerCase().equals("ian") || abbreviation.toLowerCase().equals("jan")) {
			monthNumber = "01";
		}
		if(abbreviation.toLowerCase().equals("feb")) {
			monthNumber = "02";
		}
		if(abbreviation.toLowerCase().equals("mar") || abbreviation.toLowerCase().equals("mart")) {
			monthNumber = "03";
		}
		if(abbreviation.toLowerCase().equals("apr")) {
			monthNumber = "04";
		}
		if(abbreviation.toLowerCase().equals("may") || abbreviation.toLowerCase().equals("mai")) {
			monthNumber = "05";
		}
		if(abbreviation.toLowerCase().equals("jun") || abbreviation.toLowerCase().equals("iun")) {
			monthNumber = "06";
		}
		if(abbreviation.toLowerCase().equals("jul") || abbreviation.toLowerCase().equals("iul")) {
			monthNumber = "07";
		}
		if(abbreviation.toLowerCase().equals("aug")) {
			monthNumber = "08";
		}
		if(abbreviation.toLowerCase().equals("sept")) {
			monthNumber = "09";
		}
		if(abbreviation.toLowerCase().equals("oct")) {
			monthNumber = "10";
		}
		if(abbreviation.toLowerCase().equals("nov")) {
			monthNumber = "11";
		}
		if(abbreviation.toLowerCase().equals("dec")) {
			monthNumber = "12";
		}
		
		return monthNumber;
	}

}
