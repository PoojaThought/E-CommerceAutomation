package PracticeECommerseAutomation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import PracticeECommerseAutomation.TestComponent.BaseTest;
import PracticeECommerseAutomation.pageObjectMdel.CartPage;
import PracticeECommerseAutomation.pageObjectMdel.CheckoutPage;
import PracticeECommerseAutomation.pageObjectMdel.ConfirmationPage;
import PracticeECommerseAutomation.pageObjectMdel.ProductCatalog;

public class ErrorValidationTest extends BaseTest
{
	@Test
	public void loginErrorValidation()
	{
		lp.loginApplication("prd.pro.tester@gmail.com", "1234");
		Assert.assertEquals("Incorrect email or password.",lp.getErrorMessage());
	}
	
	@Test
	public void productNotAvailableErrorTest()
	{
		String productName = "adidas original11";					
		ProductCatalog pc = lp.loginApplication("prd.pro.tester@gmail.com", "Test@1234");				
		pc.addToCartProduct(productName);
		CartPage cp = pc.clickToCartbutton();				
		Assert.assertFalse(cp.findProductInCart(productName));		
	}
	
}
