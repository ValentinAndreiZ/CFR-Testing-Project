package base;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BasePage {
	public static WebDriver driver;
	protected String url; 
	private Properties prop; 
	private String lang; 
	 
	public BasePage() throws IOException {
		prop = new Properties();
		FileInputStream data = new FileInputStream(System.getProperty("user.dir") + "\\configs\\config.properties");
		prop.load(data);
		setLang();
	}
	

	public WebDriver getDriver() {
		
		if(prop.getProperty("browser").equals("chrome")) {
//			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\main\\java\\Drivers\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if(prop.getProperty("browser").equals("firefox")) {
//			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\src\\main\\java\\Drivers\\geckodriver.exe");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if(prop.getProperty("browser").equals("edge")) {
//			System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "\\src\\main\\java\\Drivers\\msedgedriver.exe");
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
	
		return driver;
	}
	
	public Properties getProp() {
		return prop; 
	}
	
	public void setHomePageUrl() {
		url = prop.getProperty("homePageUrl");
	}
	
	public void setDomesticJourneysUrl() {
		url = prop.getProperty("domesticJourneysUrl");
	}
	
	public void setLang() {
		lang = prop.getProperty("lang");
	}
	public String getLang() {
		return lang; 
	}
	
	public String getHomePageUrl() {
		return prop.getProperty("homePageUrl");	
	}
	
	public String getDomesticJourneysUrl() {
		return prop.getProperty("domesticJourneysUrl");
	}
	
	
}

