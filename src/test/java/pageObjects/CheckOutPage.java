package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckOutPage extends BasePage {

	public CheckOutPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "TC005_AddToCartTest")
	WebElement quantity;
	@FindBy(xpath = "//button[@id='button-cart']")
	WebElement addToCart;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement cnfMsg;

	public void OrderQuantity(String qty) {
		quantity.sendKeys(qty);
	}

	public void AddToCart() {

		addToCart.click();

	}

	public boolean ConfirmMessage() {

		return cnfMsg.isDisplayed();
	}
}
