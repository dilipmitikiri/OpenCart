package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CheckOutPage;
import pageObjects.HomePage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC005_AddToCartTest extends BaseClass {
	@Test
	public void verify_AddTOCart() {

		logger.info("***starting TC005_AddToCartTest***");
		HomePage hm = new HomePage(driver);
		hm.enterProductName("iphone");
		hm.clickSearch();

		SearchPage sp = new SearchPage(driver);
		sp.SelectIphone();

		CheckOutPage cp = new CheckOutPage(driver);
		//cp.OrderQuantity("2");
		cp.AddToCart();
		boolean b = cp.ConfirmMessage();
		Assert.assertTrue(b);

		logger.info("***Finished TC005_AddToCartTest***");
	}

}