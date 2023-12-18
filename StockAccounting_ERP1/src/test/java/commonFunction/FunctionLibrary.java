package commonFunction;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utilities.PropertyFileUtil;
public class FunctionLibrary {

	public static WebDriver driver;
	
	// method for launch browser
	
	public static WebDriver startBrowser() throws Throwable
	{
		if(PropertyFileUtil.getValeForKey("Browser").equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			
		}
		else if(PropertyFileUtil.getValeForKey("Browser").equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		}
		else {
			System.out.println("Browser value is Not matching");
		}
		return driver;
	}
	
	// method for launching url
	
	public static void openApplcation() throws Throwable
	{
		driver.get(PropertyFileUtil.getValeForKey("Url"));
	}
	
	// method for wait for elements
	
	public static void waitForElement(WebDriver driver,String LocatorType,String LocatorValue,String mywait)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(Integer.parseInt(mywait)));
		if(LocatorType.equalsIgnoreCase("name"))
		{
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.name(mywait)));
		}
	else if(LocatorType.equalsIgnoreCase("xpath"))
	{
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(mywait)));

	}else if (LocatorType.equalsIgnoreCase("id"))
	{
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id(mywait)));

		}
	}
	
	// method for textboxes
	
	public static void typeAction (WebDriver driver, String LocatorType,String LovatorValue,String TestData)
	{
		if(LocatorType.equalsIgnoreCase("name"))
		{
			driver.findElement(By.name(LovatorValue)).clear();
			driver.findElement(By.name(LovatorValue)).sendKeys(TestData);

		}else if(LocatorType.equalsIgnoreCase("xpath"))
		{
			driver.findElement(By.xpath(LovatorValue)).clear();
			driver.findElement(By.xpath(LovatorValue)).sendKeys(TestData);
		}
		else if(LocatorType.equalsIgnoreCase("id"))
		{
			driver.findElement(By.id(LovatorValue)).clear();
			driver.findElement(By.id(LovatorValue)).sendKeys(TestData);
			
		}
		}
	
	   // method for buttons,links,checkboxes,radio button and image
	public static void clickAction(WebDriver driver, String LocatorType , String LocatorValue )
	{
		if(LocatorType.equalsIgnoreCase("name"))
		{
			driver.findElement(By.name(LocatorValue)).click();
		}
		else if(LocatorType.equalsIgnoreCase("xpath"))
		{
			driver.findElement(By.xpath(LocatorValue)).click();

		}		else if(LocatorType.equalsIgnoreCase("id"))

		{
			driver.findElement(By.id(LocatorValue)).sendKeys(Keys.ENTER);;
       
		}	
		}
	
	// method for validation
			public static void validateTitle (WebDriver driver, String Expected_Title)
			{
				String Actual_Title = driver.getTitle();
				try {
					Assert.assertEquals(Actual_Title, Expected_Title, "Title is not matching");
			
				} catch(Throwable t)
				{
					System.out.println(t.getMessage());
				}
				
			
		}
			
			// method for close browser
			
			public static void closeBrowser(WebDriver driver)
			{
				driver.quit();
			}
               // method for mouse click
			
			public static void mouseClick(WebDriver driver2) 
			{
			
				
			}
                // method for category table 
			
			public static void categoryTable(WebDriver driver2, String testData)
			{
				
				
			}

           
			}

        





