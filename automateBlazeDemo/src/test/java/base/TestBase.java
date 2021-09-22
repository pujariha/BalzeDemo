package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;




public class TestBase {
	
	/*
	 *WebDriver
	 *Properties 
	 * Logs
	 * Extent Reports
	 * DB
	 * Excel
	 *  
	 */
	
	public static WebDriver driver;
	
	public static Properties config = new Properties();
	public static Properties OR = new Properties();
	public static FileInputStream fis ;
	
	
	public static Logger log = Logger.getLogger("devpinoyLogger");
	
	
	@BeforeSuite
	public void setUp()
	{
		
		if(driver == null)
		{
			try {
				fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\config.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				config.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\OR.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				OR.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(config.getProperty("browser").equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\executables\\chromedriver.exe");			
			 driver  = new ChromeDriver();
		log.info("Chrome browser launched !!!");
		driver.get(config.getProperty("testsiteurl"));
		log.info("Navigated to: "+config.getProperty("testsiteurl"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Long.parseLong(config.getProperty("implicitwait")), TimeUnit.SECONDS);
		}	
	}
	
	@AfterSuite
	public void tearDown()
	{
		if(driver !=null)
		{
		  driver.quit();
		}
	}

}
