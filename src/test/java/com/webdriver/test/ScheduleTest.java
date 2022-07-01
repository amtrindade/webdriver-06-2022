package com.webdriver.test;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.webdriver.core.BaseTest;
import com.webdriver.page.LoginPage;
import com.webdriver.page.MainPage;
import com.webdriver.page.ScheduleSearchPage;

public class ScheduleTest extends BaseTest {
	
	public LoginPage loginPage;
	public MainPage mainPage;
	public ScheduleSearchPage scheduleSearchPage;
	
	@Before
	public void setUp() {
		loginPage = new LoginPage();
		
		mainPage = loginPage.open()
			.sendEnvironment("trindade")
			.sendUser("aluno01")
			.sendPassword("colocarasenhaaqui")
			.accessSuccessfully();
	}
	
	@Test
	public void testSearchScheduleAgent() {
		scheduleSearchPage = mainPage.accessMenuTask();
		scheduleSearchPage.sendGenericSearch("Aluno 01");
		assertTrue(scheduleSearchPage.isTextExistInTable("Aluno 01"));
	}
	
	@Test
	public void testSearchScheduleLocal() {
		scheduleSearchPage = mainPage.accessMenuTask();
		scheduleSearchPage.sendGenericSearch("uMov.me");
		assertTrue(scheduleSearchPage.isTextExistInTable("uMov.me"));
	}
}
