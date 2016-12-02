package br.com.hexsel.functionaltesting.core;

import static org.openqa.selenium.support.ui.ExpectedConditions.and;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOfElementLocated;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageElement {

	private WebElement element;

	private By by;

	private WebDriver webDriver;

	public PageElement(By by, WebDriver webDriver) {
		this.by = by;
		this.webDriver = webDriver;
		this.element = webDriver.findElement(by);
	}

	private void waitElement() {
		WebDriverWait wait = new WebDriverWait(webDriver, 10);
		wait.until(and(invisibilityOfElementLocated(By.id("div_loading")), elementToBeClickable(by)));
	}

	public void click() {
		waitElement();
		element.click();
	}

	public void clickWithNoWait() {
		element.click();
	}

	public void sendKeys(String str) {
		waitElement();
		element.sendKeys(str);
	}

	public void clear() {
		waitElement();
		element.clear();
	}

}
