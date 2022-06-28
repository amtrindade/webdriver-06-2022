package com.webdriver.test;

import static com.webdriver.core.DriverFactory.getDriver;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.webdriver.core.BaseTest;
import com.webdriver.inter.NegativeInterface;
import com.webdriver.inter.PositiveInterface;

public class RegularExpressionTest extends BaseTest{

	@Before
	public void setUp() throws Exception {
		getDriver().get("https://www.geradordecpf.org/");		
	}

	@Test
	@Category(NegativeInterface.class)
	public void shouldValidadeteMaskCPF() {
		WebElement checkDot = getDriver().findElement(By.id("cbPontos"));
		checkDot.click();
		
		WebElement btnGerar = getDriver().findElement(By.id("btn-gerar-cpf"));
		btnGerar.click();
		
		WebElement tfCPF = getDriver().findElement(By.id("numero"));
		
		String cpfValue = tfCPF.getAttribute("value");
		System.out.println(cpfValue);
		
		assertTrue(cpfValue.matches("^[0-9]{3}\\.[0-9]{3}\\.[0-9]{3}\\-[0-9]{2}$"));				
	}
	
	@Test
	@Category(PositiveInterface.class)
	public void shouldValidadeteWithoutMaskCPF() {		
		WebElement btnGerar = getDriver().findElement(By.id("btn-gerar-cpf"));
		btnGerar.click();
		
		WebElement tfCPF = getDriver().findElement(By.id("numero"));
		
		String cpfValue = tfCPF.getAttribute("value");
		System.out.println(cpfValue);
		
		assertTrue(cpfValue.matches("^\\d{11}$"));
	}

}
