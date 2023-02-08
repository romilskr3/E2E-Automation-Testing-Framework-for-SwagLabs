package SwagLabsE2E;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import pageObjects.InventoryPage;
import pageObjects.LoginPage;
import resources.base;

public class InventoryPageTest extends base
{
	public WebDriver driver;

	@Test
	public void AddToCart() throws IOException
	{
		prop = logincred();
		driver = initializewebdriver();
		driver.get(prop.getProperty("URL"));
		LoginPage l = new LoginPage(driver);
		l.getloginusername().sendKeys(prop.getProperty("standard_user_username"));
		l.getloginpassword().sendKeys(prop.getProperty("standard_user_password"));
		l.getloginbutton().click();
		InventoryPage i = new InventoryPage(driver);
		i.getbikelight().click();
		i.getbagpack().click();
		Assert.assertEquals(i.ItemsInCart().getText(), "2");
	}
	@AfterTest
	public void closrdriver()
	{
		driver.close();
	}
}
