package PracticeECommerseAutomation.pageObjectMdel;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage 
{
	WebDriver driver;
	public CartPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".cartSection h3")
	List<WebElement> cartProducts;
	
	@FindBy(css=".totalRow button")
	WebElement checkout;

	
	public List<WebElement> getcartProductList()
	{
		return cartProducts;
	}
	
	public boolean findProductInCart(String productName)
	{
		return getcartProductList().stream().anyMatch(p->p.getText().equalsIgnoreCase(productName));
	}
	
	public CheckoutPage goToCheckOut()
	{
		checkout.click();
		return new CheckoutPage(driver);
	}
}
