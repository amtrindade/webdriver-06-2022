package com.webdriver.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class WebElementsTest {
	
	WebDriver driver;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/home/antonio/dev/drivers/chromedriver");
		driver = new ChromeDriver();
		driver.get("http://antoniotrindade.com.br/treinoautomacao/elementsweb.html");		
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void testSendName() throws InterruptedException {
		//Identifica o elemento 
		WebElement textName = driver.findElement(By.name("txtbox1"));
		
		//ação de enviar texto
		textName.sendKeys("Antônio");
				
		//Valido que o nome escrito é igual ao valor esperado
		assertEquals("Deveria ter escrito o nome", 
				"Antônio", textName.getAttribute("value"));
	}
	
	@Test
	public void testDisplay() {
		WebElement textName = driver.findElement(By.name("txtbox1"));
		WebElement textDisplay = driver.findElement(By.name("txtbox2"));
				
		assertTrue("Deveria estar habilitado", textName.isEnabled());
	
		assertFalse("Deveria estar desabilitado", textDisplay.isEnabled());
			
	}
}
