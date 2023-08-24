package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	//DECLARATION
	@FindBy(xpath = "//button[text()='Shopper Login']")
	private WebElement shopperLoginLink;
	
	@FindBy(xpath = "//button[text()='Merchant Login']")
	private WebElement merchantLoginLink;
	
	@FindBy(xpath = "//button[text()='Admin Login']")
	private WebElement adminLoginLink;
	
	@FindBy(id="Email")
	private WebElement emailTF;
	
	@FindBy(id="Password")
	private WebElement passwordTF;
	
	@FindBy(xpath = "//span[text()='Login']")
	private WebElement loginButton;
	
	@FindBy(xpath = "//span[text()='Create Account']")
	private WebElement createAccountButton;
	
	@FindBy(linkText = "Forgot Password?")
	private WebElement forgotPasswordLink;
	
	//INITIALIZATION
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//UTILIZATION
	public void clickCreateAccount()
	{
		createAccountButton.click();
	}
	
	public void loginDetails(String emailID, String password)
	{
		emailTF.sendKeys(emailID);
		passwordTF.sendKeys(password);
	}
	
	public void clickLoginButton()
	{
		loginButton.click();
	}
}
