package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountsRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {

	@Test(groups = { "Regression", "Master" })
	public void verify_account_registration() throws InterruptedException {

		logger.info("**** Starting TC001_AccountRegistrationTest ****");
		try {
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			logger.info("Clicked on My Account link");
			hp.clickRegister();
			logger.info("Clicked on Registration link");
			AccountsRegistrationPage regpage = new AccountsRegistrationPage(driver);
			logger.info("Providing Customer details");
			regpage.setFirstName(randomeString().toUpperCase()); // Random string
			regpage.setLastName(randomeString().toUpperCase());
			regpage.setEmail(randomeString() + "@gmail.com");
			regpage.setTelephone(randomeNumber()); // Random number

			String password = randomeAlphaNumeric();// Random Alphanumeric

			regpage.setPassword(password);
			regpage.setConfirmPassword(password);
			regpage.setPrivacyPolicy();
			regpage.clickContinue();
			logger.info("Validating expected message...");
			String confmsg = regpage.getConfirmationMessage();
			if (confmsg.equals("Your Account Has Been Created!")) {
				Assert.assertTrue(true);
			} else {
				logger.error("Test failed...");
				logger.debug("Debug logs...");
				Assert.assertTrue(false);
			}
			// Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		}

		catch (Exception e) {
			Assert.fail();
		}

		logger.info("****Finished TC001_AccountRegistrationTest****");
	}

}
