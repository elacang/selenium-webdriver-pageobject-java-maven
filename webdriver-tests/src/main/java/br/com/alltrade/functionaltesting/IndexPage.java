package br.com.alltrade.functionaltesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IndexPage extends PageObject {

	private WebElement profileWidget = getElementByClass("profile-widget");
	private WebElement logoutLink = getElementByCssSelector("a[href='/CenterWeb/authentication/logoff']");

	public IndexPage(WebDriver driver) {
		super(driver);
	}

	public void logout() {
		profileWidget.click();
		logoutLink.click();
	}

}
