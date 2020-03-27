package com.crm.qa.testcases;

/**
 * 
 * @author sharan
 */
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	TestUtil testUtil;
	String sheetName = "Contacts";
	
	public ContactsPageTest() {
		super();	
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchToFrame();
		contactsPage = homePage.clickonContactsLink();
		}
	@Test(priority=1)
	public void contactsPageLabelTest() {
		logInfo("****************** Starting TestCase ******************");
		logInfo("****************** loginPageTitleTest ******************");
		Assert.assertTrue(contactsPage.verifyContactsPageLabel(),"Contacts Page label is not displayed");
		logInfo("****************** Ending TestCase ******************");
		logInfo("****************** contactsPageLabelTest ******************");
	}
	@Test(priority=2)
	public void selectContactsByNameTest() {
		logInfo("****************** Starting TestCase ******************");
		logInfo("****************** selectContactsByNameTest ******************");
		contactsPage.selectContactsByName("Aishwarya J");
		contactsPage.selectContactsByName("Aselenium Aselenium");
		contactsPage.selectContactsByName("Aswin PC");
		contactsPage.selectContactsByName("David Chris");
		logInfo("****************** Ending TestCase ******************");
		logInfo("****************** selectContactsByNameTest ******************");
	}
	@Test(priority=3)
	public void selectAllContactsTest() {
		logInfo("****************** Starting TestCase ******************");
		logInfo("****************** selectAllContactsTest ******************");
		contactsPage.selectAllcontacts();
		logInfo("****************** Ending TestCase ******************");
		logInfo("****************** selectAllContactsTest ******************");
	}
	@DataProvider()
	public Object[][] getCRMTestData() {
		Object[][] data = TestUtil.getTestData(sheetName);
		return data;
	}
	@Test(priority=4, dataProvider="getCRMTestData")
	public void validateCreateNewContact(String title, String firstname, String secondname, String company){
		logInfo("****************** Starting TestCase ******************");
		logInfo("****************** validateCreateNewContact ******************");
		homePage.clickonContactsLink();
		//contactsPage.createNewContact("Mr.", "Mani", "Sharan", "Amz");
	    contactsPage.createNewContact(title, firstname, secondname, company);
	    logInfo("****************** Ending TestCase ******************");
		logInfo("****************** validateCreateNewContact ******************");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
