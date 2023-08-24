package testScripts;

import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericLibraries.BaseClass;

public class AddToCartTest extends BaseClass{
	
	@Test
	public void addToCartTest() throws Exception
	{
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(welcome.getwelcomeText().isDisplayed(), "WELCOME TEXT NOT FOUND");
		
		welcome.clickLoginButton();
		
		Map<String, String> loginData = excel.getData("Sheet1", "Login Details");
		
		login.loginDetails(loginData.get("Email"), loginData.get("Password"));
		login.clickLoginButton();
		
		Thread.sleep(2000);
		
		softAssert.assertTrue(home.getAccountSettings().isDisplayed(), "ACCOUNT SETTINGS ELEMENT NOT FOUND");
		
		home.mouseHoverToElectronics(webUtil);
		Thread.sleep(1000);
		
		home.clickHeadphones();
		
		headphones.clickAddToCartButton();
		Thread.sleep(1000);
		
		softAssert.assertEquals(headphones.getAddToCartText(), "ADDED");
		
		String itemName = headphones.getItemName();
		
		headphones.clickCartIcon();
		
		softAssert.assertTrue(cart.getCartItem().equalsIgnoreCase(itemName));
		
		softAssert.assertAll();
	}
}
