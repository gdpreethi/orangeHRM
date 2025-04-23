package com.framework.selenium.api.base;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.testng.AbstractTestNGCucumberTests;


public class DriverInstance  extends AbstractTestNGCucumberTests{

	private static final ThreadLocal<RemoteWebDriver> remoteWebdriver = new ThreadLocal<RemoteWebDriver>();
	private static final ThreadLocal<WebDriverWait> wait = new  ThreadLocal<WebDriverWait>();

	public void setWait() {
		wait.set(new WebDriverWait(getDriver(), Duration.ofSeconds(10)));
	}

	public WebDriverWait getWait() {
		return wait.get();
	}

	public void setDriver(String browser, boolean headless) {	
		try {
		URL gridUrl = new URL("http://localhost:4444/wd/hub");
		 MutableCapabilities capabilities = null;
		switch (browser) {
		case "chrome":
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized"); 
			options.addArguments("--disable-notifications"); 
			options.addArguments("--incognito");
			capabilities=options;
			//remoteWebdriver.set(new ChromeDriver(options));
			break;
		case "firefox":
			//remoteWebdriver.set(new FirefoxDriver());
			 FirefoxOptions firefoxOptions = new FirefoxOptions();
             if (headless) {
                 firefoxOptions.addArguments("--headless");
             }
             capabilities = firefoxOptions;
			break;
		case "edge":
			//remoteWebdriver.set(new EdgeDriver());
			EdgeOptions edgeOptions = new EdgeOptions();
            if (headless) {
                edgeOptions.addArguments("--headless=new");
            }
            capabilities = edgeOptions;
			break;	
		case "ie":
			//remoteWebdriver.set(new InternetExplorerDriver());
			capabilities = new InternetExplorerOptions();
		default:
			break;
		}
		 remoteWebdriver.set(new RemoteWebDriver(gridUrl, capabilities));
		}catch(MalformedURLException e) {}
	}
	public RemoteWebDriver getDriver() {
		return remoteWebdriver.get();
	}
	
}
