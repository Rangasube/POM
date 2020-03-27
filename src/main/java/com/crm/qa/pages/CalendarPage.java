package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;

public class CalendarPage extends TestBase{
	
	//Page Factory - OR
	@FindBy(xpath="//tr//tr//tr//tr//tr[2]//td[2]")
	WebElement event_Mon;
	@FindBy(xpath="//input[@id='title']")
	WebElement titleField;
	@FindBy(xpath="//body/table/tbody/tr/td/table/tbody/tr/td/fieldset[@class='fieldset']/form[@id='appForm']/table/tbody/tr/td[1]/input[1]")
	WebElement saveBtn;
	@FindBy(xpath="//select[@name='category']")
	WebElement category;
public CalendarPage(){
	PageFactory.initElements(driver,this);
}

@SuppressWarnings("deprecation")
public void hoverOnEvent() {
	new Actions(driver).moveToElement(new WebDriverWait(driver,5).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr//tr//tr//tr//tr[2]//td[2]")))).build().perform();
}
public void createNewEvent(String title, String cat) {
	titleField.sendKeys(title);
	Select select = new Select(category);
	select.selectByVisibleText(cat);
	saveBtn.click();
}
}
