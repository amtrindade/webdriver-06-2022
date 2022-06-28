package com.webdriver.test;

import static com.webdriver.core.DriverFactory.getDriver;
import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.webdriver.core.BaseTest;
import com.webdriver.inter.PositiveInterface;

public class DragAndDropTest extends BaseTest {

	@Before
	public void setUp() throws Exception {
		getDriver().get("https://jqueryui.com/resources/demos/droppable/default.html");		
	}
	
	@Test
	@Category(PositiveInterface.class)
	public void shouldBeDragAndDrop() throws InterruptedException, IOException {
		WebElement origin = getDriver().findElement(By.id("draggable"));	
		WebElement destiny = getDriver().findElement(By.id("droppable"));		
		
		assertEquals("Drop here", destiny.getText());
		
		File scrnShot = 
				((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrnShot , new File("target/screenshots/before.jpg"));		

				
		new Actions(getDriver()).dragAndDrop(origin, destiny).perform();
				
		assertEquals("Dropped!", destiny.getText());		
		
		scrnShot = 
				((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrnShot , new File("target/screenshots/after.jpg"));
		
	}
}
