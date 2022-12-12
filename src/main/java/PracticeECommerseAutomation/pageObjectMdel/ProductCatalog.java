package PracticeECommerseAutomation.pageObjectMdel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import PracticeECommerseAutomation.AbstractComponents.AbstractComponents;

public class ProductCatalog extends AbstractComponents
{
	WebDriver driver;
	public ProductCatalog(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".mb-3")
	List<WebElement> products; 
	
	@FindBy(css=".ng-animating")
	WebElement spinner; 
	
	
	By productBy = By.cssSelector(".mb-3");
	By addToCartBy = By.cssSelector(".card-body button:last-of-type");
	By toastCotainerBy = By.id("toast-container");
	
	public List<WebElement> getProductList()
	{
		waitForElementToAppear(productBy);
		return products;
	}
	
	public WebElement getProductByName(String productName)
	{
		WebElement prod = getProductList().stream().filter(p->p.findElement(By.cssSelector("b")).getText().equalsIgnoreCase(productName)).findFirst().orElse(null);
		return prod;
	}
	
	public void addToCartProduct(String productName)
	{
		getProductByName(productName).findElement(addToCartBy).click();
		waitForElementToAppear(toastCotainerBy);
		waitForElementToDisappear(spinner);
	}
	
}
