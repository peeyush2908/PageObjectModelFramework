package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BasePage;

public class NewCarsPage extends BasePage {
	
	
	
	public NewCarsPage(WebDriver driver) {
		super(driver);
		
	}

	@FindBy(linkText = "Toyota")
	public WebElement toyota;

	public ToyotaCarsPage gotoToyota() {

		click(toyota);
		return new ToyotaCarsPage(driver);
		//return PageFactory.initElements(driver, ToyotaCarsPage.class);

	}

	
	@FindBy(linkText = "Hyundai")
	public WebElement bmw;
	
	public BMWCarsPage gotoBMW() {
		click(bmw);
		return new BMWCarsPage(driver);
		//return PageFactory.initElements(driver, BMWCarsPage.class);
	}

	
	@FindBy(linkText = "Hyundai")
	public WebElement hyundai;
	
	public HyundaiCarsPage gotoHyundai() {
		click(hyundai);
		return new HyundaiCarsPage(driver);
		//return PageFactory.initElements(driver, HyundaiCarsPage.class);
	}

	
	@FindBy(linkText = "Kia")
	public WebElement kia;
	
	public KiaCarsPage gotoKia() {

		click(kia);
		return new KiaCarsPage(driver);
		//return PageFactory.initElements(driver, KiaCarsPage.class);

	}
}
