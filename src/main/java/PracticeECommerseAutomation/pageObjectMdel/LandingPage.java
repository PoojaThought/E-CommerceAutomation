package PracticeECommerseAutomation.pageObjectMdel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import PracticeECommerseAutomation.AbstractComponents.AbstractComponents;

public class LandingPage extends AbstractComponents
{
	WebDriver driver;
	public LandingPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement userPass;

	@FindBy(id="login")
	WebElement login;
	
	@FindBy(css="[class*='flyInOut']")
	WebElement loginError;
	
	public ProductCatalog loginApplication(String email,String password)
	{
		userEmail.sendKeys(email);
		userPass.sendKeys(password);
		login.click();
		ProductCatalog pc = new ProductCatalog(driver);
		return pc;
	}
	
	public void goTo()
	{
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	public String getErrorMessage()
	{
		waitForElementToAppear(loginError);
		return loginError.getText();		 
	}
}
