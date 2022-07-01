package com.webdriver.page;

import static com.webdriver.core.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ScheduleSearchPage {

	public ScheduleSearchPage sendGenericSearch(String value) {
		WebElement btnClear = getDriver().findElement(By.id("scheduleList_doClear"));
		btnClear.click();
		
		WebElement tfSearch = getDriver().findElement(By.id("genericFilter"));
		tfSearch.sendKeys(value);
		
		WebElement btnSearch = getDriver().findElement(By.id("scheduleList_doSearch"));
		btnSearch.click();
		
		return this;
	}
	
	public Boolean isTextExistInTable(String value) {
		WebElement line = getDriver().findElement(By.xpath("//table//a[contains(text(), '"+value+"')]"));
		return line.isDisplayed();
	}
	
}
