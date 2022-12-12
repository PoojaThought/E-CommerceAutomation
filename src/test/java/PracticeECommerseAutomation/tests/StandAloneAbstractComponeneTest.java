package PracticeECommerseAutomation.tests;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PracticeECommerseAutomation.TestComponent.BaseTest;
import PracticeECommerseAutomation.TestComponent.Retry;
import PracticeECommerseAutomation.pageObjectMdel.CartPage;
import PracticeECommerseAutomation.pageObjectMdel.CheckoutPage;
import PracticeECommerseAutomation.pageObjectMdel.ConfirmationPage;
import PracticeECommerseAutomation.pageObjectMdel.LandingPage;
import PracticeECommerseAutomation.pageObjectMdel.OrdersPage;
import PracticeECommerseAutomation.pageObjectMdel.ProductCatalog;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneAbstractComponeneTest extends BaseTest
{
	String productName;
	@Test(dataProvider= "getData",groups= {"Purchase"},retryAnalyzer=Retry.class)
	public void submitOrder(HashMap<String,String> input) throws IOException 
	{							
		ProductCatalog pc = lp.loginApplication(input.get("email"), input.get("password"));				
		pc.addToCartProduct(input.get("product"));
		CartPage cp = pc.clickToCartbutton();				
		Assert.assertTrue(cp.findProductInCart(input.get("product")));		
		CheckoutPage ck = cp.goToCheckOut();
		ck.selectCountryName();
		ConfirmationPage co = ck.clickOnSubmit();		
		String finalMessage = co.getConfirmationText();
		System.out.println(finalMessage);
		Assert.assertEquals(finalMessage, "THANKYOU FOR THE ORDER.");

	}
		
	@Test(dependsOnMethods= {"submitOrder"})
	public void verifyOrderPresent()
	{
		ProductCatalog pc = lp.loginApplication("prd.pro.tester@gmail.com", "Test@1234");
		OrdersPage op = pc.clickToOrdersMenu();
		Assert.assertTrue(op.verifyOrderInOrdersMenu());
	}
	

	
	@DataProvider
	public Object[][] getData()
	{
		HashMap<String,String> map = new HashMap<String,String>();
		map.put("email", "prd.pro.tester@gmail.com");
		map.put("password", "Test@1234");
		map.put("product", "ZARA COAT 3");
		
		HashMap<String,String> map1 = new HashMap<String,String>();
		map1.put("email", "anshika@gmail.com");
		map1.put("password", "Iamking@000");
		map1.put("product", "adidas original");

		return new Object[][] {{map},{map1}};
	}
	
	//@DataProvider
	//public Object[][] getData()
	//{
	//	return new Object[][] {{"prd.pro.tester@gmail.com","Test@1234","ZARA COAT 3"},{"shetty@gmail.com","Iamking@000","adidas original"}};
	//}
}
