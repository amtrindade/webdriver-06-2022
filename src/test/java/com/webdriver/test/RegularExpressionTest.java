package com.webdriver.test;

import static com.webdriver.core.DriverFactory.getDriver;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	
	@Test
	public void testValidateCnpjWithMask() throws InterruptedException {
		getDriver().get("https://www.4devs.com.br/gerador_de_cnpj");
		
		WebElement checkYes = getDriver().findElement(By.id("pontuacao_sim"));
		if (!checkYes.isSelected()) {
			checkYes.click();
		}
		
		WebElement btnGenereateCnpj = getDriver().findElement(By.id("bt_gerar_cnpj"));
		btnGenereateCnpj.click();
		
		
		WebElement labelCnpj = getDriver().findElement(By.id("texto_cnpj"));
		
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		wait.until(ExpectedConditions
				.invisibilityOfElementWithText(By.id("texto_cnpj"), "Gerando..."));
		
		
		String cnpj = labelCnpj.getText();
		System.out.println(cnpj);
		
		assertTrue(cnpj.matches("^\\d{2}\\.\\d{3}\\.\\d{3}/\\d{4}-\\d{2}$"));
	}

}
