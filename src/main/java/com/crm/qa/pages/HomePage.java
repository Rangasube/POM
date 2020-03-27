package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{

	//Page Factory - OR
	@FindBy(xpath = "/html[1]/body[1]/table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[1]/td[1]")
	WebElement usernameLabel;
	@FindBy(xpath="/html[1]/body[1]/table[1]/tbody[1]/tr[2]/td[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]")
	WebElement logoText;
	@FindBy(xpath="//a[contains(text(),'Calendar')]")
	WebElement calendarLink;
	@FindBy(xpath="//a[contains(text(),'New Event')]")
	WebElement newEvent;
	@FindBy(xpath="//a[contains(text(),'Companies')]")
	WebElement companiesLink;
	@FindBy(xpath="//a[contains(text(),'New Company')]")
	WebElement newCompany;
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement newContactLink;
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement dealsLink;
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement tasksLink;

//constructor to initialize the page objects
public HomePage() {
	PageFactory.initElements(driver, this);
}
public String validateHomePageTitle() {
	return driver.getTitle();
}
public boolean validateusernameLabel() {
	return usernameLabel.isDisplayed();
}
public boolean validateLogoText() {
	return logoText.isDisplayed();
}
public CalendarPage clickOnCalendarLink() {
	calendarLink.click();
	return new CalendarPage();
}
@SuppressWarnings("deprecation")
public void clickOnCalendarNewEvent() {
	new Actions(driver).moveToElement(new WebDriverWait(driver,7).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Calendar')]")))).build().perform();
	new Actions(driver).moveToElement(new WebDriverWait(driver,7).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'New Event')]")))).click().build().perform();
   // new WebDriverWait(driver,15).until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'New Event')]"))).click();
}
public CompaniesPage clickOnCompaniesLink() {
	companiesLink.click();
	return new CompaniesPage();
}
@SuppressWarnings("deprecation")
public void clickOnNewCompany() {
	new Actions(driver).moveToElement(new WebDriverWait(driver,5).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Companies')]")))).build().perform();
	new Actions(driver).moveToElement(new WebDriverWait(driver,15).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'New Company')]")))).click().build().perform();
}
public ContactsPage clickonContactsLink() {
	contactsLink.click();
	return new ContactsPage();
}
public DealsPage clickonDealsLink() {
	dealsLink.click();
	return new DealsPage();
}
public TasksPage clickonTasksPage() {
	tasksLink.click();
	return new TasksPage();
}

}