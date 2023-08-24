package genericLibraries;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import pomPages.AddressFormPage;
import pomPages.CartPage;
import pomPages.HeadphonesPage;
import pomPages.HomePage;
import pomPages.LoginPage;
import pomPages.MyAddressPage;
import pomPages.MyProfilePage;
import pomPages.SignupPage;
import pomPages.WelcomePage;

public class BaseClass 
{
	
	//GENERIC LIBRARIES INSTANCES FOR BEFORE CLASS
	protected PropertiesUtility property;
	protected ExcelUtility excel;
	protected JavaUtility jutil;
	protected WebDriverUtility webUtil;
	public WebDriver driver;
	public static WebDriver sdriver;
	
	//POM PAGES INSTANCES FOR BEFORE METHOD
	protected AddressFormPage addressForm;
	protected CartPage cart;
	protected HeadphonesPage headphones;
	protected HomePage home;
	protected LoginPage login;
	protected MyAddressPage myAddress;
	protected MyProfilePage myProfile;
	protected SignupPage signup;
	protected WelcomePage welcome;
	
//	@BeforeSuite
//	@BeforeTest
	
	@BeforeClass
	public void classConfiguration()
	{
		property = new PropertiesUtility();
		property.propertiesInit(IConstatntPath.PROPERTIES_PATH);
		
		excel = new ExcelUtility();
		excel.excelInit(IConstatntPath.EXCEL_PATH);
		
		jutil = new JavaUtility();
		
		webUtil = new WebDriverUtility();
	}
	
	@BeforeMethod
	public void methodConfiguration()
	{
		driver = webUtil.navigateToApp(property.getData("browser"), property.getData("url"), Long.parseLong(property.getData("timeouts")));
		
		sdriver = driver;
		
		addressForm = new AddressFormPage(driver);
		cart = new CartPage(driver);
		headphones = new HeadphonesPage(driver);
		home = new HomePage(driver);
		login = new LoginPage(driver);
		myAddress = new MyAddressPage(driver);
		myProfile = new MyProfilePage(driver);
		signup = new SignupPage(driver);
		welcome = new WelcomePage(driver);
	}

	@AfterMethod
	public void methodTeardown()
	{
		home.clickAccountSettings();
		home.clickLogout();
		webUtil.closeAllBrowsers();
	}
	@AfterClass
	public void classTraedown()
	{
		excel.closeExcel();
	}
//	@AfterTest
//	@AfterSuite
}
