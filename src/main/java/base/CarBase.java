package base;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CarBase {
	
	WebDriver driver;
	
	public CarBase(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	

	@FindBy(xpath="//*[@id=\"root\"]/div[3]/div/div[2]/div/h1")
	public WebElement carTitle;
	

	public String getCarTitle()
	{
		return carTitle.getText();
	}
	
	@FindBy(xpath="//div/div/div/a/h3")
	public List<WebElement> carNames;
	
	@FindBy(xpath="//div/div/div/div[3]/div/span/span[1]")
	public List<WebElement> carPrices;
	
	public void getCarBrandNameAndPrice()
	{
		for(int i=0;i<carPrices.size();i++)
		{
			System.out.println(carNames.get(i).getText()+"------Car Price is"+carPrices.get(i).getText());
		}
	}

}
