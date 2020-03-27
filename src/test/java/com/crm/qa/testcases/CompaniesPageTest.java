package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.CompaniesPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class CompaniesPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	CompaniesPage companiesPage;
	TestUtil testUtil;
	
	public CompaniesPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchToFrame();
		//companiesPage = homePage.clickOnCompaniesLink();	
		}
	@Test(priority=1)
	public void validateClickOnNewCompany() {
		homePage.clickOnNewCompany();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
