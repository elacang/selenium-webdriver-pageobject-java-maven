package br.com.hexsel.functionaltesting.test;

import org.testng.annotations.Test;

public class LoginTest extends BaseFunctionalTest {

	@Test
	public void testShouldAccessLoginPage() {
		loginPage.open();
	}

	@Test(dependsOnMethods = { "testShouldAccessLoginPage" })
	public void testShouldLoginAndLogoutSuccessfully() {
		loginPage.login().logout();
		closeWindow();
	}

}
