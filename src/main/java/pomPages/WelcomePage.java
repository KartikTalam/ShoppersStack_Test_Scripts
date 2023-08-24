package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WelcomePage {
	
	//DECLARATION
	@FindBy(id="loginBtn")
	private WebElement loginButton;
	
	@FindBy(id="home")
	private WebElement shoppersstackLogo;
	
	@FindBy(xpath = "//h3")
	private WebElement welcometext;
	
	//INITIALIZATION
	public WelcomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//UTILIZATION
	public void clickLoginButton()
	{
		loginButton.click();
	}
	
	public void clickShoppersstackLogo()
	{
		shoppersstackLogo.click();
	}
	
	public WebElement getwelcomeText()
	{
		return welcometext;
	}
}
