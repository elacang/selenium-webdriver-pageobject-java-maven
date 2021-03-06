package br.com.hexsel.functionaltesting.pages;

import org.openqa.selenium.WebDriver;

import br.com.hexsel.functionaltesting.configuration.ConfigurationProperties;
import br.com.hexsel.functionaltesting.core.PageElement;
import br.com.hexsel.functionaltesting.core.PageObject;

public class LoginPage extends PageObject {

	private PageElement txtUsername;
	private PageElement txtPassword;
	private PageElement loginButton;

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public LoginPage open() {
		goToURL(ConfigurationProperties.getConfigurations().getBaseAppUrl());

		txtUsername = getElementById("username_tela");
		txtPassword = getElementById("password_tela");
		loginButton = getElementById("submit_button");

		return this;
	}

	private void clearUsernameAndPassword() {
		txtUsername.sendKeys("");
		txtPassword.sendKeys("");
	}

	public IndexPage login(String user, String password) {
		clearUsernameAndPassword();
		txtUsername.sendKeys(user);
		txtPassword.sendKeys(password);
		loginButton.click();
		return new IndexPage(getWebDriver());
	}

	public IndexPage login() {
		clearUsernameAndPassword();
		txtUsername.sendKeys(USER);
		txtPassword.sendKeys(PASSWORD);
		loginButton.click();
		return new IndexPage(getWebDriver());
	}

}
