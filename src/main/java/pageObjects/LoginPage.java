package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	public WebDriver driver;
	// Already created account used to test login functionality 
	private String user = "ilrbmxd@yahoo.com";
	private String password = "testAccountPassword";
	private String pageUrlPathId = "/Account/Login";
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getUser() {
		return user;
	}
	
	public String getPassword() {
		return password; 
	}
	
	public WebElement getHomePageLink() {
		WebElement link = driver.findElement(By.xpath("/html//a[@href='https://www.cfrcalatori.ro']/img[@alt='Logo CFR Călători']"));
		return link; 
	}
	
	public String getPageUrlPathId() {
		return pageUrlPathId;
	}
	
	public WebElement getUserInput() {
		WebElement input = driver.findElement(By.xpath("/html//input[@id='UserName']"));
		return input;
	}
	
	public WebElement getPasswordInput() {
		WebElement input = driver.findElement(By.xpath("/html//input[@id='Password']"));
		return input;
	}
	
	public WebElement getRememberMeCheckbox() {
		WebElement checkbox = driver.findElement(By.xpath("/html//input[@id='RememberMe']"));
		return checkbox; 
	}
	
	public WebElement getLoginButton() {
		WebElement button = driver.findElement(By.xpath("/html//button[@id='button-login']"));
		return button; 
	}
	
	public WebElement getCreateAccountLink() {
		WebElement link = driver.findElement(By.xpath("/html//div[@id='page']/div[@class='flex-grow-1']//section//a[@href='/ro-RO/Account/Register']"));
		return link; 
	}
	
}
