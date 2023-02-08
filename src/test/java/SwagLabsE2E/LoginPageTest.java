package SwagLabsE2E;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import resources.base;

public class LoginPageTest extends base
{	
	public WebDriver driver;

	@Test
	public void locked_out_login() throws IOException
	{
		prop=logincred();
		driver = initializewebdriver();
		driver.get(prop.getProperty("URL"));
		LoginPage l = new LoginPage(driver);
		l.getloginusername().sendKeys(prop.getProperty("locked_out_user_username"));
		l.getloginpassword().sendKeys(prop.getProperty("locked_out_user_password"));
		l.getloginbutton().click();
		//failing test on purpose
		Assert.assertEquals(l.errormessage().getText(), "Epic sadface: Sorry, this user has been locked out");
		//driver.close();
	}
	
	@Test
	public void standard_user_login() throws IOException
	{
		prop = logincred();
		driver = initializewebdriver();
		driver.get(prop.getProperty("URL"));
		LoginPage l = new LoginPage(driver);
		l.getloginusername().sendKeys(prop.getProperty("standard_user_username"));
		l.getloginpassword().sendKeys(prop.getProperty("standard_user_password"));
		l.getloginbutton().click();
	}
	@AfterTest
	public void closedriver()
	{
		driver.close();
	}
}
