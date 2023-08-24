package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignupPage {
	
	//DECLARATION
	@FindBy(id="First Name")
	private WebElement firstNameTF;
	
	@FindBy(id="Last Name")
	private WebElement lastNameTF;
	
	@FindBy(id="Male")
	private WebElement maleRB;
	
	@FindBy(id="Phone Number")
	private WebElement phoneNumberTF;
	
	@FindBy(id="Email Address")
	private WebElement emailTF;
	
	@FindBy(id="Password")
	private WebElement passwordTF;
	
	@FindBy(id="Confirm Password")
	private WebElement confirmPasswordTF;
	
	@FindBy(id="Terms and Conditions")
	private WebElement termsConditionsCB;
	
	@FindBy(id="btnDisabled")
	private WebElement registerButton;
	
	//INITIALIZATION
	public SignupPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//UTILIZATION
	public void createUserAccount(String FirstName, String LastName, String PhoneNmber, String EmailID, String Password, String ConfirmPassword)
	{
		firstNameTF.sendKeys(FirstName);
		lastNameTF.sendKeys(LastName);
		maleRB.click();
		phoneNumberTF.sendKeys(PhoneNmber);
		emailTF.sendKeys(EmailID);
		passwordTF.sendKeys(Password);
		confirmPasswordTF.sendKeys(ConfirmPassword);
		termsConditionsCB.click();
	}
	
	public void clickRegister()
	{
		registerButton.click();
	}
}
