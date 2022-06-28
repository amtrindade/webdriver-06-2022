package com.webdriver.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.webdriver.inter.NegativeInterface;
import com.webdriver.inter.PositiveInterface;

public class NavigationTabs {

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
	@Category({PositiveInterface.class, NegativeInterface.class})
	public void testNavigationTabs() throws InterruptedException {
		
		assertEquals("Treino Automação de Testes", driver.getTitle());
		
		WebElement linkDragAndDrop = driver.findElement(By.linkText("Drag and Drop"));
		linkDragAndDrop.click();
		
		Thread.sleep(3000);
		
		WebElement linkGerador = driver.findElement(By.partialLinkText("Gerador"));
		linkGerador.click();
		
		Thread.sleep(3000);
		
		//monta o array com as tabs que estão abertas
		ArrayList<String> tabs = 
				new ArrayList<String>(driver.getWindowHandles());
		
		//navegar para tab2
		driver.switchTo().window(tabs.get(2));		
		assertEquals("Mootools Drag and Drop Example", driver.getTitle());
						
		//navegar para tab1
		driver.switchTo().window(tabs.get(1));		
		assertEquals("Gerador de CPF", driver.getTitle());
		
		driver.switchTo().window(tabs.get(0));
		assertEquals("Treino Automação de Testes", driver.getTitle());
	
	}
}
