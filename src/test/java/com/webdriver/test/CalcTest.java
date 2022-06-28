package com.webdriver.test;

import static com.webdriver.core.DriverFactory.getDriver;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.webdriver.core.BaseTest;
import com.webdriver.inter.NegativeInterface;
import com.webdriver.inter.PositiveInterface;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CalcTest extends BaseTest {

	private WebElement tfNumber1;
	private WebElement tfNumber2;
	private WebElement tfTotal;

	@Before
	public void setUp() throws Exception {				
		getDriver().get("http://antoniotrindade.com.br/treinoautomacao/desafiosoma.html");
		
		tfNumber1 = getDriver().findElement(By.id("number1"));
		tfNumber2 = getDriver().findElement(By.id("number2"));
		tfTotal = getDriver().findElement(By.id("total"));
	}
	
	@Test
	@Category(PositiveInterface.class)
	public void should1SumValues() throws InterruptedException {
		Float value1 = 12f;
		Float value2 = 3.5f;
		
		Float total = value1 + value2;
		
		tfNumber1.sendKeys(Float.toString(value1));
		tfNumber2.sendKeys(Float.toString(value2));
		
		WebElement btnSum = getDriver().findElement(By.id("somar"));
		btnSum.click();
		
		Thread.sleep(3000);		
		assertEquals(Float.toString(total), tfTotal.getAttribute("value"));		
	}
	
	@Test
	@Category(PositiveInterface.class)
	public void should2SubtractValues() throws InterruptedException {
		Float value1 = 20f;
		Float value2 = 3.5f;
		
		Float total = value1 - value2;
		
		tfNumber1.sendKeys(Float.toString(value1));
		tfNumber2.sendKeys(Float.toString(value2));
		
		WebElement btnSubtract = getDriver().findElement(By.id("subtrair"));
		btnSubtract.click();
		
		Thread.sleep(3000);	
		assertEquals(Float.toString(total), tfTotal.getAttribute("value"));		
	}
	
	@Ignore("Ajustar arredondamento de valores float")
	@Test
	@Category(NegativeInterface.class)
	public void should3MultiplicationValues() throws InterruptedException {
		Float value1 = 20f;
		Float value2 = 3.5f;
		
		Float total = value1 * value2;
		
		tfNumber1.sendKeys(Float.toString(value1));
		tfNumber2.sendKeys(Float.toString(value2));
		
		WebElement btnMultiplication = getDriver().findElement(By.id("multiplicar"));
		btnMultiplication.click();
		
		Thread.sleep(3000);	
		assertEquals(Float.toString(total), tfTotal.getAttribute("value"));
	}
}
