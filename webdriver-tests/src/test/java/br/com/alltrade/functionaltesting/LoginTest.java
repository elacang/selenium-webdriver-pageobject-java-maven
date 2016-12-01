package br.com.alltrade.functionaltesting;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseFunctionalTest {

	private LoginPage loginPage;

	@BeforeMethod
	public void setup() {
		loginPage = new LoginPage(webDriver);
	}

	@Test
	public void testShouldAccessLoginPage() {
		loginPage.open();
	}

	@Test(dependsOnMethods = { "testShouldAccessLoginPage" })
	public void testShouldLoginAndLogoutSuccessfully() {
		loginPage.open().login().logout();
	}

}
