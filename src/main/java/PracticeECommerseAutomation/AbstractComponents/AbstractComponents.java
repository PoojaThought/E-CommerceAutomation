package PracticeECommerseAutomation.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import PracticeECommerseAutomation.pageObjectMdel.CartPage;
import PracticeECommerseAutomation.pageObjectMdel.OrdersPage;

public class AbstractComponents 
{
	WebDriver driver;
	public AbstractComponents(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="[routerlink*='cart']")
	WebElement cartHeader;	

	@FindBy(css="[routerlink*='myorders']")
	WebElement orderHeader;	

	public void waitForElementToAppear(By findBy)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(findBy));
	}
	
	public void waitForElementToAppear(WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(element));
	}	

	public void waitForElementToDisappear(WebElement spinner)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(spinner));
	}

	public CartPage clickToCartbutton()
	{
		cartHeader.click();
		CartPage cp = new CartPage(driver);
		return cp;
	}
	
	public OrdersPage clickToOrdersMenu()
	{
		orderHeader.click();
		OrdersPage op = new OrdersPage(driver);
		return op;
	}
				
	
	
}
