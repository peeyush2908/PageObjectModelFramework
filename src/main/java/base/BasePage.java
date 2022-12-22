package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import extentlisteners.ExtentListeners;

public class BasePage {
	
	public static WebDriver driver;
	public static CarBase carBase;
	
	public BasePage(WebDriver driver)
	{
		this.driver= driver;
		carBase= new CarBase(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void click(WebElement element)
	{
		element.click();
		ExtentListeners.test.log(Status.INFO,"Clicking on an element:"+element);
	}
	

}
