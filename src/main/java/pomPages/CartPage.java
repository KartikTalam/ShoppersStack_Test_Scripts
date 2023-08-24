package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	
	//DECLARATION
	@FindBy(xpath = "//div[@class='cart_productDetails__pKWBd']/p[1]")
	private WebElement cartItem;
	
	@FindBy(id="buynow_fl")
	private WebElement buyNowButton;
	
	@FindBy(xpath = "//span[text()='Continue Shopping']")
	private WebElement countinueShoppingButton;
	
	//INITIALIZATION
	public CartPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//UTILIZATION
	public String getCartItem()
	{
		return cartItem.getText();
	}
	
	public void clickBuyNow()
	{
		buyNowButton.click();
	}
	
	public void clickCountinueShopping()
	{
		countinueShoppingButton.click();
	}
}
