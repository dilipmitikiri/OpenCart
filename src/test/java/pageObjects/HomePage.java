package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//span[@class='caret']")
	WebElement lnkMyaccount;
	@FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Register']")
	WebElement lnkRegister;
	@FindBy(xpath = "//a[normalize-space()='Login']")
	WebElement lnkLogin;
	@FindBy(xpath = "//input[@placeholder='Search']")
	WebElement searchField;
	@FindBy(xpath = "//i[@class='fa fa-search']")
	WebElement searchBtn;

	public void clickMyAccount() {
		lnkMyaccount.click();
	}

	public void clickRegister() {
		lnkRegister.click();
	}

	public void clickLogin() {
		lnkLogin.click();
	}

	public void enterProductName(String pname) {
		searchField.sendKeys(pname);
	}

	public void clickSearch() {
		searchBtn.click();
	}
}
