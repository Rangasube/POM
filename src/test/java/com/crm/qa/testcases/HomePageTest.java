package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TasksPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {
LoginPage loginPage;
HomePage homePage;
ContactsPage contactsPage;
DealsPage dealsPage;
TasksPage tasksPage;
TestUtil testUtil;

	public HomePageTest() {
		super();
	}
	
	/**
	 * test cases should be separated -- independent with each other
	 * before each test case -- launch the browser and login
	 * @test -- execute test case
	 * after each test case -- close the browser
	 **/
	
	@BeforeMethod
	public void setUp() {
	initialization();
	testUtil = new TestUtil();
	loginPage = new LoginPage();
	homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void HomePageTitleTest() {
		String homepageTitle = homePage.validateHomePageTitle();
		Assert.assertEquals(homepageTitle,"CRMPRO","HomePage Title is not matched"); //last argument displays message if testcase is failed.
	}
	@Test(priority=2)
	public void userNameLabelTest() {
		testUtil.switchToFrame();
		Assert.assertTrue(homePage.validateusernameLabel());
	}
	@Test(priority=3)
	public void logoTextTest() {
		testUtil.switchToFrame();
		Assert.assertTrue(homePage.validateLogoText(),"Logo not displayed");
	}
	@Test(priority=4)
	public void contactsPageTest() {
		testUtil.switchToFrame();
		contactsPage=homePage.clickonContactsLink();
	}
	@Test(priority=5)
	public void dealsPageTest() {
		testUtil.switchToFrame();
		dealsPage=homePage.clickonDealsLink();
	}
	@Test(priority=6)
	public void tasksPageTest() {
		testUtil.switchToFrame();
		tasksPage = homePage.clickonTasksPage();
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
