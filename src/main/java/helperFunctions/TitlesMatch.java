package helperFunctions;



public class TitlesMatch {
	
	// this function takes in two arguments, the current page's title and the expected title
	// this function was created because the page titles are different based on used localization 
	
	public static boolean getTitlesMatch(String pageTitle, String expectedTitle) {
		boolean titlesMatch = false; 
		
			if(expectedTitle.equals(pageTitle)) {
				titlesMatch = true; 
			}

		if (titlesMatch == false) {
			System.out.println("Expected title was " + expectedTitle + " but " + pageTitle + "was found.");
		}
		
		return titlesMatch; 
	}
	
}
