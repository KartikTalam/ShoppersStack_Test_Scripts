package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericLibraries.WebDriverUtility;

public class AddressFormPage {
	
	//DECLARATION
	@FindBy(id="Name")
	private WebElement nameTF;
	
	@FindBy(id="House/Office Info")
	private WebElement houseInfoTF;
	
	@FindBy(id="Street Info")
	private WebElement streetInfoTF;
	
	@FindBy(id="Landmark")
	private WebElement landmarkTF;
	
	@FindBy(id="Country")
	private WebElement countryDropdown;
	
	@FindBy(id="State")
	private WebElement stateDropDown;
	
	@FindBy(id="City")
	private WebElement cityDropDown;
	
	@FindBy(id="Pincode")
	private WebElement pincodeTF;
	
	@FindBy(id="Phone Number")
	private WebElement phoneNumberTF;
	
	@FindBy(id="addAddress")
	private WebElement addAddressButton;
	
	//INITIALIZATION
	public AddressFormPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	//UTILIZATION
	public void addAddressDetails(WebDriverUtility web, String name, String houseInfo, String streetInfo, String landmark, String pincode, String phoneNumber, String country, String state, String city)
	{
		nameTF.sendKeys(name);
		houseInfoTF.sendKeys(houseInfo);
		streetInfoTF.sendKeys(streetInfo);
		landmarkTF.sendKeys(landmark);
		
		web.selectFromDropdown(country, countryDropdown);
		web.selectFromDropdown(state, stateDropDown);
		web.selectFromDropdown(city, cityDropDown);
		
		pincodeTF.sendKeys(pincode);
		phoneNumberTF.sendKeys(phoneNumber);
	}
	
	public void clickAddAddress()
	{
		addAddressButton.click();
	}
}
