package genericLibraries;

import java.time.Duration;
import java.util.HashMap;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class WebDriverUtility {
	
	private WebDriver driver;
	
	public WebDriver navigateToApp(String browser, String url, long time)
	{
		switch(browser)
		{
		case "chrome":
			ChromeOptions option = new ChromeOptions();
			System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
			HashMap<String, Boolean> prefs = new HashMap<>();
			prefs.put("autofill.profile_enabled", false);
			option.setExperimentalOption("prefs", prefs);
			driver = new ChromeDriver(option);
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		default:
			System.out.println("INVALID BROWSER INFO");
		}
		
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
		
		return driver;
	}
	
	//HANDLLING WEBDRIVER WAIT STATEMENTS
	public WebElement explicitWait(WebElement element, long time)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public WebElement explicitWait(long time, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		return wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public Boolean explicitWait(String title, long time)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		return wait.until(ExpectedConditions.titleContains(title));
	}
	
	//HANDLLING MOUSE ACTIONS
	public void mouseHover(WebElement element)
	{
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}
	
	public void drightClick(WebElement element)
	{
		Actions action = new Actions(driver);
		action.contextClick(element).perform();
	}
	
	public void doubleClick(WebElement element)
	{
		Actions action = new Actions(driver);
		action.doubleClick(element).perform();
	}
	
	public void dragAndDrop(WebElement source, WebElement destination)
	{
		Actions action = new Actions(driver);
		action.dragAndDrop(source, destination).perform();
	}
	
	//HANDLLING DROPDOWN'S
	public void selectFromDropdown(WebElement element, int index)
	{
		Select select = new Select(element);
		select.selectByIndex(index);
	}
	
	public void selectFromDropdown(WebElement element, String value)
	{
		Select select = new Select(element);
		select.selectByValue(value);
	}
	
	public void selectFromDropdown(String visibleText, WebElement element)
	{
		Select select = new Select(element);
		select.selectByVisibleText(visibleText);
	}
	
	//HANDELLING FRAMES
	public void switchToFrame(int index)
	{
		driver.switchTo().frame(index);
	}
	
	public void switchToFrame(String nameOrID)
	{
		driver.switchTo().frame(nameOrID);
	}
	
	public void switchToFrame(WebElement element)
	{
		driver.switchTo().frame(element);
	}
	
	//SCROLLING ACTION
	public void scrollTillElement(WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
	}
	
	//HANDELLING POPUP'S
	public void handleAlert(String status)
	{
		Alert al = driver.switchTo().alert();
		if(status.equalsIgnoreCase("ok"))
		{
			al.accept();
		}
		else
		{
			al.dismiss();
		}
	}
	
	public void switchToChildBrowser()
	{
		Set<String> set = driver.getWindowHandles();
		for (String s : set)
		{
			driver.switchTo().window(s);
		}
	}
	
	public void switchToWindow(String id)
	{
		driver.switchTo().window(id);
	}
	
	public String getParentWindowID()
	{
		return driver.getWindowHandle();
	}
	
	public void closeSingleBrowser()
	{
		driver.close();
	}
	
	public void closeAllBrowsers()
	{
		driver.quit();
	}
}
