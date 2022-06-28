package com.webdriver.test;

import static com.webdriver.core.DriverFactory.getDriver;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.webdriver.core.BaseTest;
import com.webdriver.inter.NegativeInterface;

public class SimulateCache extends BaseTest{

	@Before
	public void setUp() throws Exception {
		getDriver().get("http://antoniotrindade.com.br/treinoautomacao");		
	}

	@Test
	@Category(NegativeInterface.class)
	public void shouldBeNavigationCacheBrowser() {
		assertEquals("Treino Automação de Testes", getDriver().getTitle());
		
		WebElement menuCalc = getDriver().findElement(By.linkText("Calculadora"));
		menuCalc.click();		
		assertEquals("Desafio Automação Cálculos", getDriver().getTitle());
		
		WebElement menuTable = getDriver().findElement(By.linkText("Localizar Table"));
		menuTable.click();
		assertEquals("Trabalhando com tables", getDriver().getTitle());
		
		getDriver().navigate().back();
		assertEquals("Desafio Automação Cálculos", getDriver().getTitle());
		
		getDriver().navigate().back();
		assertEquals("Treino Automação de Testes", getDriver().getTitle());
		
		getDriver().navigate().forward();
		assertEquals("Desafio Automação Cálculos", getDriver().getTitle());
		
		getDriver().navigate().forward();
		assertEquals("Trabalhando com tables", getDriver().getTitle());	
	}
	
}
