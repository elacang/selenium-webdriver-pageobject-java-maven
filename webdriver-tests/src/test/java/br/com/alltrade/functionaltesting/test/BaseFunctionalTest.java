package br.com.alltrade.functionaltesting.test;

import static br.com.hexsel.functionaltesting.configuration.ConfigurationProperties.WEBDRIVER_CHROME_DRIVER;
import static br.com.hexsel.functionaltesting.configuration.ConfigurationProperties.getConfigurations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;

import br.com.hexsel.functionaltesting.pages.LoginPage;

public class BaseFunctionalTest {

	protected WebDriver webDriver;

	protected LoginPage loginPage;

	@BeforeMethod
	public void setup() {
		if (webDriver == null) {
			System.setProperty(WEBDRIVER_CHROME_DRIVER, getConfigurations().getWebDriverLocation());

			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			capabilities.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
			webDriver = new ChromeDriver(capabilities);
			loginPage = new LoginPage(webDriver);
		}
	}

	public void closeWindow() {
		webDriver.quit();
	}

}
