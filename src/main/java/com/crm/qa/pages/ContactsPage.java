package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase{

	//Page Factory : OR
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contactsPageLabel;
	@FindBy(xpath="//body//table//table//table//input[3]")
	WebElement newContactBtn;
	@FindBy(xpath="//select[@name='title']")
	WebElement titleSelect;
	@FindBy(xpath="//input[@name='first_name']")
	WebElement firstName;
	@FindBy(xpath="//input[@name='surname']")
	WebElement lastName;
	@FindBy(xpath="//input[@name='client_lookup']")
	WebElement company;
	@FindBy(xpath="//body/table/tbody/tr/td/table/tbody/tr/td/fieldset[@class='fieldset']/form[@id='contactForm']/table/tbody/tr/td/input[2]")
	WebElement saveBtn;
	public ContactsPage() {
		PageFactory.initElements(driver,this);
	}
	
	//Actions
	public boolean verifyContactsPageLabel() {
		return contactsPageLabel.isDisplayed();
	}
	public void selectContactsByName(String name) {
		driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
	}
	public void selectAllcontacts() {
		driver.findElement(By.xpath("//strong[text()='Name']//parent::td[@class='datatitle']//preceding-sibling::td[@class='datatitle']//input[@name='contact_id']")).click();
	}
	public void createNewContact(String title, String ftName,String ltName,String cmpny) {
	
		newContactBtn.click();
		//select salutation
		Select select = new Select(titleSelect);
		select.selectByVisibleText(title);
		//Entering Details
		firstName.sendKeys(ftName);
		lastName.sendKeys(ltName);
		company.sendKeys(cmpny);
		saveBtn.click();
	}

	
}
