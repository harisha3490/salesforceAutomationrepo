package Utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import java.util.logging.Logger;

public class TestBase {

	public static WebDriver driver;
	Logger log = Logger.getLogger(getClass().getSimpleName());

	public utilities oUtil = new utilities();
	
	@BeforeSuite
	public void launch() throws Exception 
	{		
		
//		Reading the properties file
		oUtil.loadPropertiesFile(System.getProperty("user.dir")+"/src/main/java/properties/Config.properties");
		oUtil.loadPropertiesFile(System.getProperty("user.dir")+"/src/main/resources/Propertyfile/ComponentReferenceTestData.properties");
		
		if(System.getProperty("Browser").equalsIgnoreCase("chrome")){
//			This is for windows machine
//			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/src/main/resources/drivers/chromedriver.exe");

//			This is for lynux browser
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/src/main/resources/drivers/chromedriver");
			driver=new ChromeDriver();
		}
		else{
			log.info("Browser Name invalid : "+System.getProperty("Browser"));
			
		}
		driver.manage().window().maximize();
		
	}

	@AfterSuite
	public void close ()
	{
		driver.quit();
	}
	
	public void launchBaseUrl() throws Exception
	{
		System.out.println("URL :: "+System.getProperty("URL"));
		log.info("URL :: "+System.getProperty("URL"));
		driver.get(System.getProperty("URL"));
		
	}
	
	public void scrollUp() throws Exception
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,550)", "");
	}
	
}
