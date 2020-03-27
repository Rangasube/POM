package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.CalendarPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class CalendarPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	CalendarPage calendarPage;
	TestUtil testUtil;
	public CalendarPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchToFrame();
		calendarPage = homePage.clickOnCalendarLink();	
		}
	
	@Test(priority=1)
	public void validateEvent_Mon() {
		calendarPage.hoverOnEvent();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	
}


