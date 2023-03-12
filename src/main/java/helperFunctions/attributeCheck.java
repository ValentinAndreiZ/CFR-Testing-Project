package helperFunctions;

import org.openqa.selenium.WebElement;

public class attributeCheck {
	
	public static boolean attributeExists(WebElement element, String attribute) {
		boolean result = false; 
		
		String value = element.getAttribute(attribute); 
		
		if(value != null) {
			result = true; 
		}
		
		return result;
	}
}
