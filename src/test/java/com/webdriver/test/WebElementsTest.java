package com.webdriver.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;




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
		
		assertEquals(true, textName.getText());
		
	}
	
	@Test
	public void testDisplay() {
		WebElement textName = driver.findElement(By.name("txtbox1"));
		WebElement textDisplay = driver.findElement(By.name("txtbox2"));
				
		assertTrue("Deveria estar habilitado", textName.isEnabled());
	
		assertFalse("Deveria estar desabilitado", textDisplay.isEnabled());
			
	}
	
	@Test
	public void testRadioGroup() throws InterruptedException {
		List<WebElement> radios = driver.findElements(By.name("radioGroup1"));
		
		radios.get(1).click();
		radios.get(2).click();
		
		assertTrue(radios.get(2).isSelected());	
	}
	
	@Test
	public void testRadioGroupDinamic() throws InterruptedException {
		List<WebElement> radios = driver.findElements(By.name("radioGroup1"));
		
		for (WebElement rd : radios) {
			System.out.println(rd.getAttribute("value"));
			if (rd.getAttribute("value").equals("Radio 3")){
				rd.click();
				break;
			}				
		}
		assertTrue(radios.get(2).isSelected());	
	}
	
	@Test
	public void testCheckBox() throws InterruptedException {
		List<WebElement> checkboxes = driver.findElements(By.name("chkbox"));
		
		for (WebElement check : checkboxes) {
			if ((check.getAttribute("value").equals("Check 3")) || 
					(check.getAttribute("value").equals("Check 4"))){				
				check.click();
			}						
		}
		
		assertTrue(checkboxes.get(2).isSelected());
		assertTrue(checkboxes.get(3).isSelected());
		assertFalse(checkboxes.get(0).isSelected());
		assertFalse(checkboxes.get(1).isSelected());
		
	}
	
	@Test
	public void testListBoxSingle() {
		WebElement dropSingle = driver.findElement(By.name("dropdownlist"));
		Select selectSingle = new Select(dropSingle);
		
		selectSingle.selectByIndex(0);
		selectSingle.selectByVisibleText("Item 10");		
		selectSingle.selectByVisibleText("Item 7");
		
		WebElement valueSelect = selectSingle.getFirstSelectedOption(); 
		
		assertEquals("Item 7", valueSelect.getText());
		assertEquals("item7", valueSelect.getAttribute("value"));
	}
	
	
}
