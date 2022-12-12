package PracticeECommerseAutomation.pageObjectMdel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import PracticeECommerseAutomation.AbstractComponents.AbstractComponents;

public class CheckoutPage extends AbstractComponents
{
	WebDriver driver;
	CheckoutPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="[placeholder*='Country']")
	WebElement country;
	
	@FindBy(css=".ta-item:nth-of-type(2)")
	WebElement countryDesired;	
	
	@FindBy(css=".action__submit")
	WebElement submit;
	
	By countryList = By.cssSelector(".ta-results");
	
	public void selectCountryName()
	{
		country.sendKeys("ind");
		waitForElementToAppear(countryList);
		countryDesired.click();
	}
	
	public ConfirmationPage clickOnSubmit()
	{
		submit.click();
		return new ConfirmationPage(driver);
	}
	
}
