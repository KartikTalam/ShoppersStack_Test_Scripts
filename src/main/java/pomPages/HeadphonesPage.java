package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeadphonesPage {
	
	//DECLARATION
	@FindBy(xpath = "//span[text()='BOSE HEADPHONES']")
	private WebElement itemName;
	
	@FindBy(xpath = "//span[text()='BOSE HEADPHONES']/ancestor::div[@class='featuredProducts_footerLeft__iP3CQ']/following-sibling::div/button")
	private WebElement addToCartButton;
	
	@FindBy(xpath = "//*[name()='svg'][@id='cartIcon']")
	private WebElement cartIcon;
	
	//INITIALIZATION
	public HeadphonesPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//UTILIZATION
	public String getItemName()
	{
		return itemName.getText();
	}
	
	public String getAddToCartText()
	{
		return addToCartButton.getText();
	}
	
	public void clickAddToCartButton()
	{
		addToCartButton.click();
	}
	
	public void clickCartIcon()
	{
		cartIcon.click();
	}
}
