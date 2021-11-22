package com.apc.kaiser.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.apc.kaiser.base.TestBase;
import com.apc.kaiser.pages.ClaimsSearch4Claims;
import com.apc.kaiser.pages.HomePage;
import com.apc.kaiser.pages.LoginPage;

public class ClaimsSearch4ClaimsTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	ClaimsSearch4Claims claimsSearch4Claims;

	private static Logger log =LogManager.getLogger(ClaimsSearch4ClaimsTest.class.getName());
	public ClaimsSearch4ClaimsTest() {
		super();
	}

	//test cases should be separated -- independent with each other
	//before each test case -- launch the browser and login
	//@test -- execute test case
	//after each test case -- close the browser
	
	@BeforeMethod
	public void setUp() {
		initialization();
//		testUtil = new TestUtil();
//		contactsPage = new ContactsPage();
		loginPage = new LoginPage();
		claimsSearch4Claims = new ClaimsSearch4Claims();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		homePage.claimsSearchTest();
		claimsSearch4Claims.claimsSearch4ClaimsVerify();
		
	}
	
	
//	@Test(priority=1)
//	public void verifyHomePageTitleTest(){
//		String homePageTitle = homePage.verifyHomePageTitle();
//		Assert.assertEquals(homePageTitle, "APC Oregon & SW Washington - Welcome page");
//	}
	
	@Test(priority=2)
	public void claimsSearchEnterDataTest(){
		homePage.claimsSearchTest();	
		claimsSearch4Claims.claimsSearch4ClaimsVerify();
		
		System.out.println("Reached claimsSearchTest ");
		log.info("Successfully ClaimsSearch4ClaimsTest");
	}
		
//	@Test(priority=3)
//	public void verifyContactsLinkTest(){
//		testUtil.switchToFrame();
//		contactsPage = homePage.clickOnContactsLink();
//	}
	
//	@AfterMethod
//	public void tearDown(){
//		driver.quit();
//	}
	
	

}

