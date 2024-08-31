package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass {

	@Test(dataProvider = "Logindata", dataProviderClass = DataProviders.class, groups = "Datadriven")
	public void verify_loginDDT(String email, String pwd, String exp) throws InterruptedException {

		logger.info("***Started TC003_LoginDDT***");
		try {
			// Home page
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();

			// Login page
			LoginPage lp = new LoginPage(driver);
			lp.setEmail(email);
			lp.setPassword(pwd);
			lp.clickLogin();

			// My Account page
			MyAccountPage macc = new MyAccountPage(driver);
			boolean targetPage = macc.isMyAccountPageExists();

			/*
			 * Data is valid - login success- test pass- logout login failed-test fail Data
			 * is invalid - login success- test fail- logout login failed-test pass
			 */
			if (exp.equalsIgnoreCase("valid")) {
				if (targetPage == true) {
					macc.clickLogout();
					Assert.assertTrue(true);
				} else {
					Assert.assertTrue(false);
				}
			}

			if (exp.equalsIgnoreCase("invalid")) {
				if (targetPage == true) {
					macc.clickLogout();
					Assert.assertTrue(false);
				} else {
					Assert.assertTrue(true);
				}
			}
		} catch (Exception e) {
			Assert.fail();
		}
		logger.info("***Finished TC003_LoginDDT***");
	}
}
