package br.com.alltrade.functionaltesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.com.alltrade.functionaltesting.configuration.ConfigurationProperties;

public class PageObject {

	private WebDriver webDriver;

	protected final String USER = ConfigurationProperties.getConfigurations().getTestsUser();
	protected final String PASSWORD = ConfigurationProperties.getConfigurations().getTestsPassword();

	public PageObject(WebDriver driver) {
		this.webDriver = driver;
	}

	public void goToURL(String url) {
		webDriver.navigate().to(url);
	}

	public WebElement getElementById(String id) {
		return webDriver.findElement(By.id(id));
	}

	public WebElement getElementByClass(String className) {
		return webDriver.findElement(By.className(className));
	}

	public WebElement getElementByLinkText(String linkText) {
		return webDriver.findElement(By.linkText(linkText));
	}

	public WebElement getElementByCssSelector(String selector) {
		return webDriver.findElement(By.cssSelector(selector));
	}

	public WebElement getElementByPartOfLinkText(String linkPart) {
		return webDriver.findElement(By.partialLinkText(linkPart));
	}

	public WebDriver getWebDriver() {
		return webDriver;
	}

	public String getCurrentUrl() {
		return webDriver.getCurrentUrl();
	}

}
