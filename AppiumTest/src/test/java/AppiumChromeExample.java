package test.java;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AppiumChromeExample {
	WebDriver driver;
	WebDriverWait wait;
	String AppURL = "http://www.seleniumeasy.com";

	@BeforeTest
	public void setup() throws MalformedURLException {

		// Create an object for Desired Capabilities
		DesiredCapabilities capabilities = new DesiredCapabilities();

		// Name of mobile web browser to automate. ‘Safari’ for iOS and ‘Chrome’
		// or ‘Browser’ for Android
		capabilities.setCapability("browsername", "chrome");

		// The kind of mobile device or emulator to use - iPad Simulator, iPhone
		// Retina 4-inch, Android Emulator, Galaxy S4 etc
		capabilities.setCapability("deviceName", "FAAZCY27Z980");

		// Which mobile OS platform to use - iOS, Android, or FirefoxOS
		capabilities.setCapability("platformName", "Android");

		// Java package of the Android app you want to run- Ex:
		// com.example.android.myApp
		capabilities.setCapability("appPackage", "com.android.chrome");
		
		capabilities.setCapability(CapabilityType.VERSION, "6.0.1");

		// Activity name for the Android activity you want to launch from your
		// package
		capabilities.setCapability("appActivity", "com.google.android.apps.chrome.Main");

		// Initialize the driver object with the URL to Appium Server and
		// passing the capabilities
		driver = new RemoteWebDriver(new URL("http://127.0.0.1:4444/wd/hub"), capabilities);
		wait = new WebDriverWait(driver, 5);
	}

	@Test
	public void testSearchAppium() {
		driver.get(AppURL);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		driver.wait(2000);
/*		WebElement titleElement = driver.findElement(By.cssSelector("#site-name>a"));
		String homePageTitle = titleElement.getText();
		Assert.assertEquals(homePageTitle, "Selenium Easy");

		WebElement searchElement = driver.findElement(By.name("search_block_form"));
		searchElement.sendKeys("Appium Tutorials");

		WebElement searchBtnEle = driver.findElement(By.id("edit-submit"));
		searchBtnEle.click();

		By byPageTitle = By.id("page-title");
		wait.until(ExpectedConditions.presenceOfElementLocated(byPageTitle));

		String searchPageTitle = driver.findElement(byPageTitle).getText();
		Assert.assertEquals(searchPageTitle, "Search");*/
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}