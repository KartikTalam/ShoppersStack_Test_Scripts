package testScripts;

import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericLibraries.BaseClass;

//VERIFY USER IS ABLE TO ADD ADDRESS


public class AddAddressTest extends BaseClass{
	
	@Test
	public void loginShoppersStack() throws Exception
	{
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(welcome.getwelcomeText().isDisplayed(), "WELCOME TEXT NOT FOUND");
		
		welcome.clickLoginButton();
		
		Map<String, String> loginData = excel.getData("Sheet1", "Login Details");
		
		login.loginDetails(loginData.get("Email"), loginData.get("Password"));
		login.clickLoginButton();
		
		Thread.sleep(2000);
		
		softAssert.assertTrue(home.getAccountSettings().isDisplayed(), "ACCOUNT SETTINGS ELEMENT NOT FOUND");
		
		home.clickAccountSettings();
		Thread.sleep(1000);
		
		home.clickMyProfile();
		
		myProfile.clickMyAddresses();
		myAddress.clickAddAddress();
		
		Map<String, String> addAddressData = excel.getData("Sheet1", "Add Address");
		
		String country = "India";
		String state = "Telangana";
		String city = "Hyderabad";
		
		addressForm.addAddressDetails(webUtil, addAddressData.get("Name"), addAddressData.get("House/Office Info"), 
				addAddressData.get("Street Info"), addAddressData.get("Landmark"), 
				addAddressData.get("Pincode"), addAddressData.get("Phone Number"), country, state, city);
		
		Thread.sleep(2000);
		
		addressForm.clickAddAddress();
		
		Thread.sleep(2000);
		
		softAssert.assertTrue(myAddress.getSuccessMessage().contains("successfully added"));
		
		Thread.sleep(10000);
		
		softAssert.assertAll();
		
	}
}
