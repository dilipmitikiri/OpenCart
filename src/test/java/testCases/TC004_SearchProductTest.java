package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC004_SearchProductTest extends BaseClass {

	@Test
	public void verify_productSearch() {

		logger.info("***Starting TC004_SearchProductTest***");

		try {
			HomePage hm = new HomePage(driver);
			hm.enterProductName("mac");
			hm.clickSearch();

			SearchPage sp = new SearchPage(driver);
			boolean b = sp.isProductExist("Macbook");
			Assert.assertTrue(b);
		} catch (Exception e) {
			Assert.fail();
		}

		logger.info("***Finished TC004_SearchProductTest***");
	}
}
