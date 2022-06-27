package com.webdriver.test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropTest {

	private WebDriver driver;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/home/antonio/dev/drivers/chromedriver");
		driver = new ChromeDriver();
		driver.get("https://jqueryui.com/resources/demos/droppable/default.html");		
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
	
	@Test
	public void shouldBeDragAndDrop() throws InterruptedException {
		WebElement origin = driver.findElement(By.id("draggable"));	
		WebElement destiny = driver.findElement(By.id("droppable"));		
		
		assertEquals("Drop here", destiny.getText());
				
		new Actions(driver).dragAndDrop(origin, destiny).perform();
				
		assertEquals("Dropped!", destiny.getText());		
	}
}
