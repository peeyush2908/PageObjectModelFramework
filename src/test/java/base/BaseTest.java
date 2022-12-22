package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ExcelReader;

public class BaseTest {
	
	public  WebDriver driver;
	
	private Properties Config = new Properties();
	private FileInputStream fis;
	public  ExcelReader excel = new ExcelReader("./src/test/resources/excel/testdata.xlsx");
	private Logger log = Logger.getLogger(BaseTest.class);
	public  WebDriverWait wait;
	
	public void setUp(String browser)
	
	{

		

			PropertyConfigurator.configure(".\\src\\test\\resources\\properties\\log4j.properties");
			log.info("Test execution started !!!");

			try {
				fis = new FileInputStream("./src/test/resources/properties/Config.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				Config.load(fis);
				log.info("Config properties loaded !!!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				fis = new FileInputStream("./src/test/resources/properties/OR.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (browser.equals("chrome")) {
				
				Map<String, Object> prefs = new HashMap<String, Object>();
				prefs.put("profile.default_content_setting_values.notifications", 2);

				ChromeOptions options = new ChromeOptions();
				options.setExperimentalOption("prefs", prefs);
				options.setHeadless(false);
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver(options);
				log.info("Chrome browser launched !!!");
			} else if (browser.equals("firefox")) {

				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				log.info("Firefox browser launched !!!");
			}

			driver.get(Config.getProperty("testsiteurl"));
			log.info("Navigated to : " + Config.getProperty("testsiteurl"));
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
			driver.manage().timeouts()
					.implicitlyWait(Duration.ofSeconds(Integer.parseInt(Config.getProperty("implicit.wait"))));
			wait = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(Config.getProperty("explicit.wait"))));
		}

     @AfterMethod
	public void tearDown()
	{
     if(driver!= null)
     {
		driver.quit();
     }
	}

}
