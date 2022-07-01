package com.webdriver.page;

import static com.webdriver.core.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage {

	public LoginPage open() {
		getDriver().get("https://center.umov.me/");
		return this;
	}
	
	public LoginPage sendEnvironment(String workspace) {
		WebElement tfWorkspace = getDriver().findElement(By.id("workspace"));
		tfWorkspace.sendKeys(workspace);
		return this;
	}

	public LoginPage sendUser(String user) {
		WebElement tfUser = getDriver().findElement(By.id("username"));
		tfUser.sendKeys(user);		 
		return this;		
	}
	
	public LoginPage sendPassword(String pass) {
		WebElement tfPass = getDriver().findElement(By.id("password"));
		tfPass.sendKeys(pass);
		return this;
	}
	
	public MainPage accessSuccessfully() {
		WebElement btnAccess = getDriver().findElement(By.id("submit_button"));
		btnAccess.click();
		return new MainPage();
	}
	
	public LoginPage accessUnsuccessfully() {
		WebElement btnAccess = getDriver().findElement(By.id("submit_button"));
		btnAccess.click();
		return this;
	}
	
	public String getMessageError() {
		WebElement messageError = getDriver().findElement(By.xpath("//li[@class='nm-li nm-message-error']"));
		return messageError.getText();		
	}

}
