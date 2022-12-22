package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BasePage;

public class HomePage extends BasePage {
	
	
	

	public HomePage(WebDriver driver) {
		super(driver);
		
	}

	public void searchCar()
	{
		
	}
	
	@FindBy(xpath="//*[@id=\"root\"]/div[2]/header/div/nav/ul/li[1]/div")
	public WebElement newCarMenu;
	
	@FindBy(xpath="//div[contains(text(),'Find New Cars')]")
	public WebElement findNewCars;
	
	public NewCarsPage findNewCars()
	{
		
		new Actions(driver).moveToElement(newCarMenu).perform();
		click(findNewCars);
		
		return new NewCarsPage(driver);
		//return PageFactory.initElements(driver, NewCarsPage.class);
	}

	
	public void byUsedCars()
	{
		
	}
	
	public void verifyAllBrands()
	{
		
	}
}
