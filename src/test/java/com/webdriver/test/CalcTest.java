package com.webdriver.test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalcTest {

	private WebDriver driver;
	private WebElement tfNumber1;
	private WebElement tfNumber2;
	private WebElement tfTotal;
	

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/home/antonio/dev/drivers/chromedriver");
		driver = new ChromeDriver();
		driver.get("http://antoniotrindade.com.br/treinoautomacao/desafiosoma.html");
		
		tfNumber1 = driver.findElement(By.id("number1"));
		tfNumber2 = driver.findElement(By.id("number2"));
		tfTotal = driver.findElement(By.id("total"));
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
	
	@Test
	public void shouldSumValues() throws InterruptedException {
		Float value1 = 12f;
		Float value2 = 3.5f;
		
		Float total = value1 + value2;
		
		tfNumber1.sendKeys(Float.toString(value1));
		tfNumber2.sendKeys(Float.toString(value2));
		
		WebElement btnSum = driver.findElement(By.id("somar"));
		btnSum.click();
		
		Thread.sleep(3000);		
		assertEquals(Float.toString(total), tfTotal.getAttribute("value"));		
	}
	
	@Test
	public void shouldSubtractValues() throws InterruptedException {
		Float value1 = 20f;
		Float value2 = 3.5f;
		
		Float total = value1 - value2;
		
		tfNumber1.sendKeys(Float.toString(value1));
		tfNumber2.sendKeys(Float.toString(value2));
		
		WebElement btnSubtract = driver.findElement(By.id("subtrair"));
		btnSubtract.click();
		
		Thread.sleep(3000);	
		assertEquals(Float.toString(total), tfTotal.getAttribute("value"));		
	}
	
	@Test
	public void shouldMultiplicationValues() throws InterruptedException {
		Float value1 = 20f;
		Float value2 = 3.5f;
		
		Float total = value1 * value2;
		
		tfNumber1.sendKeys(Float.toString(value1));
		tfNumber2.sendKeys(Float.toString(value2));
		
		WebElement btnMultiplication = driver.findElement(By.id("multiplicar"));
		btnMultiplication.click();
		
		Thread.sleep(3000);	
		assertEquals(Float.toString(total), tfTotal.getAttribute("value"));
	}
}
