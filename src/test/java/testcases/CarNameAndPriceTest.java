package testcases;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import base.BasePage;
import base.BaseTest;
import pages.HomePage;
import pages.NewCarsPage;
import utilities.DataUtil;

public class CarNameAndPriceTest extends BaseTest {

	@Test(dataProviderClass = DataUtil.class, dataProvider = "dp")
	public void carNameAndPrice(String browser, String brandName, String runMode)  {
		if (runMode.equals("N")) {
			throw new SkipException("Skipping the test as the Run mode is NO");
		}

		setUp(browser);

		HomePage home = new HomePage(driver);
		NewCarsPage car = home.findNewCars();

		if (brandName.equals("Toyota")) {
			car.gotoToyota();
		}

		else if (brandName.equals("Hyundai")) {
			car.gotoHyundai();
		}
		if (brandName.equals("BMW")) {
		
			car.gotoBMW();
		}

		if (brandName.equals("Kia")) {
			car.gotoKia();
		}

		BasePage.carBase.getCarBrandNameAndPrice();
		
	}
}
