package testcases;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import base.BasePage;
import base.BaseTest;
import pages.HomePage;
import pages.NewCarsPage;
import pages.ToyotaCarsPage;
import utilities.DataUtil;

public class FindNewCarsTest extends BaseTest {

	@Test(dataProviderClass = DataUtil.class, dataProvider = "dp")
	public void findCarTest(String browser, String brandName, String carTitle, String runMode)  {
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

		System.out.println(BasePage.carBase.getCarTitle());
		Assert.assertEquals(BasePage.carBase.getCarTitle(), carTitle);
	}

}
