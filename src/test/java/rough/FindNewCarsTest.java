package rough;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;

import base.BasePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.BMWCarsPage;
import pages.HomePage;
import pages.NewCarsPage;
import pages.ToyotaCarsPage;

public class FindNewCarsTest  {
	
	public static void main(String[] args) {
		
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.default_content_setting_values.notifications", 2);

		
		
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", prefs);
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.carwale.com/");
		
		HomePage home= new HomePage(driver);
	    NewCarsPage car=	home.findNewCars();
	
	    //BMWCarsPage bmw= car.gotoBMW();
	  ToyotaCarsPage  toyota=   car.gotoToyota();
	    System.out.println(BasePage.carBase.getCarTitle());
		
		//new HomePage(driver).findNewCars().gotoBMW().verifyCarTitle();
	
		
	}

}
