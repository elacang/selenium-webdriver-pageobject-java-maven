package br.com.hexsel.functionaltesting.core;

import static br.com.hexsel.functionaltesting.configuration.ConfigurationProperties.getConfigurations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageObject {

	private WebDriver webDriver;

	protected final String USER = getConfigurations().getTestsUser();
	protected final String PASSWORD = getConfigurations().getTestsPassword();

	public PageObject(WebDriver driver) {
		this.webDriver = driver;
	}

	public void goToURL(String url) {
		webDriver.navigate().to(url);
	}

	public PageElement getElementById(String id) {
		return new PageElement(By.id(id), webDriver);
	}

	public PageElement getElementByClass(String className) {
		return new PageElement(By.className(className), webDriver);
	}

	public PageElement getElementByLinkText(String linkText) {
		return new PageElement(By.linkText(linkText), webDriver);
	}

	public PageElement getElementByCssSelector(String selector) {
		return new PageElement(By.cssSelector(selector), webDriver);
	}

	public PageElement getElementByPartOfLinkText(String linkPart) {
		return new PageElement(By.partialLinkText(linkPart), webDriver);
	}

	public WebDriver getWebDriver() {
		return webDriver;
	}

	public String getCurrentUrl() {
		return webDriver.getCurrentUrl();
	}

}
