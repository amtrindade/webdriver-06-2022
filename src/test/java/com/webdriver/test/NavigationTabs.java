package com.webdriver.test;

import static com.webdriver.core.DriverFactory.getDriver;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.webdriver.core.BaseTest;
import com.webdriver.inter.NegativeInterface;
import com.webdriver.inter.PositiveInterface;

public class NavigationTabs extends BaseTest{

	@Before
	public void setUp() throws Exception {
		getDriver().get("http://antoniotrindade.com.br/treinoautomacao");		
	}
	
	@Test
	@Category({PositiveInterface.class, NegativeInterface.class})
	public void testNavigationTabs() throws InterruptedException {
		
		assertEquals("Treino Automação de Testes", getDriver().getTitle());
		
		WebElement linkDragAndDrop = getDriver().findElement(By.linkText("Drag and Drop"));
		linkDragAndDrop.click();
		
		Thread.sleep(3000);
		
		WebElement linkGerador = getDriver().findElement(By.partialLinkText("Gerador"));
		linkGerador.click();
		
		Thread.sleep(3000);
		
		//monta o array com as tabs que estão abertas
		ArrayList<String> tabs = 
				new ArrayList<String>(getDriver().getWindowHandles());
		
		//navegar para tab2
		getDriver().switchTo().window(tabs.get(2));		
		assertEquals("Mootools Drag and Drop Example", getDriver().getTitle());
						
		//navegar para tab1
		getDriver().switchTo().window(tabs.get(1));		
		assertEquals("Gerador de CPF", getDriver().getTitle());
		
		getDriver().switchTo().window(tabs.get(0));
		assertEquals("Treino Automação de Testes", getDriver().getTitle());
	
	}
}
