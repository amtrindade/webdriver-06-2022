package com.webdriver.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.webdriver.core.BaseTest;
import com.webdriver.page.LoginPage;
import com.webdriver.page.MainPage;

public class LoginTest extends BaseTest{
	
	public LoginPage loginPage;
	public MainPage mainPage;
	
	@Test
	public void testLoginValid() {
		loginPage = new LoginPage();
		loginPage.open();
		
		loginPage.sendEnvironment("trindade");
		loginPage.sendUser("aluno01");
		loginPage.sendPassword("coloqueasenhaaqui");
		
		mainPage = loginPage.accessSuccessfully();
		
		mainPage.openMenuAvatar();
		
		assertEquals("Aluno 01 (aluno01)", mainPage.getUserText());
	}
	
	@Test
	public void testLoginInvalid() {
		loginPage = new LoginPage();
		loginPage.open();
		
		loginPage.sendEnvironment("trindade");
		loginPage.sendUser("usuario");
		loginPage.sendPassword("coloqueasenhaaqui");
		
		loginPage.accessUnsuccessfully();
		assertEquals("ERRO\nLOGIN INVÁLIDO.", loginPage.getMessageError());
	}
}
