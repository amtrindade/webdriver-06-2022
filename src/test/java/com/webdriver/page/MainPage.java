package com.webdriver.page;

import static com.webdriver.core.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MainPage {
	
	public MainPage openMenuAvatar() {
		WebElement imgAvatar = getDriver().findElement(By.xpath("//div[@class='topbar-widget profile-widget']/img"));
		imgAvatar.click();
		return this;
	}
	
	public String getUserText() {
		WebElement labelUser = getDriver().findElement(By.xpath("//span[@class='text-login']/.."));
		return labelUser.getText();
	}
	
	public ScheduleSearchPage accessMenuTask() {
		WebElement menuTask = getDriver().findElement(By.linkText("Tarefa"));
		menuTask.click();
		
		return new ScheduleSearchPage();
	}

}
