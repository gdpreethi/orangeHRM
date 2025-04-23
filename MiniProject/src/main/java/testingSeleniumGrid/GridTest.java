package testingSeleniumGrid;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
public class GridTest {
	@Test
	public void verifyPageTitle() throws MalformedURLException {
       // Create ChromeOptions object to set browser-specific capabilities
       ChromeOptions options = new ChromeOptions();
    // (Optional) You can add arguments or capabilities if needed
      // options.addArguments("--headless"); // Example: run Chrome in headless mode
       // Initialize the RemoteWebDriver with Grid URL and Chrome options
       WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444"), options);
		driver.get("https://www.google.com/");
		
		//Get page title
		String actual= driver.getTitle();
		String expected = "Google";
		
		//Assert that the page title matches with the expected title
		Assert.assertEquals(actual, expected,"Page title does not match!");
		
		//Clean up
		driver.quit();
	}
}