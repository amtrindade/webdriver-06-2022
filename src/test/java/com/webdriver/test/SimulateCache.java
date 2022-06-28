package com.webdriver.test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.webdriver.inter.NegativeInterface;

public class SimulateCache {

	private WebDriver driver;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/home/antonio/dev/drivers/chromedriver");
		driver = new ChromeDriver();
		driver.get("http://antoniotrindade.com.br/treinoautomacao");		
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
	
	@Test
	@Category(NegativeInterface.class)
	public void shouldBeNavigationCacheBrowser() {
		assertEquals("Treino Automação de Testes", driver.getTitle());
		
		WebElement menuCalc = driver.findElement(By.linkText("Calculadora"));
		menuCalc.click();		
		assertEquals("Desafio Automação Cálculos", driver.getTitle());
		
		WebElement menuTable = driver.findElement(By.linkText("Localizar Table"));
		menuTable.click();
		assertEquals("Trabalhando com tables", driver.getTitle());
		
		driver.navigate().back();
		assertEquals("Desafio Automação Cálculos", driver.getTitle());
		
		driver.navigate().back();
		assertEquals("Treino Automação de Testes", driver.getTitle());
		
		driver.navigate().forward();
		assertEquals("Desafio Automação Cálculos", driver.getTitle());
		
		driver.navigate().forward();
		assertEquals("Trabalhando com tables", driver.getTitle());	
	}
	
}
