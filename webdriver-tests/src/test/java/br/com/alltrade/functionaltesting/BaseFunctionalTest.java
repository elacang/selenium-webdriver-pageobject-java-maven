package br.com.alltrade.functionaltesting;

import static br.com.alltrade.functionaltesting.configuration.ConfigurationProperties.WEBDRIVER_CHROME_DRIVER;
import static br.com.alltrade.functionaltesting.configuration.ConfigurationProperties.getConfigurations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseFunctionalTest {

	protected static WebDriver webDriver;

	@BeforeClass
	public static void setupWebDriver() {
		System.setProperty(WEBDRIVER_CHROME_DRIVER, getConfigurations().getWebDriverLocation());

		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
		webDriver = new ChromeDriver(capabilities);
	}

	@AfterClass
	public static void dispose() {
		webDriver.quit();
	}

}
