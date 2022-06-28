package com.webdriver.test;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegularExpressionTest {

	private WebDriver driver;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/home/antonio/dev/drivers/chromedriver");
		driver = new ChromeDriver();
		driver.get("https://www.geradordecpf.org/");		
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
	
	@Test
	public void shouldValidadeteMaskCPF() {
		WebElement checkDot = driver.findElement(By.id("cbPontos"));
		checkDot.click();
		
		WebElement btnGerar = driver.findElement(By.id("btn-gerar-cpf"));
		btnGerar.click();
		
		WebElement tfCPF = driver.findElement(By.id("numero"));
		
		String cpfValue = tfCPF.getAttribute("value");
		System.out.println(cpfValue);
		
		assertTrue(cpfValue.matches("^[0-9]{3}\\.[0-9]{3}\\.[0-9]{3}\\-[0-9]{2}$"));				
	}
	
	@Test
	public void shouldValidadeteWithoutMaskCPF() {		
		WebElement btnGerar = driver.findElement(By.id("btn-gerar-cpf"));
		btnGerar.click();
		
		WebElement tfCPF = driver.findElement(By.id("numero"));
		
		String cpfValue = tfCPF.getAttribute("value");
		System.out.println(cpfValue);
		
		assertTrue(cpfValue.matches("^\\d{11}$"));
	}

}
