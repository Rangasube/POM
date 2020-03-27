package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {

	//Page Factory - OR;
	@FindBy(xpath="//input[@placeholder='Username']")
	WebElement username;
	@FindBy(xpath="//input[@placeholder='Password']")
	WebElement password;
	@FindBy(xpath="//input[@class='btn btn-small']")
	WebElement loginBtn;
	@FindBy(xpath="//a[contains(text(),'Sign Up')]")
	WebElement signupBtn;
	@FindBy(xpath="//a[@class='navbar-brand']")
	WebElement crmLogo;

//Initializing the Page objects:
public LoginPage() {
	PageFactory.initElements(driver,this);
}
//Actions:
public String validateLoginPageTitle() {
	return driver.getTitle();
}
public boolean validateCRMImage() {
	return crmLogo.isDisplayed();
}
public HomePage login(String un, String pwd) {
	username.sendKeys(un);
	password.sendKeys(pwd);
	loginBtn.click();
	return new HomePage();
}
}