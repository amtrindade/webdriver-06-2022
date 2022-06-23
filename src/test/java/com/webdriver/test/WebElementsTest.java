package com.webdriver.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
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
	
	@Test
	public void testListMultiSelect() throws InterruptedException {
		WebElement dropMulti = driver.findElement(By.name("multiselectdropdown"));
		Select selectMulti = new Select(dropMulti);
		
		selectMulti.selectByValue("item5");
		selectMulti.selectByVisibleText("Item 8");
		selectMulti.selectByVisibleText("Item 9");
		
		selectMulti.selectByVisibleText("Item 10");
		selectMulti.deselectByVisibleText("Item 10");
		
		Thread.sleep(3000);
		List<WebElement> listSelected = selectMulti.getAllSelectedOptions();
		
		assertEquals(3, listSelected.size());
		
		assertEquals("Item 5", listSelected.get(0).getText());
		assertEquals("Item 8", listSelected.get(1).getText());
		assertEquals("Item 9", listSelected.get(2).getText());
		
		selectMulti.deselectByVisibleText("Item 8");
		
		listSelected = selectMulti.getAllSelectedOptions();
		
		assertEquals(2, listSelected.size());
		
		assertEquals("Item 5", listSelected.get(0).getText());
		assertEquals("Item 9", listSelected.get(1).getText());		
		
	}
	
	@Test
	public void testAlert() {
		WebElement btnAlert = driver.findElement(By.name("alertbtn"));
		btnAlert.click();
		
		Alert alert = driver.switchTo().alert();
		
		assertEquals("Eu sou um alerta!", alert.getText());
		alert.accept();
	}
	
	@Test
	public void testPromptOk() throws InterruptedException {
		WebElement btnPrompt = driver.findElement(By.id("promptBtn"));
		btnPrompt.click();
		
		Alert prompt = driver.switchTo().alert();
		assertEquals("Digite o ano:", prompt.getText());
		prompt.accept();
		
		Thread.sleep(1000);
		
		Alert confirm = driver.switchTo().alert();
		assertEquals("O ano é ?", confirm.getText());
		confirm.accept();
		
		Thread.sleep(1000);
		
		Alert alert = driver.switchTo().alert();
		assertEquals("Feito!", alert.getText());		
		alert.accept();
	}
	
	@Test
	public void testIFrame() {
		//Entra no iframe
		driver.switchTo().frame("frame1");
		
		WebElement tfText =  driver.findElement(By.id("tfiframe"));
		tfText.sendKeys("Água");
		
		assertEquals("Água", tfText.getAttribute("value"));
		
		WebElement btnIframe = driver.findElement(By.id("btniframe"));
		btnIframe.click();
				
		Alert alert = driver.switchTo().alert();
		assertEquals("Click OK!", alert.getText());
		alert.accept();

		//Volta para origem
		driver.switchTo().defaultContent();
		
		WebElement btnAlert = driver.findElement(By.name("alertbtn"));
		btnAlert.click();
		
		Alert alert1 = driver.switchTo().alert();
		assertEquals("Eu sou um alerta!", alert1.getText());
		
	}
}
