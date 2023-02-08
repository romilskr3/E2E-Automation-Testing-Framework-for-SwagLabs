package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class base 
{	
	public WebDriver driver;
	public Properties prop;
	@SuppressWarnings("deprecation")
	public WebDriver initializewebdriver() throws IOException
	{	
		prop = logincred();
		String BrowserName = prop.getProperty("browser");
		if (BrowserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		//More conditional statements can be added if dealing with multiple browsers
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	public Properties logincred() throws IOException
	{
		Properties prop = new Properties();
		FileInputStream file = new FileInputStream("C:\\Users\\romil\\Desktop\\SwagLabsE2E\\SwagLabsE2E\\src\\main\\java\\resources\\global_variables.properties");
		prop.load(file);
		return prop;
	}
	public String FailureScreenshot(String FailedMethodName, WebDriver driver) throws IOException
	{
		TakesScreenshot t = (TakesScreenshot) driver;
		File source = t.getScreenshotAs(OutputType.FILE);
		String ssDestination = System.getProperty("user.dir")+"\\reports\\"+FailedMethodName+".png";
		FileUtils.copyFile(source, new File(ssDestination));
		return ssDestination;
	}
}
