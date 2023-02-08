package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InventoryPage 
{

	public WebDriver driver;	
	public InventoryPage(WebDriver driver) 
	{
		this.driver=driver;
	}
	By bikelight = By.xpath(".//*[@name='add-to-cart-sauce-labs-bike-light']");
	public WebElement getbikelight() 
	{
		return driver.findElement(bikelight);
	}
	By bagpack = By.xpath(".//*[@name='add-to-cart-sauce-labs-backpack']");
	public WebElement getbagpack() 
	{
		return driver.findElement(bagpack);
	}
	By ItemsInCart = By.xpath(".//*[@class='shopping_cart_badge']");
	public WebElement ItemsInCart() 
	{
		return driver.findElement(ItemsInCart);
	}
}
