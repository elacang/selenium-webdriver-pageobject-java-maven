package br.com.hexsel.functionaltesting.pages;

import org.openqa.selenium.WebDriver;

import br.com.hexsel.functionaltesting.core.PageElement;
import br.com.hexsel.functionaltesting.core.PageObject;

public class IndexPage extends PageObject {

	private PageElement profileWidget = getElementByClass("profile-widget");
	private PageElement logoutLink = getElementByCssSelector("a[href='/CenterWeb/authentication/logoff']");
	private PageElement itemLink = getElementByCssSelector("a[href='/CenterWeb/item']");

	public IndexPage(WebDriver driver) {
		super(driver);
	}

	public void logout() {
		profileWidget.click();
		logoutLink.click();
	}

	public ItemListPage goToItems() {
		itemLink.click();
		return new ItemListPage(getWebDriver());
	}

}
