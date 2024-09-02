package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage {

	public SearchPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(linkText = "MacBook")
	WebElement macbook;
	@FindBy(xpath = "//div[@class='caption']//a[contains(text(),'iPhone')]")
	WebElement iphone;

	public boolean isProductExist(String pname) {
		return macbook.isDisplayed();
	}

	public void SelectIphone() {
		iphone.click();
	}
}
