package br.com.hexsel.functionaltesting.test;

import org.testng.annotations.Test;

public class ItemTest extends BaseFunctionalTest {

	@Test
	public void shouldEnterInItemList() {
		loginPage.open().login().goToItems();
		closeWindow();
	}

}
