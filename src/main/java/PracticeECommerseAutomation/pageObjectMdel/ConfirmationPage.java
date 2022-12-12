package PracticeECommerseAutomation.pageObjectMdel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import PracticeECommerseAutomation.AbstractComponents.AbstractComponents;

public class ConfirmationPage extends AbstractComponents
{
	WebDriver driver;
	ConfirmationPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".hero-primary")
	WebElement confirmMessage;
	
	public String getConfirmationText()
	{
		waitForElementToAppear(confirmMessage);
		return confirmMessage.getText();
	}
}
