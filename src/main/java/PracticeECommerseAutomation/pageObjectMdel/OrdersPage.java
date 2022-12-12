package PracticeECommerseAutomation.pageObjectMdel;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class OrdersPage 
{

	WebDriver driver;
	public OrdersPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="tr td:nth-child(3)")
	List<WebElement> orders;
	
	public boolean verifyOrderInOrdersMenu()
	{
		return orders.stream().anyMatch(o->o.getText().equalsIgnoreCase("adidas original"));
	}
}