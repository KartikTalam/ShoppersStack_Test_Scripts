package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericLibraries.WebDriverUtility;

public class HomePage {
	
	//DECLARATION
	@FindBy(id="electronics")
	private WebElement electronics;
	
	@FindBy(xpath = "//a[text()='Headphones']")
	private WebElement headphonesLink;
	
	@FindBy(xpath = "//button[@aria-label='Account settings']")
	private WebElement accountSettings;
	
	@FindBy(xpath = "//li[text()='Logout']")
	private WebElement logout;
	
	@FindBy(xpath = "//li[text()='My Profile']")
	private WebElement myProfile;
	
	@FindBy(xpath = "//li[text()='Wish List']")
	private WebElement wishlist;
	
	@FindBy(xpath = "//li[text()='My Orders']")
	private WebElement myOrders;
	
	@FindBy(xpath = "//li[text()='My Wallet']")
	private WebElement myWallet;
	
	@FindBy(xpath = "//li[text()='My Likes']")
	private WebElement myLikes;
	
	//INITIALIZATION
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//UTILIZATION
	public void mouseHoverToElectronics(WebDriverUtility web)
	{
		web.mouseHover(electronics);
	}
	
	public void clickHeadphones()
	{
		headphonesLink.click();
	}
	
	public void clickAccountSettings()
	{
		accountSettings.click();
	}
	
	public void clickLogout()
	{
		logout.click();
	}
	
	public void clickMyProfile()
	{
		myProfile.click();
	}
	
	public void clickWishlist()
	{
		wishlist.click();
	}
	
	public void clickMyOrders()
	{
		myOrders.click();
	}
	
	public void clickMyWallet()
	{
		myWallet.click();
	}
	
	public void clickMyLikes()
	{
		myLikes.click();
	}
	
	public WebElement getAccountSettings()
	{
		return accountSettings;
	}
	
	public WebElement getElectronics()
	{
		return electronics;
	}
}
