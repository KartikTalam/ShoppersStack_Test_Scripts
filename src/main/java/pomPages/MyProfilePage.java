package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyProfilePage {
	
	//DECLARATION
	@FindBy(xpath = "//div[text()='My Addresses']")
	private WebElement myAddressesLink;
	
	@FindBy(xpath = "//div[text()='My Wallet']")
	private WebElement myWalletLink;
	
	@FindBy(xpath = "//div[text()='My Likes']")
	private WebElement myLikesLink;
	
	@FindBy(xpath = "//button[contains(text(),'Edit Profile')]")
	private WebElement editProfileButton;
	
	@FindBy(xpath = "//*[name()='svg'][@role='img']")
	private WebElement uploadPhotoIcon;
	
	//INITIALIZATION
	public MyProfilePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//UTILIZATION
	public void clickMyAddresses()
	{
		myAddressesLink.click();
	}
	
	public void clickMyWallet()
	{
		myWalletLink.click();
	}
	
	public void clickMyLikes()
	{
		myLikesLink.click();
	}
	
	public void clickEditProfile()
	{
		editProfileButton.click();
	}
	
	public void clickUploadPhoto()
	{
		uploadPhotoIcon.click();
	}
}
