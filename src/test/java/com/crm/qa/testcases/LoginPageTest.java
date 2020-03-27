	package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;

public LoginPageTest() {
	super(); //TestBase class constructor will be called and properties will be initialized
}
@BeforeMethod
public void setUp() {
	initialization();
	loginPage = new LoginPage();//Initialize LoginPage.java
}
@Test(priority = 1)
public void loginPageTitleTest() {
	logInfo("****************** Starting TestCase ******************");
	logInfo("****************** loginPageTitleTest ******************");
	String title = loginPage.validateLoginPageTitle();
	Assert.assertEquals(title, "CRMPRO - CRM software for customer relationship management, sales, and support.");
	logInfo("****************** Ending TestCase ******************");
	logInfo("****************** loginPageTitleTest ******************");
}
@Test(priority = 2)
public void crmLogoImageTest() {
	logInfo("****************** Starting TestCase ******************");
	logInfo("****************** crmLogoImageTest ******************");
	boolean flag = loginPage.validateCRMImage();
	Assert.assertTrue(flag);
	logInfo("****************** Ending TestCase ******************");
	logInfo("****************** loginPageTitleTest ******************");
}
@Test(priority = 3)
public void loginTest() {
	logInfo("****************** Starting TestCase ******************");
	logInfo("****************** loginTest ******************");
	homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	logInfo("****************** Ending TestCase ******************");
	logInfo("****************** loginPageTitleTest ******************");
}
@AfterMethod
public void tearDown() {
	driver.quit();
}
}
