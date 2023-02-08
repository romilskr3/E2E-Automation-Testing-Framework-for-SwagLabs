package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage 
{
	public WebDriver driver;
	
	By username = By.xpath(".//input[@id='user-name']");
	By password = By.xpath(".//*[@id='password']");
	By loginbutton = By.xpath(".//*[@id='login-button']");
	By errormessage= By.xpath(".//*[@class='error-message-container error']");
	
	public LoginPage(WebDriver driver) 
	{
		this.driver=driver;
	}

	public WebElement getloginusername() 
	{
		return driver.findElement(username);
	}
	public WebElement getloginpassword() 
	{
		return driver.findElement(password);
	}
	public WebElement getloginbutton() 
	{
		return driver.findElement(loginbutton);
	}
	public WebElement errormessage() 
	{
		return driver.findElement(errormessage);
	}
}
