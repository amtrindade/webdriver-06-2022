package com.webdriver.core;

import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverFactory {
	
	public static WebDriver driver = null;
	
	public static WebDriver getDriver() {
		
		String browser = GlobalProperty.getProperty("webdriver.browser");
		String path = GlobalProperty.getProperty("webdriver.path");
		
		if (driver == null) {
			
			if (browser.equals("chrome")) {
				System.setProperty("webdriver.chrome.driver", path + "chromedriver");
				driver = new ChromeDriver();
			}
			
			else if (browser.equals("chrome-headless")) {
				System.setProperty("webdriver.chrome.driver", path + "chromedriver");
				
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless");
				options.addArguments("--window-size=1366x960");
				
				driver = new ChromeDriver(options);
			}
			
			else if (browser.equals("firefox")) {
				System.setProperty("webdriver.gecko.driver", path + "geckodriver");
				driver = new FirefoxDriver();
			}
			
			else if (browser.equals("firefox-headless")) {
				System.setProperty("webdriver.gecko.driver", path + "geckodriver");
				
				FirefoxOptions options = new FirefoxOptions();
				options.addArguments("--headless");
				options.addArguments("--window-size=1366x960");
				
				driver = new FirefoxDriver(options);
			}
			else
				fail("Driver não foi especificado de acordo com as possibilidades!");
			
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		}		
		return driver;
	}
	
	public static void killDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}
	

}
